/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.ws.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Fernando
 */
@Entity
@Table(name = "address", catalog = "prueba", schema = "pruebas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByIdAddress", query = "SELECT a FROM Address a WHERE a.idAddress = :idAddress")
    , @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street")
    , @NamedQuery(name = "Address.findBySuite", query = "SELECT a FROM Address a WHERE a.suite = :suite")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByZipcode", query = "SELECT a FROM Address a WHERE a.zipcode = :zipcode")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_address", nullable = false)
    private Integer idAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "street", nullable = false, length = 50)
    private String street;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "suite", nullable = false, length = 50)
    private String suite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "zipcode", nullable = false, length = 50)
    private String zipcode;
    @JoinColumn(name = "id_geo", referencedColumnName = "id_geo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Geo idGeo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.LAZY)
    private Persona persona;

    public Address() {
    }

    public Address(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Address(Integer idAddress, String street, String suite, String city, String zipcode) {
        this.idAddress = idAddress;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getIdGeo() {
        return idGeo;
    }

    public void setIdGeo(Geo idGeo) {
        this.idGeo = idGeo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddress != null ? idAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.idAddress == null && other.idAddress != null) || (this.idAddress != null && !this.idAddress.equals(other.idAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rest.ws.model.entities.Address[ idAddress=" + idAddress + " ]";
    }
    
}
