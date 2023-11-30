/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.repository;

import app.back.POJOS.Equipo;
import jakarta.persistence.*;

/**
 *
 * @author mrpox
 */
public class EquipoRepository {

    public static boolean guardarEquipo(EntityManager eM, Equipo e) {
        try {
            eM.getTransaction().begin();
            eM.persist(e);
            eM.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            eM.getTransaction().rollback();
            return false;
        }
    }

}
