package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.Sort;

@Entity
@Table(name = "TB_CIDADES")
public class Cidades {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "ibge_id")
	private Number ibge_id;

	@Column(name = "uf")
	private String uf;

	@Column(name = "name")
    private String name;

    @Column(name = "capital")
    private boolean capital;

    @Column(name = "lon")
    private String lon;

    @Column(name = "lat")
    private String lat;

    @Column(name = "no_accents")
    private String no_accents;

    @Column(name = "alternative_names")
    private String alternative_names;

    @Column(name = "microregion")
    private String microregion;

    @Column(name = "mesoregion")
    private String mesoregion;

    public Sort getId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Number getIbge_id() {
        return ibge_id;
    }

    public void setIbge_id(Number ibge_id) {
        this.ibge_id = ibge_id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getNo_accents() {
        return no_accents;
    }

    public void setNo_accents(String no_accents) {
        this.no_accents = no_accents;
    }

    public String getAlternative_names() {
        return alternative_names;
    }

    public void setAlternative_names(String alternative_names) {
        this.alternative_names = alternative_names;
    }

    public String getMicroregion() {
        return microregion;
    }

    public void setMicroregion(String microregion) {
        this.microregion = microregion;
    }

    public String getMesoregion() {
        return mesoregion;
    }

    public void setMesoregion(String mesoregion) {
        this.mesoregion = mesoregion;
    }
    
    
}