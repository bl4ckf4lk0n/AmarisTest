# AmarisTest
Aplicación de test para proceso de selección en Amaris

Esta aplicación expone una API Rest con las siguientes operaciones:

* /test/prices
  * La operación admite los siguientes "query parameters":
    * product_id: Valor Entero que identifica a un producto
    * brand_id: Valor Entero que identifica una marca
    * date: String cuyo valor es una fecha con el formato ISO 8601 (yyyy-MM-ddTHH:mm:ss.SSSZ)
  * Ejemplo: /test/prices?product_id=35455&brand_id=1&date=2020-06-15T10:00:00.000Z
