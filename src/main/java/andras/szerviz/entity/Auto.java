/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andras.szerviz.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.validator.Size;

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

    @Column(length = 7, nullable = false, unique = true)
    @Size(max = 7)
    private String rendszam;
    
    // @Column(length = 25, nullable = false)
    // @Size(max = 15)
    @ManyToOne
    private Marka marka;
    
    @Column(length = 25, nullable = false)
    @Size(max = 25)
    private String tipus;
    
    @Column(length = 15, nullable = false)
    @Size(max = 15)
    private String motorszam;
    
    @Column(length = 25, nullable = false, unique = true)
    @Size(max = 25)
    private String alvazszam;
    
    @Column(length = 10, nullable = false)
    @Size(max = 10)
    private String uzemanyag;
    
    @Column(length = 6, nullable = false)
    private int kmOraAllas;
    
    @Column(length = 4, nullable = false)
    private int ccm;
    
    private Date garanciaLejarat;
    
    @OneToMany(mappedBy = "auto")
    private Collection<Munka> munkak;
    
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

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
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

    public Collection<Munka> getMunkak() {
        return munkak;
    }

    public void setMunkak(Collection<Munka> munkak) {
        this.munkak = munkak;
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
