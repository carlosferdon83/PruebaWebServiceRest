/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.ws.business.operaciones;

import com.rest.ws.model.entities.Address;
import com.rest.ws.model.entities.Company;
import com.rest.ws.model.entities.Geo;
import com.rest.ws.model.entities.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Fernando
 */
@Local
public interface OperacionesLocal {
    
    public Geo guardarGeo(Geo geo);
    public Address guardarAddress(Address address);
    public Company guardarCompany(Company company);
    public Persona guardarPersona(Persona persona);
    public List<Persona> listaPersonas();
    
}
