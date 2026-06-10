# Sistema Web Autoadaptativo (Arquitectura MAPE-K)

## Descripción general
Plataforma web educativa desarrollada en Java con Javalin y Maven, diseñada para autoadaptarse según el nivel de tráfico. El sistema reduce el consumo de recursos cambiando entre tres modos de presentación (Multimedia, Restringido y Texto) al detectar alta demanda.

## Instrucciones de instalación y ejecución
1. Clonar el repositorio.
2. Abrir una terminal en la raíz del proyecto.
3. Compilar y ejecutar el proyecto utilizando :
   Maven.1..25 | ForEach-Object { curl.exe -s http://localhost:7000/content }
5. Acceder en el navegador a http://localhost:7000/content.


Componentes MAPE-K implementados
Monitor: Intercepta cada solicitud al endpoint /content, registra el tráfico incrementando un contador y notifica al Analyzer.

Analyze: Evalúa la cantidad de solicitudes actuales comparándolas contra los umbrales configurados en el Knowledge para determinar el nivel de demanda (Baja, Media, Alta).

Plan: Recibe el nivel de demanda y decide qué acción tomar: mantener el modo MULTIMEDIA, o cambiar a RESTRICTED o TEXT.

Execute: Aplica la decisión del Planner, modificando el estado global del sistema para que el controlador web renderice la vista adecuada.


El componente Knowledge fue implementado como un Singleton en memoria respaldado por el archivo application.properties. Al iniciar, lee los umbrales restricted.threshold=10 y text.threshold=20, manteniendo además el estado actual del modo y el contador de peticione para cargar 1..25 | ForEach-Object { curl.exe -s http://localhost:7000/content }









