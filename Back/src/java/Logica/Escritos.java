/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author claud
 */
@Entity
@Table(name = "escritos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escritos.findAll", query = "SELECT e FROM Escritos e")
    , @NamedQuery(name = "Escritos.findByCodEscrito", query = "SELECT e FROM Escritos e WHERE e.codEscrito = :codEscrito")})
public class Escritos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codEscrito")
    private Integer codEscrito;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "escritos")
    private String escritos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "titulo")
    private String titulo;
    @JoinColumn(name = "codExp", referencedColumnName = "codExp")
    @ManyToOne(optional = false)
    private Expedientes codExp;

    public Escritos() {
    }

    public Escritos(Integer codEscrito) {
        this.codEscrito = codEscrito;
    }

    public Escritos(Integer codEscrito, String escritos, String titulo) {
        this.codEscrito = codEscrito;
        this.escritos = escritos;
        this.titulo = titulo;
    }

    public Integer getCodEscrito() {
        return codEscrito;
    }

    public void setCodEscrito(Integer codEscrito) {
        this.codEscrito = codEscrito;
    }

    public String getEscritos() {
        return escritos;
    }

    public void setEscritos(String escritos) {
        this.escritos = escritos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
        hash += (codEscrito != null ? codEscrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escritos)) {
            return false;
        }
        Escritos other = (Escritos) object;
        if ((this.codEscrito == null && other.codEscrito != null) || (this.codEscrito != null && !this.codEscrito.equals(other.codEscrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titulo;
    }
    
}
