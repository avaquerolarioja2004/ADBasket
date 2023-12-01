/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back;

import app.back.POJOS.Equipo;
import app.back.POJOS.Jornada;
import app.back.POJOS.Partido;
import app.back.POJOS.Resultado;
import app.back.POJOS.VClasifica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
            ex.printStackTrace();
        }
        return lista;
    }

    public static int getIdEquipoByName(String nombreEquipo) {
        //JPQL
        int id = 0;
        try {
            Query query = em.createQuery("SELECT e FROM Equipo e WHERE e.nombre = :nombre");
            query.setParameter("nombre", nombreEquipo);
            List<Equipo> resultados = query.getResultList();
            for (Equipo equipo : resultados) {
                id = equipo.getIdequipo();
            }
        } catch (Exception e) {
            System.err.println("Error en la consulta");
            e.printStackTrace();
            id = -1;
        }
        return id;
    }

    public static boolean grabar(int jornada, int idEL, int pEL, int idEV, int pEV) {
        try {
            Query qP = em.createQuery("SELECT p FROM Partido p "
                    + "WHERE p.numjornada = :numJornada "
                    + "AND p.equipoLocal.idequipo = :idEquipoLocal "
                    + "AND p.equipoVisitante.idequipo = :idEquipoVisitante").setParameter("numJornada", jornada)
                    .setParameter("idEquipoLocal", idEL)
                    .setParameter("idEquipoVisitante", idEV);
            Query qL = em.createNamedQuery("Equipo.findByIdequipo").setParameter("idequipo", idEL);
            Query qV = em.createNamedQuery("Equipo.findByIdequipo").setParameter("idequipo", idEV);
            Equipo eL = (Equipo) qL.getSingleResult();
            Equipo eV = (Equipo) qV.getSingleResult();
            Partido partido = (Partido) qP.getSingleResult();
            em.getTransaction().begin();
            Resultado resultado = new Resultado(getFinalId() + 1, jornada, eL, eV, pEL, pEV);
            em.persist(resultado);
            em.remove(partido);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("Error en la petición");
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }

    public static String getInfoEquipos(int idEquipo) {
        // No funciona
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VClasifica> cq = cb.createQuery(VClasifica.class);
        Root<VClasifica> root = cq.from(VClasifica.class);
        Predicate predicate = cb.equal(root.get("idEquipo"), idEquipo);
        cq.where(predicate);
        TypedQuery<VClasifica> query = em.createQuery(cq);
        VClasifica vs=query.getSingleResult();
        String resultado=vs.getNombre()+";"+vs.getPj1()+";"+vs.getPg1()+";"
                +vs.getPp1()+";"+vs.getPf1()+";"+vs.getPc1()+";"+vs.getPtos1()+";"+vs.getPj2()+";"+vs.getPg2()+";"
                +vs.getPp2()+";"+vs.getPf2()+";"+vs.getPc2()+";"+vs.getPtos2()+vs.getPj()+";"+vs.getPg()+";"
                +vs.getPp()+";"+vs.getPf()+";"+vs.getPc()+";"+vs.getPtos();
        return resultado;
    }

    private static int getFinalId() {
        int result = 0;
        try {
            Query query = em.createNamedQuery("Resultado.findLatestResult").setMaxResults(1);
            Resultado resultado = (Resultado) query.getSingleResult();
            result = resultado.getIdResultado();
        } catch (Exception e) {
            System.err.println("Error en la consulta");
            e.printStackTrace();
            result = -1;
        }
        return result;
    }
}
