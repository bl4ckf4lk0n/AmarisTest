package org.amaris.test.service.impl;

import org.amaris.test.model.Prices;
import org.amaris.test.repository.PriceRepository;
import org.amaris.test.service.PriceService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa el servicio PriceService para la obtención de tarifas y precios de la base de datos.
 */
@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    /**
     * Constructor de la clase. Permite la inyección de Beans para su uso en los métodos de esta clase.
     * @param priceRepository Bean de tipo Repository para la búsqueda de datos en la base de datos.
     */
    public PriceServiceImpl(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Prices> retrievePrice(Integer productId, Integer brandId, Date date) {
        Timestamp ts = new Timestamp(date.getTime());
        List<Prices> pricesList = priceRepository.findPrice(brandId, productId, ts);
        return pricesList.stream().findFirst();
    }
}
