/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jpa.entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ildevana
 */
@Entity
@Table(name = "CLIENTE_MESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteMesa.findAll", query = "SELECT c FROM ClienteMesa c"),
    @NamedQuery(name = "ClienteMesa.findByIdmesa", query = "SELECT c FROM ClienteMesa c WHERE c.clienteMesaPK.idmesa = :idmesa"),
    @NamedQuery(name = "ClienteMesa.findByIdcliente", query = "SELECT c FROM ClienteMesa c WHERE c.clienteMesaPK.idcliente = :idcliente"),
    @NamedQuery(name = "ClienteMesa.findByIdperiodo", query = "SELECT c FROM ClienteMesa c WHERE c.clienteMesaPK.idperiodo = :idperiodo"),
    @NamedQuery(name = "ClienteMesa.findByData", query = "SELECT c FROM ClienteMesa c WHERE c.data = :data"),
    @NamedQuery(name = "ClienteMesa.findByQtdocupada", query = "SELECT c FROM ClienteMesa c WHERE c.qtdocupada = :qtdocupada")})
public class ClienteMesa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteMesaPK clienteMesaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTDOCUPADA", nullable = false)
    private int qtdocupada;
    @JoinColumn(name = "IDPERIODO", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "IDMESA", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Mesa mesa;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;

    public ClienteMesa() {
    }

    public ClienteMesa(ClienteMesaPK clienteMesaPK) {
        this.clienteMesaPK = clienteMesaPK;
    }

    public ClienteMesa(ClienteMesaPK clienteMesaPK, Date data, int qtdocupada) {
        this.clienteMesaPK = clienteMesaPK;
        this.data = data;
        this.qtdocupada = qtdocupada;
    }

    public ClienteMesa(int idmesa, int idcliente, int idperiodo) {
        this.clienteMesaPK = new ClienteMesaPK(idmesa, idcliente, idperiodo);
    }

    public ClienteMesaPK getClienteMesaPK() {
        return clienteMesaPK;
    }

    public void setClienteMesaPK(ClienteMesaPK clienteMesaPK) {
        this.clienteMesaPK = clienteMesaPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQtdocupada() {
        return qtdocupada;
    }

    public void setQtdocupada(int qtdocupada) {
        this.qtdocupada = qtdocupada;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteMesaPK != null ? clienteMesaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteMesa)) {
            return false;
        }
        ClienteMesa other = (ClienteMesa) object;
        if ((this.clienteMesaPK == null && other.clienteMesaPK != null) || (this.clienteMesaPK != null && !this.clienteMesaPK.equals(other.clienteMesaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jpa.entites.ClienteMesa[ clienteMesaPK=" + clienteMesaPK + " ]";
    }
    
}
