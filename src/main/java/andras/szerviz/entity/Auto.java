/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andras.szerviz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Andras
 */
@Entity
public class Auto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rendszam;
    
    private String marka;
    
    private String tipus;
    
    private String motorszam;
    
    private String alvazszam;
    
    private String uzemanyag;
    
    private int kmOraAllas;
    
    private int ccm;
    
    private Date garanciaLejarat;
    
    @ManyToOne
    private Ugyfel ugyfel;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getMotorszam() {
        return motorszam;
    }

    public void setMotorszam(String motorszam) {
        this.motorszam = motorszam;
    }

    public String getAlvazszam() {
        return alvazszam;
    }

    public void setAlvazszam(String alvazszam) {
        this.alvazszam = alvazszam;
    }

    public String getUzemanyag() {
        return uzemanyag;
    }

    public void setUzemanyag(String uzemanyag) {
        this.uzemanyag = uzemanyag;
    }

    public int getKmOraAllas() {
        return kmOraAllas;
    }

    public void setKmOraAllas(int kmOraAllas) {
        this.kmOraAllas = kmOraAllas;
    }

    public int getCcm() {
        return ccm;
    }

    public void setCcm(int ccm) {
        this.ccm = ccm;
    }

    public Date getGaranciaLejarat() {
        return garanciaLejarat;
    }

    public void setGaranciaLejarat(Date garanciaLejarat) {
        this.garanciaLejarat = garanciaLejarat;
    }

    public Ugyfel getUgyfel() {
        return ugyfel;
    }

    public void setUgyfel(Ugyfel ugyfel) {
        this.ugyfel = ugyfel;
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
        if (!(object instanceof Auto)) {
            return false;
        }
        Auto other = (Auto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andras.szerviz.entity.Auto[ id=" + id + " ]";
    }
    
}
