# Sistema Web Autoadaptativo (Arquitectura MAPE-K)

## Descripción general
Plataforma web educativa desarrollada en Java con Javalin y Maven, diseñada para autoadaptarse según el nivel de tráfico. El sistema reduce el consumo de recursos cambiando entre tres modos de presentación (Multimedia, Restringido y Texto) al detectar alta demanda.

## Instrucciones de instalación y ejecución
1. Clonar el repositorio.
2. Abrir una terminal en la raíz del proyecto.
3. Compilar y ejecutar el proyecto utilizando Maven:
   ```bash
4. Acceder en el navegador a http://localhost:7000/content.


Componentes MAPE-K implementados
Monitor: Intercepta cada solicitud al endpoint /content, registra el tráfico incrementando un contador y notifica al Analyzer.

Analyze: Evalúa la cantidad de solicitudes actuales comparándolas contra los umbrales configurados en el Knowledge para determinar el nivel de demanda (Baja, Media, Alta).

Plan: Recibe el nivel de demanda y decide qué acción tomar: mantener el modo MULTIMEDIA, o cambiar a RESTRICTED o TEXT.

Execute: Aplica la decisión del Planner, modificando el estado global del sistema para que el controlador web renderice la vista adecuada.


El componente Knowledge fue implementado como un Singleton en memoria respaldado por el archivo application.properties. Al iniciar, lee los umbrales restricted.threshold=10 y text.threshold=20, manteniendo además el estado actual del modo y el contador de peticione


para cargar 1..25 | ForEach-Object { curl.exe -s http://localhost:7000/content }

¡Perfecto! Esa consola está impecable. El registro es exactamente lo que pide la rúbrica para el Entregable 6. Se ve con total claridad cómo el sistema respeta los umbrales configurados: gatilla el modo RESTRICTED exactamente en la petición 10 y pasa a modo TEXT en la 20.

Para terminar el taller y asegurar todo el puntaje, esto es lo que falta:

**1. Guarda la evidencia (Entregables 5 y 6)**

* Tómale un recorte a esa misma consola que me acabas de mandar y guárdala como imagen.
* Abre tu navegador en `http://localhost:7000/content`, tómale una captura de pantalla a la página web, y luego usa el comando de PowerShell o recarga la página para tomarle fotos a los otros dos modos (cuando quita el video y cuando muestra el mensaje rojo). Así tienen el punto de las capturas listo. *(Si necesitas reiniciar el contador, solo entra a `http://localhost:7000/reset`)*.

**2. El README.md (Entregable 3)**
Para agilizar el cierre del trabajo, te redacté la estructura base del archivo `README.md` cumpliendo con todos los puntos que exige el documento. Puedes pasársela a Joaquín y Abraham para que le den una revisión final y la agreguen a la raíz del proyecto:

```markdown
# Sistema Web Autoadaptativo (Arquitectura MAPE-K)

## Descripción general
Plataforma web educativa desarrollada en Java con Javalin y Maven, diseñada para autoadaptarse según el nivel de tráfico. El sistema reduce el consumo de recursos cambiando entre tres modos de presentación (Multimedia, Restringido y Texto) al detectar alta demanda.

## Instrucciones de instalación y ejecución
1. Clonar el repositorio.
2. Abrir una terminal en la raíz del proyecto.
3. Compilar y ejecutar el proyecto utilizando Maven:
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="cl.ucn.app.main.Main"

```

4. Acceder en el navegador a `http://localhost:7000/content`.

## Componentes MAPE-K implementados

* **Monitor**: Intercepta cada solicitud al endpoint `/content`, registra el tráfico incrementando un contador y notifica al Analyzer.
* **Analyze**: Evalúa la cantidad de solicitudes actuales comparándolas contra los umbrales configurados en el Knowledge para determinar el nivel de demanda (Baja, Media, Alta).
* **Plan**: Recibe el nivel de demanda y decide qué acción tomar: mantener el modo MULTIMEDIA, o cambiar a RESTRICTED o TEXT.
* **Execute**: Aplica la decisión del Planner, modificando el estado global del sistema para que el controlador web renderice la vista adecuada.

## Mecanismo usado para Knowledge

El componente *Knowledge* fue implementado como un Singleton en memoria respaldado por el archivo `application.properties`. Al iniciar, lee los umbrales `restricted.threshold=10` y `text.threshold=20`, manteniendo además el estado actual del modo y el contador de peticiones.

## Prueba de carga

* **Herramienta externa**: Se utilizó `curl` mediante un script de PowerShell.
* **Comando utilizado**:
```powershell
1..25 | ForEach-Object { curl.exe -s http://localhost:7000/content }

```


* **Evidencia**: Se adjuntan capturas de consola e interfaz gráfica que demuestran la transición entre los 0 y 25 requests, evidenciando el cambio de modo a los 10 y 20 requests.

```

**3. Diagrama de arquitectura **


```
