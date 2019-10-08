package com.rest.ws.dao.service;

import com.rest.ws.model.entities.Persona;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PersonaFacadeLocal {

    Persona create(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();
}
