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
