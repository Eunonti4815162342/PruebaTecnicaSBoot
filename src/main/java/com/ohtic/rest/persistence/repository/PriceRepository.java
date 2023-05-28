package com.ohtic.rest.persistence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ohtic.rest.persistence.entity.PriceEntity;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
	@Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND p.startDate <= :date AND p.endDate >= :date AND p.brandId = :brandId  ORDER BY p.priority DESC")
	List<PriceEntity> findPricesByFilter(Date date, String productId, Integer brandId);

}
