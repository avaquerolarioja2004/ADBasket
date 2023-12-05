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
        // JPQL
        try {
            int idResultado = getFinalId();
            if (idResultado == -1) {
                System.err.println("Error en el id del resultado");
                return false;
            }
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
            Resultado resultado = new Resultado(idResultado + 1, jornada, eL, eV, pEL, pEV);
            em.persist(resultado);
            em.remove(partido);
            em.getTransaction().commit();
            updateEquipo(idEL, true, pEL, pEV);
            updateEquipo(idEV, false, pEL, pEV);
            return true;
        } catch (Exception e) {
            System.err.println("Error en la petición");
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }

    public static String getInfoEquipo(int idEquipo) {
        //Criteria
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<VClasifica> criteriaQuery = criteriaBuilder.createQuery(VClasifica.class);
        Root<VClasifica> root = criteriaQuery.from(VClasifica.class);
        Predicate predicate = criteriaBuilder.equal(root.get("nombre"), getNombreById(idEquipo));
        criteriaQuery.where(predicate);
        List<VClasifica> resultados = em.createQuery(criteriaQuery).getResultList();
        VClasifica vs = resultados.get(0);
        if (vs != null) {
            String resultado = vs.getNombre() + ";" + vs.getPj1() + ";" + vs.getPg1() + ";"
                    + vs.getPp1() + ";" + vs.getPf1() + ";" + vs.getPc1() + ";" + vs.getPtos1() + ";" + vs.getPj2() + ";" + vs.getPg2() + ";"
                    + vs.getPp2() + ";" + vs.getPf2() + ";" + vs.getPc2() + ";" + vs.getPtos2() + ";" + vs.getPj() + ";" + vs.getPg() + ";"
                    + vs.getPp() + ";" + vs.getPf() + ";" + vs.getPc() + ";" + vs.getPtos();
            return resultado;
        } else {
            return "";
        }
    }

    public static String getInfoEquipo(String nombreEquipo) {
        //Criteria
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<VClasifica> criteriaQuery = criteriaBuilder.createQuery(VClasifica.class);
        Root<VClasifica> root = criteriaQuery.from(VClasifica.class);
        Predicate predicate = criteriaBuilder.equal(root.get("nombre"), nombreEquipo);
        criteriaQuery.where(predicate);
        List<VClasifica> resultados = em.createQuery(criteriaQuery).getResultList();
        VClasifica vs = resultados.get(0);
        if (vs != null) {
            String resultado = vs.getNombre() + ";" + vs.getPj1() + ";" + vs.getPg1() + ";"
                    + vs.getPp1() + ";" + vs.getPf1() + ";" + vs.getPc1() + ";" + vs.getPtos1() + ";" + vs.getPj2() + ";" + vs.getPg2() + ";"
                    + vs.getPp2() + ";" + vs.getPf2() + ";" + vs.getPc2() + ";" + vs.getPtos2() + ";" + vs.getPj() + ";" + vs.getPg() + ";"
                    + vs.getPp() + ";" + vs.getPf() + ";" + vs.getPc() + ";" + vs.getPtos();
            return resultado;
        } else {
            return "";
        }
    }

    public static ArrayList<String> getResultadosEquipo(int idEquipo) {
        ArrayList<Resultado> resultados = new ArrayList<>();
        Query q;
        Jornada j;
        ArrayList<String> out = new ArrayList<>();
        String JPQL = "SELECT r FROM Resultado r WHERE r.equipoLocal =: idequipo OR r.equipoVisitante =: idequipo";
        String fechaJornada = "SELECT j FROM Jornada j WHERE j.numjornada =: idJornada";
        Query query = em.createQuery(JPQL).setParameter("idequipo", getEquipo(idEquipo));
        resultados = (ArrayList<Resultado>) query.getResultList();
        for (Resultado resultado : resultados) {
            q = em.createQuery(fechaJornada).setParameter("idJornada", resultado.getNumJornada());
            j = (Jornada) q.getSingleResult();
            out.add(resultado.getNumJornada() + ";" + j.getFecha() + ";" + resultado.getEquipoLocal().getNombre() + ";" + resultado.getEquipoVisitante().getNombre()
                    + ";" + resultado.getPuntosLocal() + ";" + resultado.getPuntosVisitante());
        }
        return out;
    }

    public static ArrayList<String> getClasificaciones() {
        //Falta que lo ordene por puntos
        ArrayList<String> out = new ArrayList<>();
        Query q = em.createQuery("SELECT v FROM VClasifica v ORDER BY v.ptos DESC");
        ArrayList<VClasifica> l = (ArrayList<VClasifica>) q.getResultList();
        for (VClasifica o : l) {
            out.add(o.getNombre() + ";" + o.getPj() + ";" + o.getPg() + ";" + o.getPp() + ";" + o.getPf() + ";" + o.getPc() + ";" + o.getPtos());
        }
        return out;
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

    public static ArrayList<String> getNombresEquipos() {
        Query q = em.createNamedQuery("Equipo.findAll");
        ArrayList<String> out = new ArrayList<>();
        ArrayList<Equipo> resultados = (ArrayList<Equipo>) q.getResultList();
        for (Equipo resultado : resultados) {
            out.add(resultado.getNombre());
        }
        return out;
    }

    public static String getNombreById(int id) {
        Query query = em.createNamedQuery("Equipo.findByIdequipo").setParameter("idequipo", id);
        Equipo e = (Equipo) query.getSingleResult();
        return e.getNombre();
    }

    private static Equipo getEquipo(int idEquipo) {
        Query q = em.createNamedQuery("Equipo.findByIdequipo").setParameter("idequipo", idEquipo);
        return (Equipo) q.getSingleResult();
    }

    public static void updateEquipo(int equipoId, boolean local, int pEL, int pEV) {
        em.getTransaction().begin();
        String[] infoEquipo = Metodos.getInfoEquipo(equipoId).split(";");
        int pGanados = 0;
        int pPerdidos = 0;

        if (local) {
            if (pEL > pEV) {
                pGanados = 1;
            } else {
                pPerdidos = 1;
            }

            em.createQuery("UPDATE Equipo e SET e.jugadosCasa = :jugadosCasa, e.ganadosCasa = :ganadosCasa, "
                    + "e.perdidosCasa = :perdidosCasa, e.puntosFavorCasa = :puntosFavorCasa, e.puntosContraCasa = :puntosContraCasa "
                    + "WHERE e.idequipo = :equipoId")
                    .setParameter("jugadosCasa", Integer.parseInt(infoEquipo[1]) + 1)
                    .setParameter("ganadosCasa", Integer.parseInt(infoEquipo[2]) + pGanados)
                    .setParameter("perdidosCasa", Integer.parseInt(infoEquipo[3]) + pPerdidos)
                    .setParameter("puntosFavorCasa", Integer.parseInt(infoEquipo[4]) + pEL)
                    .setParameter("puntosContraCasa", Integer.parseInt(infoEquipo[5]) + pEV)
                    .setParameter("equipoId", equipoId)
                    .executeUpdate();
        } else {
            if (pEL < pEV) {
                pGanados = 1;
            } else {
                pPerdidos = 1;
            }

            em.createQuery("UPDATE Equipo e SET e.jugadosFuera = :jugadosFuera, e.ganadosFuera = :ganadosFuera, "
                    + "e.perdidosFuera = :perdidosFuera, e.puntosFavorFuera = :puntosFavorFuera, e.puntosContraFuera = :puntosContraFuera "
                    + "WHERE e.idequipo = :equipoId")
                    .setParameter("jugadosFuera", Integer.parseInt(infoEquipo[7]) + 1)
                    .setParameter("ganadosFuera", Integer.parseInt(infoEquipo[8]) + pGanados)
                    .setParameter("perdidosFuera", Integer.parseInt(infoEquipo[9]) + pPerdidos)
                    .setParameter("puntosFavorFuera", Integer.parseInt(infoEquipo[10]) + pEV)
                    .setParameter("puntosContraFuera", Integer.parseInt(infoEquipo[11]) + pEL)
                    .setParameter("equipoId", equipoId)
                    .executeUpdate();
        }
        em.getTransaction().commit();
    }
}
