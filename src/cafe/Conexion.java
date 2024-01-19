package login;

import cafe.Dashboard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{

    private static Conexion instancia;
    private Connection connection;

    public Conexion() {
        conectar();
    }

    public static Conexion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    private void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/java2023/Cafeteria/database/royalcafe.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Conexión a la base de datos establecida.");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Desconexión de la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al desconectar la base de datos: " + e.getMessage());
        }
    }
}
