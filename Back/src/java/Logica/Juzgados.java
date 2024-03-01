/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author claud
 */
@Entity
@Table(name = "juzgados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juzgados.findAll", query = "SELECT j FROM Juzgados j")
    , @NamedQuery(name = "Juzgados.findByCodJuzgado", query = "SELECT j FROM Juzgados j WHERE j.codJuzgado = :codJuzgado")})
public class Juzgados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codJuzgado")
    private Integer codJuzgado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "juzgado")
    private String juzgado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codJuzgado")
    private Collection<Expedientes> expedientesCollection;

    public Juzgados() {
    }

    public Juzgados(Integer codJuzgado) {
        this.codJuzgado = codJuzgado;
    }

    public Juzgados(Integer codJuzgado, String juzgado) {
        this.codJuzgado = codJuzgado;
        this.juzgado = juzgado;
    }

    public Integer getCodJuzgado() {
        return codJuzgado;
    }

    public void setCodJuzgado(Integer codJuzgado) {
        this.codJuzgado = codJuzgado;
    }

    public String getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    @XmlTransient
    public Collection<Expedientes> getExpedientesCollection() {
        return expedientesCollection;
    }

    public void setExpedientesCollection(Collection<Expedientes> expedientesCollection) {
        this.expedientesCollection = expedientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codJuzgado != null ? codJuzgado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juzgados)) {
            return false;
        }
        Juzgados other = (Juzgados) object;
        if ((this.codJuzgado == null && other.codJuzgado != null) || (this.codJuzgado != null && !this.codJuzgado.equals(other.codJuzgado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return juzgado;
    }
    
}
