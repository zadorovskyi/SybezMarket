package org.sybez.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sybez.dao.entity.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer>{


}
