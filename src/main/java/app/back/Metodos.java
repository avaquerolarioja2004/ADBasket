/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back;

import app.back.POJOS.Jornada;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.ArrayList;

/**
 *
 * @author mrpox
 */
public class Metodos {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceSQLITE");
    private static EntityManager eM = emf.createEntityManager();

    public static void grabar(int idJornada, int idEquipoLocal, int puntosEquipoLocal, int idEquipoVisitante, int puntosEquipoVisitante) {

    }

    public static ArrayList<String> getJornadas() {
        ArrayList<String> resultados = new ArrayList<>();
        String resul = "";
        ArrayList<Jornada> lista;
        try {
            eM.getTransaction().begin();
            Query query = eM.createNamedQuery("Jornada.findAll");
            lista = (ArrayList<Jornada>) query.getResultList();

            for (Jornada jornada : lista) {
                resul = jornada.getNumjornada() + "-" + jornada.getFecha();
                resultados.add(resul);
            }
            eM.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            eM.getTransaction().rollback();
            resultados.clear();
        }

        return resultados;
    }

}
