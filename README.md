# pruebaTecnicaCSTI
Prueba Csti

### H2 
* Driver Class:	org.h2.Driver
* JDBC URL:	jdbc:h2:mem:~/pruebas
* User Name: sa
* Password:	

* http://localhost:8000/h2

### Para abrir Swagger 
http://localhost:8000/swagger-ui.html

### Docker
* Ejecutar docker (En la raiz del proyecto, abrir consola y escribir):
  * docker build -t superheroes-api .

* Luego escribir:
  * docker run -it --rm -p 8000:8000 superheroes-api

### Servicios
* Registrar un activo:
  * Método: POST
  * URL: http://localhost:8000/assets
  * Cuerpo (raw, JSON):
{
    "serialNumber": "123456789",
    "description": "Laptop",
    "name": "Dell XPS 13",
    "purchaseDate": "2022-01-01",
    "purchaseValue": 1500.00,
    "depreciationRate": 0.04
}
  * Pruebas:
    * Verificar que la respuesta tenga un código de estado 201 (Created).
    * Verificar que el cuerpo de la respuesta contenga los datos del activo registrado correctamente.
      
* Actualizar un activo:
  * Método: PUT
  * URL: http://localhost:8000/assets/{assetId}
    * (reemplaza {assetId} con el ID real del activo)
  * Cuerpo (raw, JSON):   
{
    "serialNumber": "987654321",
    "description": "Laptop",
    "name": "HP Spectre x360",
    "purchaseDate": "2022-01-01",
    "purchaseValue": 2000.00,
    "depreciationRate": 0.05
}
  * Pruebas:
    * Verificar que la respuesta tenga un código de estado 200 (OK).
    * Verificar que el cuerpo de la respuesta contenga los datos del activo actualizado correctamente.

* Eliminar un activo:
  * Método: DELETE
  * URL: http://localhost:8000/assets/{assetId}
    * (reemplaza {assetId} con el ID real del activo)
  * Pruebas:
    * Verificar que la respuesta tenga un código de estado 204 (No Content).
  * Verificar que el cuerpo de la respuesta esté vacío.

* Calcular la depreciación de un activo:
  * Método: GET
  * URL: http://localhost:8000/assets/{assetId}/depreciation
    * (reemplaza {assetId} con el ID real del activo)
  * Pruebas:
    * Verificar que la respuesta tenga un código de estado 200 (OK).
    * Verificar que el cuerpo de la respuesta contenga el valor de depreciación calculado correctamente.
   
* Obtener todos los activos:
  * Método: GET
  * URL: http://localhost:8000/assets
  * Pruebas:
    * Verificar que la respuesta tenga un código de estado 200 (OK).
    * Verificar que el cuerpo de la respuesta contenga una lista de activos correctamente.

### Diagramas

![Exitoso](https://github.com/javf1016/Images/blob/main/clases.PNG?raw=true)
![Exitoso](https://github.com/javf1016/Images/blob/main/paquetes.PNG?raw=true)
![Exitoso](https://github.com/javf1016/Images/blob/main/componentes.PNG?raw=true)
![Exitoso](https://github.com/javf1016/Images/blob/main/secuencia.PNG?raw=true)
