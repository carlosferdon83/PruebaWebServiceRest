package com.rest.ws.dao.service;

import com.rest.ws.model.entities.Company;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CompanyFacadeLocal {

    void create(Company company);

    void edit(Company company);

    void remove(Company company);

    Company find(Object id);

    List<Company> findAll();

    List<Company> findRange(int[] range);

    int count();
}
