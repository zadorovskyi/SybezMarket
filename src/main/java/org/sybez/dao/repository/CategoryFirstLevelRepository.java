package org.sybez.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.sybez.dao.entity.CategoryFirstLevel;
import org.sybez.dao.entity.CategorySecondLevel;

@Repository
public interface CategoryFirstLevelRepository extends JpaRepository<CategoryFirstLevel, Integer> {

	@Query("select p from CategoryFirstLevel p where p.categoryFirstLevelName= :name")
	public CategoryFirstLevel findCatByName(@Param("name")String name);
		
		
}
