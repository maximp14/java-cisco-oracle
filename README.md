# java-cisco-oracle
Trabajo Curso de la UTN CISCO ORACLE JAVA INTERMEDIO

Trabajo final del curso intensivo de ORACLE CISCO de la UTN de Cordoba Capital, faltan retoques pero esta muy avanzado.


Trabajo Práctico Final
Java Intermedio
El trabajo que se debe presentar, va a simular la administración del sistema de canje de puntos
“HiperPuntos” del BAA (Banco Acme Argentina). Los puntos los obtiene el cliente del sistema
mediante los consumos que realice con su tarjeta de crédito. El sistema debe mantener, en una base
de datos, el saldo (en puntos) de cada cliente. Por ejemplo:
1) Cliente: 001, DNI: 99.123.123, Nombre y Apellido: Nelson Fuentes, tel: 0351-4568978, mail:
nelson.fuentes@gmail.com, Saldo: 35.000 puntos
2) Cliente: 002, DNI: 99.444.222, Nombre y Apellido: Alberto David, tel: 0351-4785236 mail:
alberto.david@gmail.com, Saldo: 124.000 puntos
Además, el sistema, debe mantener un listado de productos que cada cliente puede canjear por sus
puntos, junto con el stock disponible de cada uno. Por ejemplo:
1) Viaje al Caribe: 100.000 puntos, 2 disponibles
2) SmartTV 43” UHD: 75.000 puntos, 10 disponibles
3) Plancha 2000w: 575 puntos, 37 disponibles
El sistema a desarrollar debe:
1. Permitir dar de alta nuevos clientes en el sistema, validando que:
1. El email sea de la forma: <nombre de cuenta>@<dominio>.com.ar
2. El teléfono sea de la forma: (<codigo area>) - <número>
2. Permitir dar de alta nuevos productos y modificar existentes
3. Revisar (de forma permanente, con un hilo), el contenido del directorio “transacciones”.
Cada vez que encuentre un archivo de extensión .csv, interpretará que ese archivo contiene
una línea por cada vez que se incrementa el puntaje de un cliente. La siguiente línea, por
ejemplo, significaría que al cliente DNI: 29.777.333, se le agregan 35 puntos, por haber
comprado en el comercio “Kiosco WEC”:
29777333;35;Kiosco WEC
1. Cada vez que se termine de procesar un archivo, ese archivo debe moverse a la carpeta
“procesados”
4. Permitirle a un cliente realizar un canje, validando que haya stock suficiente y que el cliente
tenga saldo suficiente para realizar la operación
1. Cada vez que un producto no disponga de stock debe agregarse un registro a la tabla
“SolicitudesCompras”, con los detalles del producto a reponer
5. Generar, a pedido, un reporte de actividad para un cliente solicitado.
6. Generar, a pedido, un reporte de todos los productos a reponer, ordenados alfabéticamente
por descripción del producto
