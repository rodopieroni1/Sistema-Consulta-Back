/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author claud
 */
@Entity
@Table(name = "expedientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expedientes.findAll", query = "SELECT e FROM Expedientes e")
    , @NamedQuery(name = "Expedientes.findByCodExp", query = "SELECT e FROM Expedientes e WHERE e.codExp = :codExp")
    , @NamedQuery(name = "Expedientes.findByNumExpediente", query = "SELECT e FROM Expedientes e WHERE e.numExpediente = :numExpediente")
    , @NamedQuery(name = "Expedientes.findByFecha", query = "SELECT e FROM Expedientes e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Expedientes.findBySegundaInstancia", query = "SELECT e FROM Expedientes e WHERE e.segundaInstancia = :segundaInstancia")})
public class Expedientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codExp")
    private Integer codExp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numExpediente")
    private int numExpediente;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "Movimiento")
    private String movimiento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "caratula")
    private String caratula;
    @Column(name = "SegundaInstancia")
    private Integer segundaInstancia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codExp")
    private Collection<Cuadernillo> cuadernilloCollection;
    @JoinColumn(name = "codJuzgado", referencedColumnName = "codJuzgado")
    @ManyToOne(optional = false)
    private Juzgados codJuzgado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codExp")
    private Collection<Escritos> escritosCollection;

    public Expedientes() {
    }

    public Expedientes(Integer codExp) {
        this.codExp = codExp;
    }

    public Expedientes(Integer codExp, int numExpediente, String caratula) {
        this.codExp = codExp;
        this.numExpediente = numExpediente;
        this.caratula = caratula;
    }

    public Integer getCodExp() {
        return codExp;
    }

    public void setCodExp(Integer codExp) {
        this.codExp = codExp;
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getCaratula() {
        return caratula;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public Integer getSegundaInstancia() {
        return segundaInstancia;
    }

    public void setSegundaInstancia(Integer segundaInstancia) {
        this.segundaInstancia = segundaInstancia;
    }

    @XmlTransient
    public Collection<Cuadernillo> getCuadernilloCollection() {
        return cuadernilloCollection;
    }

    public void setCuadernilloCollection(Collection<Cuadernillo> cuadernilloCollection) {
        this.cuadernilloCollection = cuadernilloCollection;
    }

    public Juzgados getCodJuzgado() {
        return codJuzgado;
    }

    public void setCodJuzgado(Juzgados codJuzgado) {
        this.codJuzgado = codJuzgado;
    }

    @XmlTransient
    public Collection<Escritos> getEscritosCollection() {
        return escritosCollection;
    }

    public void setEscritosCollection(Collection<Escritos> escritosCollection) {
        this.escritosCollection = escritosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codExp != null ? codExp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expedientes)) {
            return false;
        }
        Expedientes other = (Expedientes) object;
        if ((this.codExp == null && other.codExp != null) || (this.codExp != null && !this.codExp.equals(other.codExp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+numExpediente+"";
    }
    
}
