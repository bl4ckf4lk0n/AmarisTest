package org.amaris.test.controller;

import org.amaris.test.dto.ResponseDto;
import org.amaris.test.model.Prices;
import org.amaris.test.service.PriceService;
import org.amaris.test.service.impl.PriceServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

/**
 * Esta clase define un controlador rest el cual implementa un método para la obtención de precios y tarifas a aplicar
 * @author Adrián Escolano Díaz
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("test")
public class TestController {

    private final PriceService priceService;

    /**
     * Constructor de la clase. Permite la inyección de Beans para su uso en los métodos de esta clase.
     * @param priceService Bean de tipo Service para la obtención de precios y tarifas.
     */
    public TestController(final PriceServiceImpl priceService) {
        this.priceService = priceService;
    }

    /**
     * Método para la obtención de precios y tarifas a partir de los parámetros descritos.
     * @param product_id Define el identificador de producto sobre el que realizar la búsqueda de precios y tarifas.
     * @param brand_id Define el identificador de la cadena de grupo sobre el que realizar la búsqueda de precios y tarifas.
     * @param date Define la fecha a aplicar para la obtención de precios y tarifas.
     * @return Retorna un objeto que define el valor de el precio/tarifa resultante de la búsqueda.
     * @throws ResponseStatusException con código HTTP 404 en el caso de que la búsqueda no devuelva ningún resultado.
     */
    @GetMapping(path = "/prices",produces="application/json")
    public ResponseDto getPrice(@RequestParam Integer product_id,
                                @RequestParam Integer brand_id,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date) {
        Optional<Prices> price = priceService.retrievePrice(product_id, brand_id, date);
        if(price.isPresent()) {
            ResponseDto response = new ResponseDto(
                    price.get().getProduct_id(),
                    price.get().getBrand_id(),
                    price.get().getPrice_list(),
                    price.get().getStart_date(),
                    price.get().getEnd_date(),
                    price.get().getPrice()
            );
            return response;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Entity not found"
            );
        }

    }

}
