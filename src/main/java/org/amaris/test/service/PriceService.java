package org.amaris.test.service;

import org.amaris.test.model.Prices;

import java.util.Date;
import java.util.Optional;

/**
 * Esta clase define un servicio para la obtención de tarifas y precios de la base de datos.
 */
public interface PriceService {
    /**
     * Método para la obtención de un precio/tarifa filtrado por los parámetros definidos.
     * @param productId Define el identificador de la cadena de grupo sobre la que realizar la búsqueda.
     * @param brandId Define el identificador de producto sobre el que realizar la búsqueda.
     * @param date Define la fecha a aplicar para realizar la búsqueda.
     * @return Retorna el precio/tarifa obtenido.
     */
    Optional<Prices> retrievePrice(Integer productId, Integer brandId, Date date);
}
