/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author claud
 */
@Entity
@Table(name = "cuadernillo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuadernillo.findAll", query = "SELECT c FROM Cuadernillo c")
    , @NamedQuery(name = "Cuadernillo.findByCodCuadernillo", query = "SELECT c FROM Cuadernillo c WHERE c.codCuadernillo = :codCuadernillo")
    , @NamedQuery(name = "Cuadernillo.findByTipo", query = "SELECT c FROM Cuadernillo c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Cuadernillo.findByFecha", query = "SELECT c FROM Cuadernillo c WHERE c.fecha = :fecha")})
public class Cuadernillo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codCuadernillo")
    private Integer codCuadernillo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "descMovimiento")
    private byte[] descMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "codExp", referencedColumnName = "codExp")
    @ManyToOne(optional = false)
    private Expedientes codExp;

    public Cuadernillo() {
    }

    public Cuadernillo(Integer codCuadernillo) {
        this.codCuadernillo = codCuadernillo;
    }

    public Cuadernillo(Integer codCuadernillo, String tipo, byte[] descMovimiento, Date fecha) {
        this.codCuadernillo = codCuadernillo;
        this.tipo = tipo;
        this.descMovimiento = descMovimiento;
        this.fecha = fecha;
    }

    public Integer getCodCuadernillo() {
        return codCuadernillo;
    }

    public void setCodCuadernillo(Integer codCuadernillo) {
        this.codCuadernillo = codCuadernillo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getDescMovimiento() {
        return descMovimiento;
    }

    public void setDescMovimiento(byte[] descMovimiento) {
        this.descMovimiento = descMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Expedientes getCodExp() {
        return codExp;
    }

    public void setCodExp(Expedientes codExp) {
        this.codExp = codExp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCuadernillo != null ? codCuadernillo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuadernillo)) {
            return false;
        }
        Cuadernillo other = (Cuadernillo) object;
        if ((this.codCuadernillo == null && other.codCuadernillo != null) || (this.codCuadernillo != null && !this.codCuadernillo.equals(other.codCuadernillo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logica.Cuadernillo[ codCuadernillo=" + codCuadernillo + " ]";
    }
    
}
