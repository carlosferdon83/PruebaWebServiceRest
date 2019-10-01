/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.ws.dao.service;

import com.rest.ws.model.entities.Geo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Fernando
 */
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
