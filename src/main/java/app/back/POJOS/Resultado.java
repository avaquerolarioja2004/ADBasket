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
@Table(name = "RESULTADO")
public class Resultado {

    @Id
    @Column(name = "idResultado")
    private int idResultado;

    @Column(name = "numjornada", nullable = false)
    private int numJornada;

    @ManyToOne
    @JoinColumn(name = "equipoLocal", referencedColumnName = "idequipo", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipoVisitante", referencedColumnName = "idequipo")
    private Equipo equipoVisitante;

    @Column(name = "puntosLocal")
    private int puntosLocal;

    @Column(name = "puntosVisitante")
    private int puntosVisitante;

    // Constructor, getters y setters

    // Constructor por defecto
    public Resultado() {
    }

    // Constructor con parámetros
    public Resultado(int numJornada, Equipo equipoLocal, Equipo equipoVisitante, int puntosLocal, int puntosVisitante) {
        this.numJornada = numJornada;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
    }

    // Getters y Setters

    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
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

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }
}

