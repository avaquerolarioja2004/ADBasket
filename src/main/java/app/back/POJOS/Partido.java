/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.POJOS;

import app.back.POJOS.Equipo;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PARTIDO")
@NamedQueries({
    @NamedQuery(name = "Partido.findAll", query = "SELECT p FROM Partido p"),
    @NamedQuery(name = "Partido.findById", query = "SELECT p FROM Partido p WHERE p.idPartido = :idPartido"),
    @NamedQuery(name = "Partido.findByNumjornada", query = "SELECT p FROM Partido p WHERE p.numjornada = :numjornada"),
    @NamedQuery(name = "Partido.findByEquipoLocal", query = "SELECT p FROM Partido p WHERE p.equipoLocal = :equipoLocal"),
    @NamedQuery(name = "Partido.findByEquipoVisitante", query = "SELECT p FROM Partido p WHERE p.equipoVisitante = :equipoVisitante")
})
public class Partido implements Serializable {

    @Id
    @Column(name = "idPartido")
    private Integer idPartido;

    @Column(name = "numjornada", nullable = false)
    private Integer numjornada;

    @ManyToOne
    @JoinColumn(name = "equipoLocal", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipoVisitante")
    private Equipo equipoVisitante;

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Integer getNumjornada() {
        return numjornada;
    }

    public void setNumjornada(Integer numjornada) {
        this.numjornada = numjornada;
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

    public String getNombreEquipoLocal() {
        return equipoLocal.getNombre();
    }

    public String getNombreEquipoVisitante() {
        return equipoVisitante.getNombre();
    
    }
    
}
