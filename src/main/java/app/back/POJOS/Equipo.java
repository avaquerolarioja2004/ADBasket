/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.POJOS;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mrpox
 */
@Entity
@Table(name = "EQUIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdequipo", query = "SELECT e FROM Equipo e WHERE e.idequipo = :idequipo"),
    @NamedQuery(name = "Equipo.findByNombre", query = "SELECT e FROM Equipo e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Equipo.findByCiudad", query = "SELECT e FROM Equipo e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Equipo.findByJugadosCasa", query = "SELECT e FROM Equipo e WHERE e.jugadosCasa = :jugadosCasa"),
    @NamedQuery(name = "Equipo.findByGanadosCasa", query = "SELECT e FROM Equipo e WHERE e.ganadosCasa = :ganadosCasa"),
    @NamedQuery(name = "Equipo.findByPerdidosCasa", query = "SELECT e FROM Equipo e WHERE e.perdidosCasa = :perdidosCasa"),
    @NamedQuery(name = "Equipo.findByPuntosFavorCasa", query = "SELECT e FROM Equipo e WHERE e.puntosFavorCasa = :puntosFavorCasa"),
    @NamedQuery(name = "Equipo.findByPuntosContraCasa", query = "SELECT e FROM Equipo e WHERE e.puntosContraCasa = :puntosContraCasa"),
    @NamedQuery(name = "Equipo.findByJugadosFuera", query = "SELECT e FROM Equipo e WHERE e.jugadosFuera = :jugadosFuera"),
    @NamedQuery(name = "Equipo.findByGanadosFuera", query = "SELECT e FROM Equipo e WHERE e.ganadosFuera = :ganadosFuera"),
    @NamedQuery(name = "Equipo.findByPerdidosFuera", query = "SELECT e FROM Equipo e WHERE e.perdidosFuera = :perdidosFuera"),
    @NamedQuery(name = "Equipo.findByPuntosFavorFuera", query = "SELECT e FROM Equipo e WHERE e.puntosFavorFuera = :puntosFavorFuera"),
    @NamedQuery(name = "Equipo.findByPuntosContraFuera", query = "SELECT e FROM Equipo e WHERE e.puntosContraFuera = :puntosContraFuera")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idequipo")
    private Integer idequipo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "jugadosCasa")
    private Integer jugadosCasa;
    @Column(name = "ganadosCasa")
    private Integer ganadosCasa;
    @Column(name = "perdidosCasa")
    private Integer perdidosCasa;
    @Column(name = "puntosFavorCasa")
    private Integer puntosFavorCasa;
    @Column(name = "puntosContraCasa")
    private Integer puntosContraCasa;
    @Column(name = "jugadosFuera")
    private Integer jugadosFuera;
    @Column(name = "ganadosFuera")
    private Integer ganadosFuera;
    @Column(name = "perdidosFuera")
    private Integer perdidosFuera;
    @Column(name = "puntosFavorFuera")
    private Integer puntosFavorFuera;
    @Column(name = "puntosContraFuera")
    private Integer puntosContraFuera;

    public Equipo() {
    }

    public Equipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public Integer getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getJugadosCasa() {
        return jugadosCasa;
    }

    public void setJugadosCasa(Integer jugadosCasa) {
        this.jugadosCasa = jugadosCasa;
    }

    public Integer getGanadosCasa() {
        return ganadosCasa;
    }

    public void setGanadosCasa(Integer ganadosCasa) {
        this.ganadosCasa = ganadosCasa;
    }

    public Integer getPerdidosCasa() {
        return perdidosCasa;
    }

    public void setPerdidosCasa(Integer perdidosCasa) {
        this.perdidosCasa = perdidosCasa;
    }

    public Integer getPuntosFavorCasa() {
        return puntosFavorCasa;
    }

    public void setPuntosFavorCasa(Integer puntosFavorCasa) {
        this.puntosFavorCasa = puntosFavorCasa;
    }

    public Integer getPuntosContraCasa() {
        return puntosContraCasa;
    }

    public void setPuntosContraCasa(Integer puntosContraCasa) {
        this.puntosContraCasa = puntosContraCasa;
    }

    public Integer getJugadosFuera() {
        return jugadosFuera;
    }

    public void setJugadosFuera(Integer jugadosFuera) {
        this.jugadosFuera = jugadosFuera;
    }

    public Integer getGanadosFuera() {
        return ganadosFuera;
    }

    public void setGanadosFuera(Integer ganadosFuera) {
        this.ganadosFuera = ganadosFuera;
    }

    public Integer getPerdidosFuera() {
        return perdidosFuera;
    }

    public void setPerdidosFuera(Integer perdidosFuera) {
        this.perdidosFuera = perdidosFuera;
    }

    public Integer getPuntosFavorFuera() {
        return puntosFavorFuera;
    }

    public void setPuntosFavorFuera(Integer puntosFavorFuera) {
        this.puntosFavorFuera = puntosFavorFuera;
    }

    public Integer getPuntosContraFuera() {
        return puntosContraFuera;
    }

    public void setPuntosContraFuera(Integer puntosContraFuera) {
        this.puntosContraFuera = puntosContraFuera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipo != null ? idequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idequipo == null && other.idequipo != null) || (this.idequipo != null && !this.idequipo.equals(other.idequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.back.POJOS.Equipo[ idequipo=" + idequipo + " ]";
    }
    
}
