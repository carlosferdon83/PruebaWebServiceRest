/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.ws.business.operaciones;

import com.rest.ws.dao.service.AddressFacadeLocal;
import com.rest.ws.dao.service.CompanyFacadeLocal;
import com.rest.ws.dao.service.GeoFacadeLocal;
import com.rest.ws.dao.service.PersonaFacadeLocal;
import com.rest.ws.model.entities.Address;
import com.rest.ws.model.entities.Company;
import com.rest.ws.model.entities.Geo;
import com.rest.ws.model.entities.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Carlos Fernando
 */
@Stateless
public class Operaciones implements OperacionesLocal {
    
    @EJB
    private GeoFacadeLocal geoFacadeLocal;
    
    @EJB
    private AddressFacadeLocal addressFacadeLocal;
    
    @EJB
    private CompanyFacadeLocal companyFacadeLocal;
    
    @EJB
    private PersonaFacadeLocal personaFacadeLocal;   
    

    @Override
    public Geo guardarGeo(Geo geo) {
        Geo infoGeo = geoFacadeLocal.create(geo);
        return infoGeo;
    }

    @Override
    public Address guardarAddress(Address address) {
        Address infoAddress = addressFacadeLocal.create(address);
        return infoAddress;
    }

    @Override
    public Company guardarCompany(Company company) {
        Company infoCompany = companyFacadeLocal.create(company);
        return infoCompany;
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        Persona infoPersona = personaFacadeLocal.create(persona);
        return infoPersona;
    }

    @Override
    public List<Persona> listaPersonas() {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas = personaFacadeLocal.findAll();
        return listaPersonas;
    }

    
}
