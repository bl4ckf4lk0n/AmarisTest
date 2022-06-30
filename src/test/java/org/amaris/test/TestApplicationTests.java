package org.amaris.test;

import org.amaris.test.dto.ResponseDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Clase que define los tests de integración a realizar.
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestApplicationTests {

	@LocalServerPort
	private int port;
	private TestRestTemplate restTemplate = new TestRestTemplate();

	/**
	 * Test para comprobar que el contexto de Spring Boot arranca correctamente
	 */
	@Test
	void contextLoads(ApplicationContext context) {
		assertThat(context).isNotNull();
	}

	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	 */
	@Test
	void Test1() {
		Map<String,String> parameters = Map.of(
				"product_id", "35455",
				"brand_id", "1",
				"date", "2020-06-14T10:00:00.000Z"
		);

		ResponseEntity<ResponseDto> response = restTemplate.getForEntity(createUrl(), ResponseDto.class, parameters);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getProduct_id()).isEqualTo(35455);
		assertThat(response.getBody().getBrand_id()).isEqualTo(1);
		assertThat(response.getBody().getPrice_list()).isEqualTo(1);
		assertThat(response.getBody().getStart_date()).isEqualTo(Date.from(Instant.parse("2020-06-14T00:00:00.000Z")));
		assertThat(response.getBody().getEnd_date()).isEqualTo(Date.from(Instant.parse("2020-12-31T23:59:59.000Z")));
		assertThat(response.getBody().getPrice().toString()).isEqualTo("35.50");
	}

	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void Test2() {
		Map<String,String> parameters = Map.of(
				"product_id", "35455",
				"brand_id", "1",
				"date", "2020-06-14T16:00:00.000Z"
		);

		ResponseEntity<ResponseDto> response = restTemplate.getForEntity(createUrl(), ResponseDto.class, parameters);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getProduct_id()).isEqualTo(35455);
		assertThat(response.getBody().getBrand_id()).isEqualTo(1);
		assertThat(response.getBody().getPrice_list()).isEqualTo(2);
		assertThat(response.getBody().getStart_date()).isEqualTo(Date.from(Instant.parse("2020-06-14T15:00:00.000Z")));
		assertThat(response.getBody().getEnd_date()).isEqualTo(Date.from(Instant.parse("2020-06-14T18:30:00.000Z")));
		assertThat(response.getBody().getPrice().toString()).isEqualTo("25.45");
	}

	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void Test3() {
		Map<String,String> parameters = Map.of(
				"product_id", "35455",
				"brand_id", "1",
				"date", "2020-06-14T21:00:00.000Z"
		);

		ResponseEntity<ResponseDto> response = restTemplate.getForEntity(createUrl(), ResponseDto.class, parameters);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getProduct_id()).isEqualTo(35455);
		assertThat(response.getBody().getBrand_id()).isEqualTo(1);
		assertThat(response.getBody().getPrice_list()).isEqualTo(1);
		assertThat(response.getBody().getStart_date()).isEqualTo(Date.from(Instant.parse("2020-06-14T00:00:00.000Z")));
		assertThat(response.getBody().getEnd_date()).isEqualTo(Date.from(Instant.parse("2020-12-31T23:59:59.000Z")));
		assertThat(response.getBody().getPrice().toString()).isEqualTo("35.50");
	}

	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void Test4() {
		Map<String,String> parameters = Map.of(
				"product_id", "35455",
				"brand_id", "1",
				"date", "2020-06-15T10:00:00.000Z"
		);

		ResponseEntity<ResponseDto> response = restTemplate.getForEntity(createUrl(), ResponseDto.class, parameters);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getProduct_id()).isEqualTo(35455);
		assertThat(response.getBody().getBrand_id()).isEqualTo(1);
		assertThat(response.getBody().getPrice_list()).isEqualTo(3);
		assertThat(response.getBody().getStart_date()).isEqualTo(Date.from(Instant.parse("2020-06-15T00:00:00.000Z")));
		assertThat(response.getBody().getEnd_date()).isEqualTo(Date.from(Instant.parse("2020-06-15T11:00:00.000Z")));
		assertThat(response.getBody().getPrice().toString()).isEqualTo("30.50");
	}

	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void Test5() {
		Map<String,String> parameters = Map.of(
				"product_id", "35455",
				"brand_id", "1",
				"date", "2020-06-16T21:00:00.000Z"
		);

		ResponseEntity<ResponseDto> response = restTemplate.getForEntity(createUrl(), ResponseDto.class, parameters);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getProduct_id()).isEqualTo(35455);
		assertThat(response.getBody().getBrand_id()).isEqualTo(1);
		assertThat(response.getBody().getPrice_list()).isEqualTo(4);
		assertThat(response.getBody().getStart_date()).isEqualTo(Date.from(Instant.parse("2020-06-15T16:00:00.000Z")));
		assertThat(response.getBody().getEnd_date()).isEqualTo(Date.from(Instant.parse("2020-12-31T23:59:59.000Z")));
		assertThat(response.getBody().getPrice().toString()).isEqualTo("38.95");
	}

	/**
	 * Extra test: petición a las 00:00 del día 13 del producto 35455   para la brand 1 (ZARA).
	 * Debe devolver el código HTTP 404 (NOT FOUND) ya que no existen registros en la base de datos que coincidan con los parámetros definidos.
	 */
	@Test
	void ExtraTest() {
		Map<String,String> parameters = Map.of(
				"product_id", "35455",
				"brand_id", "1",
				"date", "2020-06-13T00:00:00.000Z"
		);

		ResponseEntity<ResponseDto> response = restTemplate.getForEntity(createUrl(), ResponseDto.class, parameters);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	private String createUrl() {
		String url = "http://localhost:"
				.concat(String.valueOf(this.port))
				.concat("/test/prices");

		return UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("product_id", "{product_id}")
				.queryParam("brand_id", "{brand_id}")
				.queryParam("date", "{date}")
				.encode()
				.toUriString();
	}
}
