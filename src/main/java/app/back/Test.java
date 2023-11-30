/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back;

import app.back.POJOS.Equipo;
import app.back.repository.EquipoRepository;
import jakarta.persistence.*;

/**
 *
 * @author mrpox
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("persistenciaSqlite");
        EntityManager eM = emf.createEntityManager();
        Equipo e=new Equipo(1);
        System.out.println(EquipoRepository.guardarEquipo(eM, e));
    
    }
}
