/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaver
 */
@Entity
@Table(name = "cancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c"),
    @NamedQuery(name = "Cancion.findByIdAlbum", query = "SELECT c FROM Cancion c WHERE c.idAlbum = :idAlbum"),
    @NamedQuery(name = "Cancion.findByIdCancion", query = "SELECT c FROM Cancion c WHERE c.idCancion = :idCancion"),
    @NamedQuery(name = "Cancion.findByNombreCancion", query = "SELECT c FROM Cancion c WHERE c.nombreCancion = :nombreCancion"),
    @NamedQuery(name = "Cancion.findByNumeroTrack", query = "SELECT c FROM Cancion c WHERE c.numeroTrack = :numeroTrack"),
    @NamedQuery(name = "Cancion.findCantidadCanciones", query = "SELECT COUNT(c) FROM Cancion c "),

})
public class Cancion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cancion")
    private Integer idCancion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_cancion")
    private String nombreCancion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_track")
    private int numeroTrack;
    @JoinColumn(name = "id_album", referencedColumnName = "id_album")
    @ManyToOne(optional = false)
    private Album idAlbum;

    public Cancion() {
    }

    public Cancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public Cancion(Integer idCancion, String nombreCancion, int numeroTrack) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.numeroTrack = numeroTrack;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public int getNumeroTrack() {
        return numeroTrack;
    }

    public void setNumeroTrack(int numeroTrack) {
        this.numeroTrack = numeroTrack;
    }

    public Album getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Album idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCancion != null ? idCancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.idCancion == null && other.idCancion != null) || (this.idCancion != null && !this.idCancion.equals(other.idCancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.musicservice.entities.Cancion[ idCancion=" + idCancion + " ]";
    }
    
}
