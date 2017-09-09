package org.sybez.dao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.sybez.dao.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

@Query("Select p from Product p JOIN  p.categorySecondLevel categorySecond where categorySecond.id=:id")
public List<Product> findProductByIdOfSecondCat(@Param("id")int id,Pageable pageble);

@Query("Select Max(p.id) From Product p")
public int findMaxIdValue();
}
