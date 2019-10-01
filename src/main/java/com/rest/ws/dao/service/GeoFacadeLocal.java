package com.rest.ws.dao.service;

import com.rest.ws.model.entities.Geo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GeoFacadeLocal {

    void create(Geo geo);

    void edit(Geo geo);

    void remove(Geo geo);

    Geo find(Object id);

    List<Geo> findAll();

    List<Geo> findRange(int[] range);

    int count();
}
