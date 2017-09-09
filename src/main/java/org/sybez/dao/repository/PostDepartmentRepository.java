package org.sybez.dao.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sybez.dao.entity.PostDepartment;

public interface PostDepartmentRepository extends JpaRepository<PostDepartment, Integer> {

}
