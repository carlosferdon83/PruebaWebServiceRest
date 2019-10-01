/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.ws.dao.service;

import com.rest.ws.model.entities.Address;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Carlos Fernando
 */
@Local
public interface AddressFacadeLocal {

    void create(Address address);

    void edit(Address address);

    void remove(Address address);

    Address find(Object id);

    List<Address> findAll();

    List<Address> findRange(int[] range);

    int count();
    
}
