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
## 3. Conexión con MySQL
### 1) Creación de base de datos
![image](https://github.com/user-attachments/assets/187f899d-e40d-445b-9932-edb850e6cc83)
### 2) Genere una tabla con datos de prueba
![image](https://github.com/user-attachments/assets/c953f9e0-2f25-4720-b177-92cd845755d5)
### 3) Código en Scala...
* Sbt
```scala
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "conexionDB",
    libraryDependencies ++= Seq(
      "mysql" % "mysql-connector-java" % "8.0.33", // Driver MySQL (reemplaza con la versión más reciente si es necesario)
      "org.slf4j" % "slf4j-simple" % "2.0.9" // Dependencia para el logging (opcional, pero recomendado)
    )
  )
```
* Codigo
```scala
import java.sql.{Connection, DriverManager, ResultSet}

object ConexionMySQL {

  val url = "jdbc:mysql://localhost:3306/prueba"
  val username = "Andy"
  val password = "andyjunior"

  def main(args: Array[String]): Unit = {
    var connection: Connection = null

    try {

      connection = DriverManager.getConnection(url, username, password)
      println("Conexión exitosa a la base de datos.")


      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM usuarios")


      while (resultSet.next()) {
        val id = resultSet.getInt("id")
        val nombre = resultSet.getString("nombre")
        val correo = resultSet.getString("correo")
        println(s"ID: $id, Nombre: $nombre, Correo: $correo")
      }

    } catch {
      case e: Exception =>
        e.printStackTrace()
    } finally {
      if (connection != null) {
        connection.close()
        println("Conexión cerrada.")
      }
    }
  }
}
```
### 4) Resultados
![image](https://github.com/user-attachments/assets/67a0c26e-3c7c-4074-bef4-2a55673fc7c7)

### Referencias

*   **JDBC API Tutorial (Oracle):** Tutorial oficial de Oracle sobre JDBC, que cubre los conceptos fundamentales y proporciona ejemplos prácticos.

    [https://docs.oracle.com/javase/tutorial/jdbc/](https://docs.oracle.com/javase/tutorial/jdbc/)

*   **MySQL Connector/J 8.0 (MySQL):** Documentación oficial del driver JDBC para MySQL, que incluye información sobre la instalación, configuración, compatibilidad y el uso de diferentes características.

    [https://dev.mysql.com/doc/connector-j/en/](https://dev.mysql.com/doc/connector-j/en/)

*   **Slick (Scala Slick):** Documentación oficial de Slick, una popular librería de Scala para acceso a bases de datos relacionales, que ofrece un DSL y capacidades de ORM.

    [https://scala-slick.org/](https://scala-slick.org/)

*   **SLF4j (Simple Logging Facade for Java):** Sitio web oficial de SLF4j, que explica su propósito como una fachada de logging y proporciona información sobre sus diferentes implementaciones (como slf4j-simple, logback, log4j).

    [https://www.slf4j.org/](https://www.slf4j.org/)
