/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.POJOS;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrpox
 */
public class test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQLITEPersistence");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Jornada.findAll");
        List<Jornada> jornadas0 = query.getResultList();

        for (Jornada jornada : jornadas0) {
            String opcion = jornada.getNumjornada() + " " + jornada.getFecha();
            System.out.println(jornada);
        }

    }

}
