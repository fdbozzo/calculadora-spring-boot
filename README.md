# Calculadora con Spring-Boot y Maven
Microservicio de calculadora usando Spring-Boot, Maven y una librería tracer para logging


### Comunicación a través de API REST:  
`GET http://localhost:8080/api/v1/calculadora/sumar?num1=5.01&num2=2.13`  
`GET http://localhost:8080/api/v1/calculadora/restar?num1=5.01&num2=2.13`  

### Software  

Las versiones de software utilizadas para desarrollar son las siguientes:  
Maven 3.8.6  
JAVA 11.0.2  
Ubuntu Linux 22.04  
IntelliJ IDEA 2022.2.2 (Community Edition)  

## Pasos a Seguir  

A través de una consola o terminal:

1. Descargar el repositorio github

```
git clone https://github.com/fdbozzo/calculadora-spring-boot
cd calculadora-spring-boot
```

2. Ejecutar verificación e instalación de Maven

```
mvn validate
mvn verify
mvn clean install
```

3. Ejecutar el JAR de la carpeta /target


```
java -jar target/calculadora-0.0.1-SNAPSHOT.jar
```


## API REST  

Con los pasos anteriores debemos tener una API REST escuchando en `http://localhost:8080/api/v1/calculadora/`  

Se pueden realizar consultas con los parámetros siguientes:  

- `num1` Primer numero de la operación  
- `num2` Segundo numero de la operación  
- `operacion` Operación a realizar (Valores aceptados: `sumar`, `restar`)  


### Ejemplo de uso:  

`http://localhost:8080/api/v1/calculadora/sumar?num1=5.01&num2=2.13`

El resultado será un JSON conteniendo en el campo 'result' un valor numérico con decimales, en el caso del ejemplo ( 5.01 + 2.13 = `7.14` )

### Respuesta de ejemplo:  
```
{
  "result": 7.14
}
```
