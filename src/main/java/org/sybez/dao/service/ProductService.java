package org.sybez.dao.service;

import java.awt.PageAttributes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sybez.dao.entity.IsAvaliable;
import org.sybez.dao.entity.Maker;
import org.sybez.dao.entity.Product;
import org.sybez.dao.repository.ProductRepository;
import org.sybez.service.editor.AllNamesEditor;

@Service
public class ProductService  {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	CategorySecondLevelService categorySecondLevelService;
	@Autowired
	MakerService makerService;

	public ProductService() {
	}
	
	public Product creatingNewProductEntityWithUniqueId(Product newProduct) {
		if (getById(newProduct.getId()) != null) {
			newProduct.setId(getMaxIdValue()+1);
		}
		return newProduct;
	}

	public List<Product> getAllProducts() {
		Page<Product> page = productRepository.findAll(new PageRequest(0, 5, Direction.ASC, "productPrice"));
		return page.getContent();
	}

	public Product getById(int id) {
		return productRepository.getOne(id);
	}

	public List<Product> getProductByIdOfSecondCat(int id) {
		return productRepository.findProductByIdOfSecondCat(id,new PageRequest(0, 5, Direction.ASC, "productPrice"));
		
	}
@Transactional
	public Product saveProduct(int categorySecondLevelId, String productName, String productPrice,
			String productImageUrl, String productDisription, int makerId) {
		Product newProduct = new Product();
		newProduct.setAvaliable(IsAvaliable.AVAILABLE);
		newProduct.setDiscription(productDisription);
		newProduct.setImageUrl(productImageUrl);
		newProduct.setProductName(AllNamesEditor.toFirstCapitalLetter(productName));
		newProduct.setProductPrice(Integer.parseInt(productPrice));
		newProduct.setCategorySecondLevel(categorySecondLevelService.getById(categorySecondLevelId));
		productRepository.save(newProduct);
		Maker maker = makerService.getById(makerId);
		
		newProduct.setMakers(makerService.getById(makerId));
		productRepository.save(newProduct);
		return newProduct;
	}

	public Product saveProduct(Product product) {
		if(product.getIsAvaliable()==null){
		product.setAvaliable(IsAvaliable.AVAILABLE);
		}
		return productRepository.save(product);
		
	}

	public boolean deleteProduct(int id) {
		productRepository.delete(id);
		return true;
	}
	public int getMaxIdValue(){
		return productRepository.findMaxIdValue();
	}
}
