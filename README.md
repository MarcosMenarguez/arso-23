## Arquitectura del Software - Curso 2022-23

En este repositorio se alojan proyectos que se presentan como referencia durante el desarrollo de la asignatura.

- `ejemplos`: proyecto con ejemplos que complementan las presentaciones de teoría.
- `servicio-web-soap`: proyecto Eclipse/Maven que publica un servicio web SOAP de un saludo. El ejemplo se desarrolla en las diapositivas del tema.
- `cliente-servicio-web-soap`: proyecto Eclipse/Maven que consume el servicio web del saludo y un servicio externo de geolocalización de direcciones IP. Destaca la configuración del fichero `pom.xml` que incluye un *plugin* para generar el código *stub* de acceso a los servicios. El plugin se ejecuta con el target `jaxws:wsimport`. Posteriormente, se ha incluido la carpeta `target/generated-sources` como carpeta de código fuente en el proyecto Eclipse.
