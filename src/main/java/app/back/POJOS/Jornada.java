/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.POJOS;

import jakarta.persistence.*;
import java.sql.Date;

/**
 *
 * @author mrpox
 */
@Entity
@Table(name = "JORNADA")
public class Jornada {

    @Id
    @Column(name = "numjornada")
    private int numJornada;

    @Column(name = "fecha")
    private Date fecha;

    // Constructor, getters y setters

    // Constructor por defecto
    public Jornada() {
    }

    // Constructor con parámetros
    public Jornada(int numJornada, Date fecha) {
        this.numJornada = numJornada;
        this.fecha = fecha;
    }

    // Getters y Setters

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
