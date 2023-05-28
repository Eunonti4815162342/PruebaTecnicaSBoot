package com.ohtic.rest.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ohtic.rest.facade.services.PriceService;
import com.ohtic.rest.persistence.entity.PriceEntity;
import com.ohtic.rest.persistence.repository.PriceRepository;
import com.ohtic.rest.utils.Utiles;

@RestController
@RequestMapping("/api")
public class PriceController {

	@Autowired
	private PriceRepository repository;
	@Autowired
	private PriceService priceService;

	@GetMapping("/saludos")
	public String saludos() {
		return "Hola";
	}

	@GetMapping("/prices")
	public List<PriceEntity> allPrices() {
		return repository.findAll();
	}

	@GetMapping("/pricesFilter")
	public ResponseEntity<List<PriceEntity>> getPriceByParams(
			@RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
			@RequestParam("productId") String productId,
			@RequestParam(value = "brandId", required = false) Integer brandId) {

		List<PriceEntity> prices = priceService.findPricesByParams(Utiles.localDateTimeToDate(date), productId,
				brandId);

		if (prices.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(prices, HttpStatus.OK);
		}
	}

}