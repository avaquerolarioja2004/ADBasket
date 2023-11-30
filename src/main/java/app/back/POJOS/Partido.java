/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.POJOS;

import jakarta.persistence.*;

/**
 *
 * @author mrpox
 */

@Entity
@Table(name = "PARTIDO")
public class Partido {

    @Id
    @Column(name = "idPartido")
    private int idPartido;

    @Column(name = "numjornada", nullable = false)
    private int numJornada;

    @ManyToOne
    @JoinColumn(name = "equipoLocal", referencedColumnName = "idequipo", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipoVisitante", referencedColumnName = "idequipo")
    private Equipo equipoVisitante;

    // Constructor, getters y setters

    // Constructor por defecto
    public Partido() {
    }

    // Constructor con parámetros
    public Partido(int numJornada, Equipo equipoLocal, Equipo equipoVisitante) {
        this.numJornada = numJornada;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    // Getters y Setters

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
}

