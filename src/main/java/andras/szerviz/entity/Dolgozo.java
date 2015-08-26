/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andras.szerviz.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Andras
 */
@Entity
public class Dolgozo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 45, nullable = false)
    private String nev;
    
    @Column(length = 15, nullable = false)
    private String jelszo;
    
    @Column(length = 20)
    private String jogkor; 
    
    private boolean torolhetoe;

    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getJogkor() {
        return jogkor;
    }

    public void setJogkor(String jogkor) {
        this.jogkor = jogkor;
    }

    public boolean isTorolhetoe() {
        return torolhetoe;
    }

    public void setTorolhetoe(boolean torolhetoe) {
        this.torolhetoe = torolhetoe;
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
        if (!(object instanceof Dolgozo)) {
            return false;
        }
        Dolgozo other = (Dolgozo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andras.szerviz.entity.Dolgozo[ id=" + id + " ]";
    }
    
}
