/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.ws.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Fernando
 */
@Entity
@Table(name = "geo", catalog = "prueba", schema = "pruebas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geo.findAll", query = "SELECT g FROM Geo g")
    , @NamedQuery(name = "Geo.findByIdGeo", query = "SELECT g FROM Geo g WHERE g.idGeo = :idGeo")
    , @NamedQuery(name = "Geo.findByLat", query = "SELECT g FROM Geo g WHERE g.lat = :lat")
    , @NamedQuery(name = "Geo.findByLng", query = "SELECT g FROM Geo g WHERE g.lng = :lng")})
public class Geo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_geo", nullable = false)
    private Integer idGeo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lat", nullable = false, length = 50)
    private String lat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lng", nullable = false, length = 50)
    private String lng;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGeo", fetch = FetchType.LAZY)
    private List<Address> addressList;

    public Geo() {
    }

    public Geo(Integer idGeo) {
        this.idGeo = idGeo;
    }

    public Geo(Integer idGeo, String lat, String lng) {
        this.idGeo = idGeo;
        this.lat = lat;
        this.lng = lng;
    }

    public Integer getIdGeo() {
        return idGeo;
    }

    public void setIdGeo(Integer idGeo) {
        this.idGeo = idGeo;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGeo != null ? idGeo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geo)) {
            return false;
        }
        Geo other = (Geo) object;
        if ((this.idGeo == null && other.idGeo != null) || (this.idGeo != null && !this.idGeo.equals(other.idGeo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rest.ws.model.entities.Geo[ idGeo=" + idGeo + " ]";
    }
    
}
