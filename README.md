CONVERSOR DE MONEDAS 
-----------------------
DESCRIPCION DEL PROYECTO
 - - - - - - -- --- - - -
Esta aplicación fué la tarea (Challenge) en ONE (Oracle Next Eucation) en la formación de Java orientado a objetos.
En este proyecto se incluyeron procesos muy importantes de programación en Java.
Definición y uso de Modelos
Definición y uso de una API
Uso de Biblioteca Gson.jar
Definición y uso de clase tipo record
Manejo de errores/excepciones
Realizando el proyecto me enfoqué a:

Hacer las clases modelos independientes
cubrir todos los requerimientos del Challenge e
implementar las mejoras:
el usuario puede pedir la conversión entre cualquieras dos monedas que cubre exchangerate-API.com
se guardan todas las conversiones y se imprime el reporte en el final
en el reporte se incluye la fecha y la hora de cada conversión
_________________
FUNCIONAMIENTO
______________
El programa primero recurre a la clase Datos.java para pedir los datos al usuario acerca del tipo de conversion que desea realizar
despues realiza la busqueda de la moneda en la clase Busqueda.java donde se recure a la API  de exchangerate-API.com. Donde este nos devuelve 
una archivo Json que es convertido y pasada hacia el regitro ConversionGson.java, finalmente se la Clase Conversion.java solicita los datos para relizar la conversion
y arroja los datos de la conversion de moneda.
__________________
TECNOLOGÍAS USADAS
__________________
- La aplicación está hecha en Java SE17.
- Para desarollar el código usé IntelliJ.
- Para escribir este README me ajudó el web editor de GitHub
