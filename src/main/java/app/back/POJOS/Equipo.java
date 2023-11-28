/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.POJOS;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

/**
 *
 * @author mrpox
 */


@Entity
@Table(name = "EQUIPO")
@Check(constraints = "jugadosCasa = ganadosCasa + perdidosCasa and jugadosFuera = ganadosFuera + perdidosFuera")
public class Equipo {

    @Id
    @Column(name = "idequipo")
    private int idEquipo;

    @Column(name = "nombre", length = 25)
    private String nombre;

    @Column(name = "ciudad", length = 25)
    private String ciudad;

    @Column(name = "jugadosCasa")
    private int jugadosCasa;

    @Column(name = "ganadosCasa")
    private int ganadosCasa;

    @Column(name = "perdidosCasa")
    private int perdidosCasa;

    @Column(name = "puntosFavorCasa")
    private int puntosFavorCasa;

    @Column(name = "puntosContraCasa")
    private int puntosContraCasa;

    @Column(name = "jugadosFuera")
    private int jugadosFuera;

    @Column(name = "ganadosFuera")
    private int ganadosFuera;

    @Column(name = "perdidosFuera")
    private int perdidosFuera;

    @Column(name = "puntosFavorFuera")
    private int puntosFavorFuera;

    @Column(name = "puntosContraFuera")
    private int puntosContraFuera;

    // Constructor, getters y setters

    // Constructor por defecto
    public Equipo() {
    }

    // Constructor con parámetros
    public Equipo(int idEquipo, String nombre, String ciudad, int jugadosCasa, int ganadosCasa, int perdidosCasa,
                  int puntosFavorCasa, int puntosContraCasa, int jugadosFuera, int ganadosFuera, int perdidosFuera,
                  int puntosFavorFuera, int puntosContraFuera) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.jugadosCasa = jugadosCasa;
        this.ganadosCasa = ganadosCasa;
        this.perdidosCasa = perdidosCasa;
        this.puntosFavorCasa = puntosFavorCasa;
        this.puntosContraCasa = puntosContraCasa;
        this.jugadosFuera = jugadosFuera;
        this.ganadosFuera = ganadosFuera;
        this.perdidosFuera = perdidosFuera;
        this.puntosFavorFuera = puntosFavorFuera;
        this.puntosContraFuera = puntosContraFuera;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getJugadosCasa() {
        return jugadosCasa;
    }

    public int getGanadosCasa() {
        return ganadosCasa;
    }

    public int getPerdidosCasa() {
        return perdidosCasa;
    }

    public int getPuntosFavorCasa() {
        return puntosFavorCasa;
    }

    public int getPuntosContraCasa() {
        return puntosContraCasa;
    }

    public int getJugadosFuera() {
        return jugadosFuera;
    }

    public int getGanadosFuera() {
        return ganadosFuera;
    }

    public int getPerdidosFuera() {
        return perdidosFuera;
    }

    public int getPuntosFavorFuera() {
        return puntosFavorFuera;
    }

    public int getPuntosContraFuera() {
        return puntosContraFuera;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setJugadosCasa(int jugadosCasa) {
        this.jugadosCasa = jugadosCasa;
    }

    public void setGanadosCasa(int ganadosCasa) {
        this.ganadosCasa = ganadosCasa;
    }

    public void setPerdidosCasa(int perdidosCasa) {
        this.perdidosCasa = perdidosCasa;
    }

    public void setPuntosFavorCasa(int puntosFavorCasa) {
        this.puntosFavorCasa = puntosFavorCasa;
    }

    public void setPuntosContraCasa(int puntosContraCasa) {
        this.puntosContraCasa = puntosContraCasa;
    }

    public void setJugadosFuera(int jugadosFuera) {
        this.jugadosFuera = jugadosFuera;
    }

    public void setGanadosFuera(int ganadosFuera) {
        this.ganadosFuera = ganadosFuera;
    }

    public void setPerdidosFuera(int perdidosFuera) {
        this.perdidosFuera = perdidosFuera;
    }

    public void setPuntosFavorFuera(int puntosFavorFuera) {
        this.puntosFavorFuera = puntosFavorFuera;
    }

    public void setPuntosContraFuera(int puntosContraFuera) {
        this.puntosContraFuera = puntosContraFuera;
    }
}

