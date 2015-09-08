/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andras.szerviz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.validator.Size;

/**
 *
 * @author Andras
 */
@Entity
public class Munka implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date felvetelIdeje;
    
    @Column(nullable = false)
    private Date varhatoElkeszulIdo;
    
    @Column(length = 250, nullable = false)
    @Size(max = 250)
    private String hibaleiras;
    
    @Column(length = 6, nullable = false)
    private int kmOraAllas;
    
    
    private boolean munkaGarancia;
    
    @Column(length = 30, nullable = false)
    private String status;

    private Date garanciaLejarat;
    
    @ManyToOne
    private Dolgozo dolgozo;
    
    @ManyToOne
    private Ugyfel ugyfel;
    
    @ManyToOne
    private Auto auto;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getFelvetelIdeje() {
        return felvetelIdeje;
    }

    public void setFelvetelIdeje(Date felvetelIdeje) {
        this.felvetelIdeje = felvetelIdeje;
    }

    public Date getVarhatoElkeszulIdo() {
        return varhatoElkeszulIdo;
    }

    public void setVarhatoElkeszulIdo(Date varhatoElkeszulIdo) {
        this.varhatoElkeszulIdo = varhatoElkeszulIdo;
    }

    public boolean isMunkaGarancia() {
        return munkaGarancia;
    }

    public void setMunkaGarancia(boolean munkaGarancia) {
        this.munkaGarancia = munkaGarancia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getKmOraAllas() {
        return kmOraAllas;
    }

    public void setKmOraAllas(int kmOraAllas) {
        this.kmOraAllas = kmOraAllas;
    }

    public Date getGaranciaLejarat() {
        return garanciaLejarat;
    }

    public void setGaranciaLejarat(Date garanciaLejarat) {
        this.garanciaLejarat = garanciaLejarat;
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
        if (!(object instanceof Munka)) {
            return false;
        }
        Munka other = (Munka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andras.szerviz.entity.Munka[ id=" + id + " ]";
    }
    
}
