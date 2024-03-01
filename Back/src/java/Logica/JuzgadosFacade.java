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
 * @author Pieroni
 */
@Stateless
public class JuzgadosFacade extends AbstractFacade<Juzgados> {
    @PersistenceContext(unitName = "SistemaConsultasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JuzgadosFacade() {
        super(Juzgados.class);
    }
    
}
