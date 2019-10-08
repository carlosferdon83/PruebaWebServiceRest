package com.rest.ws.dao.service;

import com.rest.ws.model.entities.Address;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AddressFacadeLocal {

    Address create(Address address);

    void edit(Address address);

    void remove(Address address);

    Address find(Object id);

    List<Address> findAll();

    List<Address> findRange(int[] range);

    int count();
}
