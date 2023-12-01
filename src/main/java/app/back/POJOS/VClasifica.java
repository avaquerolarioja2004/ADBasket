/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.back.POJOS;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author mrpox
 */
@Entity
@Table(name = "v_clasifica")
@NamedQueries({
    @NamedQuery(name = "VClasifica.findAll", query = "SELECT v FROM VClasifica v"),
    @NamedQuery(name = "VClasifica.findByNombre", query = "SELECT v FROM VClasifica v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "VClasifica.findByPj1", query = "SELECT v FROM VClasifica v WHERE v.pj1 = :pj1"),
    @NamedQuery(name = "VClasifica.findByPg1", query = "SELECT v FROM VClasifica v WHERE v.pg1 = :pg1"),
    @NamedQuery(name = "VClasifica.findByPp1", query = "SELECT v FROM VClasifica v WHERE v.pp1 = :pp1"),
    @NamedQuery(name = "VClasifica.findByPf1", query = "SELECT v FROM VClasifica v WHERE v.pf1 = :pf1"),
    @NamedQuery(name = "VClasifica.findByPc1", query = "SELECT v FROM VClasifica v WHERE v.pc1 = :pc1"),
    @NamedQuery(name = "VClasifica.findByPtos1", query = "SELECT v FROM VClasifica v WHERE v.ptos1 = :ptos1"),
    @NamedQuery(name = "VClasifica.findByPj2", query = "SELECT v FROM VClasifica v WHERE v.pj2 = :pj2"),
    @NamedQuery(name = "VClasifica.findByPg2", query = "SELECT v FROM VClasifica v WHERE v.pg2 = :pg2"),
    @NamedQuery(name = "VClasifica.findByPp2", query = "SELECT v FROM VClasifica v WHERE v.pp2 = :pp2"),
    @NamedQuery(name = "VClasifica.findByPf2", query = "SELECT v FROM VClasifica v WHERE v.pf2 = :pf2"),
    @NamedQuery(name = "VClasifica.findByPc2", query = "SELECT v FROM VClasifica v WHERE v.pc2 = :pc2"),
    @NamedQuery(name = "VClasifica.findByPtos2", query = "SELECT v FROM VClasifica v WHERE v.ptos2 = :ptos2"),
    @NamedQuery(name = "VClasifica.findByPj", query = "SELECT v FROM VClasifica v WHERE v.pj = :pj"),
    @NamedQuery(name = "VClasifica.findByPg", query = "SELECT v FROM VClasifica v WHERE v.pg = :pg"),
    @NamedQuery(name = "VClasifica.findByPp", query = "SELECT v FROM VClasifica v WHERE v.pp = :pp"),
    @NamedQuery(name = "VClasifica.findByPf", query = "SELECT v FROM VClasifica v WHERE v.pf = :pf"),
    @NamedQuery(name = "VClasifica.findByPc", query = "SELECT v FROM VClasifica v WHERE v.pc = :pc"),
    @NamedQuery(name = "VClasifica.findByPtos", query = "SELECT v FROM VClasifica v WHERE v.ptos = :ptos")})
public class VClasifica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "PJ1")
    private Integer pj1;
    @Column(name = "PG1")
    private Integer pg1;
    @Column(name = "PP1")
    private Integer pp1;
    @Column(name = "PF1")
    private Integer pf1;
    @Column(name = "PC1")
    private Integer pc1;
    @Column(name = "PTOS1")
    private Integer ptos1;
    @Column(name = "PJ2")
    private Integer pj2;
    @Column(name = "PG2")
    private Integer pg2;
    @Column(name = "PP2")
    private Integer pp2;
    @Column(name = "PF2")
    private Integer pf2;
    @Column(name = "PC2")
    private Integer pc2;
    @Column(name = "PTOS2")
    private Integer ptos2;
    @Column(name = "PJ")
    private String pj;
    @Column(name = "PG")
    private String pg;
    @Column(name = "PP")
    private String pp;
    @Column(name = "PF")
    private String pf;
    @Column(name = "PC")
    private String pc;
    @Column(name = "PTOS")
    private String ptos;

    public VClasifica() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPj1() {
        return pj1;
    }

    public void setPj1(Integer pj1) {
        this.pj1 = pj1;
    }

    public Integer getPg1() {
        return pg1;
    }

    public void setPg1(Integer pg1) {
        this.pg1 = pg1;
    }

    public Integer getPp1() {
        return pp1;
    }

    public void setPp1(Integer pp1) {
        this.pp1 = pp1;
    }

    public Integer getPf1() {
        return pf1;
    }

    public void setPf1(Integer pf1) {
        this.pf1 = pf1;
    }

    public Integer getPc1() {
        return pc1;
    }

    public void setPc1(Integer pc1) {
        this.pc1 = pc1;
    }

    public Integer getPtos1() {
        return ptos1;
    }

    public void setPtos1(Integer ptos1) {
        this.ptos1 = ptos1;
    }

    public Integer getPj2() {
        return pj2;
    }

    public void setPj2(Integer pj2) {
        this.pj2 = pj2;
    }

    public Integer getPg2() {
        return pg2;
    }

    public void setPg2(Integer pg2) {
        this.pg2 = pg2;
    }

    public Integer getPp2() {
        return pp2;
    }

    public void setPp2(Integer pp2) {
        this.pp2 = pp2;
    }

    public Integer getPf2() {
        return pf2;
    }

    public void setPf2(Integer pf2) {
        this.pf2 = pf2;
    }

    public Integer getPc2() {
        return pc2;
    }

    public void setPc2(Integer pc2) {
        this.pc2 = pc2;
    }

    public Integer getPtos2() {
        return ptos2;
    }

    public void setPtos2(Integer ptos2) {
        this.ptos2 = ptos2;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPtos() {
        return ptos;
    }

    public void setPtos(String ptos) {
        this.ptos = ptos;
    }
    
}
