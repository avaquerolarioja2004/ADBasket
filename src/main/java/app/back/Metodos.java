/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back;

import app.back.POJOS.Equipo;
import app.back.POJOS.Jornada;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrpox
 */
public class Metodos {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLITEPersistence");
    private static EntityManager em = emf.createEntityManager();

    /*
        Ejemplo de como crear la conexión:
        private static Connection c = Libreria.creaConexion("sqlite", "E:\\AD_ServersYConectores\\SGBD\\sqlite\\BALONCESTO.db");
    */

    public static ArrayList<String> getJornadas() {
        //NamedQuery
        String result = "";
        Query query = em.createNamedQuery("Jornada.findAll");
        ArrayList<Jornada> lista = (ArrayList<Jornada>) query.getResultList();
        ArrayList<String> resultadoJornadas = new ArrayList<>();

        for (Jornada jornada : lista) {
            result = jornada.getNumjornada() + ";" + jornada.getFecha();
            resultadoJornadas.add(result);
        }
        return resultadoJornadas;
    }

    public static ArrayList<String> getPartidosJornada(int idJornada, Connection c) {
        ArrayList<String> lista = new ArrayList<>();
        //SQL
        String consulta = "SELECT EL.nombre AS EquipoLocal, EV.nombre AS EquipoVisitante FROM PARTIDO P "
                + "JOIN JORNADA J ON P.numjornada = J.numjornada "
                + "JOIN EQUIPO EL ON P.equipoLocal = EL.idequipo "
                + "JOIN EQUIPO EV ON P.equipoVisitante = EV.idequipo "
                + "WHERE J.numjornada = " + idJornada + ";";

        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(consulta);
            while (rs.next()) {
                String equipoLocal = rs.getString("EquipoLocal");
                String equipoVisitante = rs.getString("EquipoVisitante");
                lista.add(equipoLocal + ";" + equipoVisitante);
            }
        } catch (SQLException ex) {
            System.err.println("Error en la consulta");
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static int getIdEquipoByName(String nombreEquipo) {
        //JPQL
        int id = 0;
        Query query = em.createQuery("SELECT e FROM Equipo e WHERE e.nombre = :nombre");
        query.setParameter("nombre", nombreEquipo);
        List<Equipo> resultados = query.getResultList();
        for (Equipo equipo : resultados) {
            id = equipo.getIdequipo();
        }
        return id;
    }
}
