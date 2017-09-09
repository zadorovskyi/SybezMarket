package org.sybez.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sybez.dao.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query("select c from Client c JOIN c.clientName cClientname where cClientname.clientName=:name")
	public Client findByName (@Param("name")String name);
	
}
