package org.sybez.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.sybez.dao.entity.CategoryFirstLevel;
import org.sybez.dao.entity.CategorySecondLevel;

@Repository
public interface CategorySecondLevelRepository extends JpaRepository<CategorySecondLevel, Integer> {

	@Query("Select c  from CategorySecondLevel c JOIN FETCH c.categoryFirstLevel catFirst where catFirst.id =:id")
	public List<CategorySecondLevel> findAllCategoriesSecondLevelInCategoryFirstLevelByIdFirstLev(@Param("id") int id);
	
	@Query("select p from CategorySecondLevel p where p.categorySecondLevelName= :name")
	public CategorySecondLevel findCatByName(@Param("name")String name);
}
