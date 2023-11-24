package app.back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Sergio Morillas Carmona
 */
public class Libreria {

    /**
     * Metodo que devuelve un objeto de tipo conexion y recibe dos parametros,
     * la base de datos que utiliza y una String con los valores de la conexion
     * que necesitan las bases de datos a utilizar.
     *
     * @param tipo
     * <ul>
     * <li>Para conectar a SQLite debes escribir <b>sqlite</b></li>
     * <li>Para conectar a MySQL debes escribir <b>mysql</b></li>
     * <li>Para conectar a Oracle debes escribir <b>oracle</b></li>
     * </ul>
     * @param valores
     * <ul>
     * <li>
     * En caso de querer conectarte a <b>SQLite</b> tendras que añadir una unica
     * String con la ruta hasta el fichero de la base de datos.<br>E.G. ->
     * "sqlite", "D:\\sqlite\\aerolinea.db"
     * </li>
     * <li>
     * En caso de querer conectarte a <b>MySQL</b> tendras que añadir tres
     * Strings, el primero con la ruta hasta el fichero de la base de datos, el
     * segundo con el usuario que utilizaras para conectarte y el ultimo con la
     * contraseña.<br>E.G. -> "mysql", "aerolineas", "root", "docker"
     * </li>
     * <li>
     * En caso de querer conectarte a <b>Oracle</b> tendras que añadir la ip del
     * servidor, el usuario y la contraseña, en caso de no poner ip se utilizará
     * localhost<br>E.G. -> "aerolineas", "192.168.0.1", "AEROLINEA", "docker"
     * </li>
     * </ul>
     * @return Devuelve el objeto conexion correspondiente al SGBD al que te
     * hayas conectado
     */
    public static Connection creaConexion(String tipo, String... valores) {
        Connection conexion = null;
        try {
            switch (tipo) {

                case "sqlite" -> {
                    conexion = DriverManager.getConnection("jdbc:sqlite:" + valores[0]);
                }
                case "mysql" -> {
                    conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + valores[0] + "?zeroDateTimeBehavior=CONVERT_TO_NULL", valores[1], valores[2]);
                }
                case "oracle" -> {
                    conexion = DriverManager.getConnection("jdbc:oracle:thin:@" + valores[0] + ":1521:XE", valores[1], valores[2]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }
}
