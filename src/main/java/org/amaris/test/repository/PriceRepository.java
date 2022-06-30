package org.amaris.test.repository;

import org.amaris.test.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Esta clase define un repositorio JPA para la conexión y obtención de datos de la tabla PRICES alojada en la base de datos.
 */
@Repository
public interface PriceRepository extends JpaRepository<Prices, Integer> {
    /**
     * Este método permite la obtención de datos procedentes de la tabla PRICES filtrados por los parámetros definidos.
     * @param brandId Define el identificador de producto sobre el que realizar la búsqueda.
     * @param productId Define el identificador de la cadena de grupo sobre la que realizar la búsqueda.
     * @param date Define la fecha a aplicar para realizar la búsqueda.
     * @return Retorna la lista de precios resultante de la búsqueda realizada.
     */
    @Query("select p from Prices p where p.brand_id = ?1 and p.product_id = ?2 and (?3 between p.start_date and p.end_date) order by p.priority desc")
    List<Prices> findPrice(Integer brandId, Integer productId, Timestamp date);
}
