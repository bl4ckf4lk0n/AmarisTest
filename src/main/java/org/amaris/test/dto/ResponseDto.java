package org.amaris.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase DTO que define los datos de precios/tarifas a retornar por la operación '/prices' de la API Rest.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private Integer product_id;
    private Integer brand_id;
    private Integer price_list;
    private Date start_date;
    private Date end_date;
    private BigDecimal price;
}
