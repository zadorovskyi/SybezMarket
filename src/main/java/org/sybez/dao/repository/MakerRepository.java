package org.sybez.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sybez.dao.entity.Maker;

public interface MakerRepository extends JpaRepository<Maker, Integer> {

	@Query("select m from Maker m where m.makerName=:name")
	public Maker findByName(@Param("name") String name);

}
