package org.amaris.test.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Modelo asociado a la tabla PRICES de la base de datos.
 */
@Entity
@Data
public class Prices {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer brand_id;
    private Timestamp start_date;
    private Timestamp end_date;
    private Integer price_list;
    private Integer product_id;
    private Integer priority;
    private BigDecimal price;
    private String curr;
}
