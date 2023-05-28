package com.ohtic.rest.facade.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ohtic.rest.persistence.entity.PriceEntity;

@Service
public interface PriceService {

	public List<PriceEntity> findPricesByParams(Date date, String productId, Integer brandId);
}
