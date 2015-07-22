/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andras.szerviz.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Size;



/**
 *
 * @author Andras
 */
@Entity
public class Ugyfel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 45, nullable = false)
    @Size(max = 45)
    @NotEmpty
    private String nev;

    @Column(length = 60)
    @Size(max = 60)
    private String cim;

    @Column(length = 25)
    @Size(max = 25)
    private String telefon;
    
    @Column(length = 25, unique = true)
    @Size(max = 25)
    private String email;
    
    @OneToMany(mappedBy = "ugyfel")
    private Collection<Auto> autok;
    

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

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Auto> getAutok() {
        return autok;
    }

    public void setAutok(Collection<Auto> autok) {
        this.autok = autok;
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
        if (!(object instanceof Ugyfel)) {
            return false;
        }
        Ugyfel other = (Ugyfel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "andras.szerviz.entity.Ugyfel[ id=" + id + " ]";
    }
    
}
