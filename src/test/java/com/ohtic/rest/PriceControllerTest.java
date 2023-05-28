package com.ohtic.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.ohtic.rest.persistence.entity.PriceEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	long productId = 35455L;
	long brandId = 1L;
	LocalDateTime dateTimeTest1, dateTimeTest2, dateTimeTest3, dateTimeTest4, dateTimeTest5;
	Double pricesTest1, pricesTest2, pricesTest3, pricesTest4, pricesTest5;

	@BeforeEach
	public void setup() {
		productId = 35455L;
		brandId = 1L;
		dateTimeTest1 = LocalDateTime.of(2020, 6, 14, 10, 0);
		dateTimeTest2 = LocalDateTime.of(2020, 6, 14, 16, 0);
		dateTimeTest3 = LocalDateTime.of(2020, 6, 14, 21, 0);
		dateTimeTest4 = LocalDateTime.of(2020, 6, 15, 10, 0);
		dateTimeTest5 = LocalDateTime.of(2020, 6, 16, 21, 0);
		pricesTest1 = 35.5;
		pricesTest2 = 25.45;
		pricesTest3 = 35.5;
		pricesTest4 = 30.5;
		pricesTest5 = 38.95;

	}

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/saludos", String.class))
				.contains("Hola");
	}

	@Test
	public void testRequest1() throws JSONException {
		List<PriceEntity> responseBody = getRequest(dateTimeTest1, productId, brandId).getBody();
		assertNotNull(responseBody);
		assertFalse(responseBody.isEmpty());
		for (PriceEntity price : responseBody) {
			assertThat(price.getPrice(), equalTo(pricesTest1));
		}
	}

	@Test
	public void testRequest2() throws JSONException {
		List<PriceEntity> responseBody = getRequest(dateTimeTest2, productId, brandId).getBody();
		assertNotNull(responseBody);
		assertFalse(responseBody.isEmpty());
		for (PriceEntity price : responseBody) {
			assertThat(price.getPrice(), equalTo(pricesTest2));
		}
	}

	@Test
	public void testRequest3() throws JSONException {
		List<PriceEntity> responseBody = getRequest(dateTimeTest3, productId, brandId).getBody();
		assertNotNull(responseBody);
		assertFalse(responseBody.isEmpty());
		for (PriceEntity price : responseBody) {
			assertThat(price.getPrice(), equalTo(pricesTest3));
		}
	}

	@Test
	public void testRequest4() throws JSONException {
		List<PriceEntity> responseBody = getRequest(dateTimeTest4, productId, brandId).getBody();
		assertNotNull(responseBody);
		assertFalse(responseBody.isEmpty());
		for (PriceEntity price : responseBody) {
			assertThat(price.getPrice(), equalTo(pricesTest4));
		}
	}

	@Test
	public void testRequest5() throws JSONException {
		List<PriceEntity> responseBody = getRequest(dateTimeTest5, productId, brandId).getBody();
		assertNotNull(responseBody);
		assertFalse(responseBody.isEmpty());
		for (PriceEntity price : responseBody) {
			assertThat(price.getPrice(), equalTo(pricesTest5));
		}
	}

	public ResponseEntity<List<PriceEntity>> getRequest(LocalDateTime dateTime, long productId, long brandId) {
		String url = "http://localhost:" + port + "/api/pricesFilter?date=" + dateTime + "&productId=" + productId
				+ "&brandId=" + brandId;
		ResponseEntity<List<PriceEntity>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PriceEntity>>() {
				});
		return response;

	}

}
