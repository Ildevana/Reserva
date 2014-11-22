/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jpa.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ildevana
 */
@Embeddable
public class ClienteMesaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMESA", nullable = false)
    private int idmesa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCLIENTE", nullable = false)
    private int idcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPERIODO", nullable = false)
    private int idperiodo;

    public ClienteMesaPK() {
    }

    public ClienteMesaPK(int idmesa, int idcliente, int idperiodo) {
        this.idmesa = idmesa;
        this.idcliente = idcliente;
        this.idperiodo = idperiodo;
    }

    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(int idperiodo) {
        this.idperiodo = idperiodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmesa;
        hash += (int) idcliente;
        hash += (int) idperiodo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteMesaPK)) {
            return false;
        }
        ClienteMesaPK other = (ClienteMesaPK) object;
        if (this.idmesa != other.idmesa) {
            return false;
        }
        if (this.idcliente != other.idcliente) {
            return false;
        }
        if (this.idperiodo != other.idperiodo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jpa.entites.ClienteMesaPK[ idmesa=" + idmesa + ", idcliente=" + idcliente + ", idperiodo=" + idperiodo + " ]";
    }
    
}
