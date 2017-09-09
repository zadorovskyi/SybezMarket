package org.sybez.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sybez.dao.entity.PostDepartment;
import org.sybez.dao.repository.PostDepartmentRepository;

@Service
public class PostDepartment_Service implements InterfaseForDbServices<PostDepartment> {

	@Autowired
	private PostDepartmentRepository postDepartmentRepository;

	public List<PostDepartment> getAll() {
		return postDepartmentRepository.findAll();
	}

	public PostDepartment getById(int id) {
		return postDepartmentRepository.getOne(id);
	}

	public PostDepartment addNew(PostDepartment item) {
		PostDepartment newpostDep = postDepartmentRepository.save(item);
		return newpostDep;
	}

	public void deleteById(int id) {
		postDepartmentRepository.delete(id);
	}

	public void updateItem(PostDepartment t) {
		postDepartmentRepository.save(t);
	}
	
}
