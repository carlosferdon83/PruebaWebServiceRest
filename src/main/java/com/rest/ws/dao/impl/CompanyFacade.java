/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.ws.dao.impl;

import com.rest.ws.dao.service.CompanyFacadeLocal;
import com.rest.ws.crud.CrudService;
import com.rest.ws.model.entities.Company;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class CompanyFacade extends CrudService<Company> implements CompanyFacadeLocal {

    @PersistenceContext(unitName = "com.rest.ws_PruebaWebServiceRest_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompanyFacade() {
        super(Company.class);
    }
    
}
