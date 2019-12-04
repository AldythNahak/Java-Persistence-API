/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aprius
 */
@Entity
@Table(name = "tb_mahasiswa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMahasiswa.findAll", query = "SELECT t FROM TbMahasiswa t"),
    @NamedQuery(name = "TbMahasiswa.findByNim", query = "SELECT t FROM TbMahasiswa t WHERE t.nim = :nim"),
    @NamedQuery(name = "TbMahasiswa.findByNama", query = "SELECT t FROM TbMahasiswa t WHERE t.nama = :nama"),
    @NamedQuery(name = "TbMahasiswa.findByProgdi", query = "SELECT t FROM TbMahasiswa t WHERE t.progdi = :progdi")})
public class TbMahasiswa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nim")
    private Integer nim;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "progdi")
    private String progdi;

    public TbMahasiswa() {
    }

    public TbMahasiswa(Integer nim) {
        this.nim = nim;
    }

    public TbMahasiswa(Integer nim, String nama, String progdi) {
        this.nim = nim;
        this.nama = nama;
        this.progdi = progdi;
    }

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProgdi() {
        return progdi;
    }

    public void setProgdi(String progdi) {
        this.progdi = progdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMahasiswa)) {
            return false;
        }
        TbMahasiswa other = (TbMahasiswa) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbMahasiswa[ nim=" + nim + " ]";
    }
    
}
