/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.POJOS;

import jakarta.persistence.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mrpox
 */
@Entity
@Table(name = "JORNADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jornada.findAll", query = "SELECT j FROM Jornada j"),
    @NamedQuery(name = "Jornada.findByNumjornada", query = "SELECT j FROM Jornada j WHERE j.numjornada = :numjornada"),
    @NamedQuery(name = "Jornada.findByFecha", query = "SELECT j FROM Jornada j WHERE j.fecha = :fecha")})
public class Jornada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "numjornada")
    private Integer numjornada;
    @Column(name = "fecha")
    private String fecha;

    public Jornada() {
    }

    public Jornada(Integer numjornada) {
        this.numjornada = numjornada;
    }

    public Integer getNumjornada() {
        return numjornada;
    }

    public void setNumjornada(Integer numjornada) {
        this.numjornada = numjornada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numjornada != null ? numjornada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jornada)) {
            return false;
        }
        Jornada other = (Jornada) object;
        if ((this.numjornada == null && other.numjornada != null) || (this.numjornada != null && !this.numjornada.equals(other.numjornada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.back.POJOS.Jornada[ numjornada=" + numjornada + " ]";
    }
    
}
