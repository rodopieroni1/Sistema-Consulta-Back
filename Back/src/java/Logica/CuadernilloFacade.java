/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author claud
 */
@Stateless
public class CuadernilloFacade extends AbstractFacade<Cuadernillo> {

    @PersistenceContext(unitName = "SistemaConsultasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuadernilloFacade() {
        super(Cuadernillo.class);
    }
    
}
