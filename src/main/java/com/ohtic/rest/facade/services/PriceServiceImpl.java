package com.ohtic.rest.facade.services;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohtic.rest.persistence.entity.PriceEntity;
import com.ohtic.rest.persistence.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {
	@Autowired
	private PriceRepository priceRepository;

	@Override
	public List<PriceEntity> findPricesByParams(Date date, String productId, Integer brandId) {
		List<PriceEntity> prices = priceRepository.findPricesByFilter(date, productId, brandId);
		Stream<PriceEntity> filteredStream = Stream.concat(prices.stream().filter(p -> p.getPriority() == 1),
				prices.stream().filter(p -> p.getPriority() == 0));
		Optional<PriceEntity> price = filteredStream.findFirst();
		return price.map(Collections::singletonList).orElseGet(Collections::emptyList);
	}
}
