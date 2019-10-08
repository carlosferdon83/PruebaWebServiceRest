/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soap.ws.view.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rest.ws.business.operaciones.OperacionesLocal;
import com.rest.ws.model.entities.Address;
import com.rest.ws.model.entities.Company;
import com.rest.ws.model.entities.Geo;
import com.rest.ws.model.entities.Persona;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Carlos Fernando
 */
@Named(value = "empleadosController")
@ViewScoped
public class EmpleadosController {
    
    @EJB
    private OperacionesLocal operacionesLocal;
    
    private String webUrl;
    
    private Address address;
    private Geo geo;
    private Persona personas;
    private Company company;
    private List<Persona> listaPersona;

    @PostConstruct
    public void init(){
        webUrl = "https://jsonplaceholder.typicode.com/users";
        initComponents();
    }
    
    public void initComponents(){
        address = new Address();
        geo = new Geo();
        personas = new Persona();
        company = new Company();
    }
    
    public void consumirServicio(){
        try{
            final GsonBuilder gsonBuilder = new GsonBuilder();
            final Gson gson = gsonBuilder.create();

            InputStream is = new URL(webUrl).openStream();
            Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);           
            Persona[] persona = gson.fromJson(reader, Persona[].class);
            this.insercionRegistros(persona);
            /**/
        } catch (IOException ex) {
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    private void insercionRegistros(Persona[] persona){
        try{
            for(int i=0;i<persona.length;i++){
                //System.out.println(persona[i].getEmail());
                geo.setLat(persona[i].getAddress().getIdGeo().getLat());
                geo.setLng(persona[i].getAddress().getIdGeo().getLng());
                Geo guardarGeo = operacionesLocal.guardarGeo(geo);

                address.setStreet(persona[i].getAddress().getStreet());
                address.setCity(persona[i].getAddress().getCity());
                address.setSuite(persona[i].getAddress().getSuite());
                address.setZipcode(persona[i].getAddress().getZipcode());
                address.setIdGeo(new Geo(guardarGeo.getIdGeo()));
                Address guardarAddress = operacionesLocal.guardarAddress(address);

                company.setCatchphrase(persona[i].getIdCompany().getCatchphrase());
                company.setBs(persona[i].getIdCompany().getBs());
                company.setName(persona[i].getIdCompany().getName());
                Company guardarCompany = operacionesLocal.guardarCompany(company);
                
                personas.setId(persona[i].getId());
                personas.setName(persona[i].getName());
                personas.setUsername(persona[i].getUsername());
                personas.setWebsite(persona[i].getWebsite());
                personas.setEmail(persona[i].getEmail());
                personas.setPhone(persona[i].getPhone());
                personas.setAddress(new Address(guardarAddress.getIdAddress()));
                personas.setIdCompany(new Company(guardarCompany.getIdCompany()));
                Persona guardarPersona = operacionesLocal.guardarPersona(personas);
            }
        }catch(Exception ex){
            
        }       
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Persona getPersonas() {
        return personas;
    }

    public void setPersonas(Persona personas) {
        this.personas = personas;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Persona> getListaPersona() {
        listaPersona = operacionesLocal.listaPersonas();
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }
    
}
