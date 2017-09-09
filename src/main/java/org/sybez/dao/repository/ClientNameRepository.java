package org.sybez.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sybez.dao.entity.ClientName;

public interface ClientNameRepository extends JpaRepository<ClientName, Integer> {

	@Query("select p from ClientName p where p.clientName=:name")
	public ClientName getByName(@Param("name") String name);
}
