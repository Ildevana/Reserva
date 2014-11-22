/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jpa.session;

import Jpa.entites.ClienteMesa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ildevana
 */
@Stateless
public class ClienteMesaFacade extends AbstractFacade<ClienteMesa> {
    @PersistenceContext(unitName = "ReservasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteMesaFacade() {
        super(ClienteMesa.class);
    }
    
}
