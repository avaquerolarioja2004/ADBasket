/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back;

import java.util.ArrayList;

/**
 *
 * @author mrpox
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<String> lista = Metodos.getJornadas();
        if (lista.size() < 1) {
            System.out.println("Vacio");
        } else {
            for (String jornada : Metodos.getJornadas()) {
                System.out.println(jornada);
            }

        }
    }
}
