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
