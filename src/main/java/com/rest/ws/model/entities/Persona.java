/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.ws.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "persona", catalog = "prueba", schema = "pruebas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id")
    , @NamedQuery(name = "Persona.findByName", query = "SELECT p FROM Persona p WHERE p.name = :name")
    , @NamedQuery(name = "Persona.findByUsername", query = "SELECT p FROM Persona p WHERE p.username = :username")
    , @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email")
    , @NamedQuery(name = "Persona.findByIdAddress", query = "SELECT p FROM Persona p WHERE p.idAddress = :idAddress")
    , @NamedQuery(name = "Persona.findByPhone", query = "SELECT p FROM Persona p WHERE p.phone = :phone")
    , @NamedQuery(name = "Persona.findByWebsite", query = "SELECT p FROM Persona p WHERE p.website = :website")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_address", nullable = false)
    private int idAddress;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "website", nullable = false, length = 50)
    private String website;
    @JoinColumn(name = "id", referencedColumnName = "id_address", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Address address;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company idCompany;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String name, String username, String email, int idAddress, String phone, String website) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.idAddress = idAddress;
        this.phone = phone;
        this.website = website;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Company idCompany) {
        this.idCompany = idCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rest.ws.model.entities.Persona[ id=" + id + " ]";
    }
    
}
