# ConexionDB
## ¿Qué es JDBC?

JDBC (Java Database Connectivity) es como un "traductor" que permite a tus programas Java (y por ende, Scala) hablar con bases de datos como MySQL, PostgreSQL, etc. Es una API estándar que proporciona las herramientas para:

*   **Conectar:** Establecer una comunicación con la base de datos.
*   **Consultar:** Enviar preguntas (consultas SQL) a la base de datos.
*   **Procesar resultados:** Recibir y entender las respuestas de la base de datos.
*   **Gestionar transacciones:** Asegurar que las operaciones en la base de datos se realicen de forma segura y consistente.

## Componentes Clave de JDBC

1.  **Driver Manager:** El "jefe" que gestiona las conexiones y los drivers.
2.  **Driver:** El "traductor" específico para cada base de datos (ej., un driver para MySQL, otro para PostgreSQL).
3.  **Connection:** La "línea directa" entre tu programa y la base de datos.
4.  **Statement:** El "mensajero" que envía consultas SQL sencillas.
5.  **PreparedStatement:** Un "mensajero" más eficiente para consultas repetidas o con parámetros, que además previene ataques de inyección SQL.
6.  **ResultSet:** El "paquete" con los resultados de una consulta.
## Librerías de Scala para Bases de Datos

Si bien Scala puede usar JDBC directamente, existen librerías que hacen el trabajo más sencillo y "escalesco":

1.  **Anorm:** Simple y directa. Te permite escribir SQL "crudo" y mapearlo a objetos Scala. Ideal para proyectos pequeños o cuando necesitas control total del SQL.
2.  **Slick:** Más potente y con un enfoque de Mapeo Objeto-Relacional (ORM). Ofrece un lenguaje de consulta (DSL) propio y facilita el mantenimiento de aplicaciones complejas.

### Comparativa Anorm vs. Slick

| Característica        | Anorm                               | Slick                                    |
| --------------------- | ----------------------------------- | ---------------------------------------- |
| Enfoque              | SQL "crudo" con mapeo a objetos       | DSL propio y ORM                         |
| Complejidad           | Simple y ligero                     | Más complejo, pero más potente           |
| Curva de aprendizaje | Baja                                 | Media                                     |
| Tipado               | Menos tipado (depende del mapeo)      | Fuertemente tipado                      |
