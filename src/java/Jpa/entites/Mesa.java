/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jpa.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ildevana
 */
@Entity
@Table(name = "MESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m"),
    @NamedQuery(name = "Mesa.findById", query = "SELECT m FROM Mesa m WHERE m.id = :id"),
    @NamedQuery(name = "Mesa.findByCapacidadepessoas", query = "SELECT m FROM Mesa m WHERE m.capacidadepessoas = :capacidadepessoas"),
    @NamedQuery(name = "Mesa.findByOcupada", query = "SELECT m FROM Mesa m WHERE m.ocupada = :ocupada")})
public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDADEPESSOAS", nullable = false)
    private int capacidadepessoas;
    @Column(name = "OCUPADA")
    private Boolean ocupada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesa")
    private List<ClienteMesa> clienteMesaList;

    public Mesa() {
    }

    public Mesa(Integer id) {
        this.id = id;
    }

    public Mesa(Integer id, int capacidadepessoas) {
        this.id = id;
        this.capacidadepessoas = capacidadepessoas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacidadepessoas() {
        return capacidadepessoas;
    }

    public void setCapacidadepessoas(int capacidadepessoas) {
        this.capacidadepessoas = capacidadepessoas;
    }

    public Boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    @XmlTransient
    public List<ClienteMesa> getClienteMesaList() {
        return clienteMesaList;
    }

    public void setClienteMesaList(List<ClienteMesa> clienteMesaList) {
        this.clienteMesaList = clienteMesaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jpa.entites.Mesa[ id=" + id + " ]";
    }
    
}
