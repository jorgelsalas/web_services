
package com.musicservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAlbum" type="{http://service.musicservice.com/}album" minOccurs="0" form="unqualified"/>
 *         &lt;element name="idCancion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" form="unqualified"/>
 *         &lt;element name="nombreCancion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="numeroTrack" type="{http://www.w3.org/2001/XMLSchema}int" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancion", propOrder = {
    "idAlbum",
    "idCancion",
    "nombreCancion",
    "numeroTrack"
})
public class Cancion {

    protected Album idAlbum;
    protected Integer idCancion;
    protected String nombreCancion;
    protected int numeroTrack;

    /**
     * Gets the value of the idAlbum property.
     * 
     * @return
     *     possible object is
     *     {@link Album }
     *     
     */
    public Album getIdAlbum() {
        return idAlbum;
    }

    /**
     * Sets the value of the idAlbum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Album }
     *     
     */
    public void setIdAlbum(Album value) {
        this.idAlbum = value;
    }

    /**
     * Gets the value of the idCancion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCancion() {
        return idCancion;
    }

    /**
     * Sets the value of the idCancion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCancion(Integer value) {
        this.idCancion = value;
    }

    /**
     * Gets the value of the nombreCancion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCancion() {
        return nombreCancion;
    }

    /**
     * Sets the value of the nombreCancion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCancion(String value) {
        this.nombreCancion = value;
    }

    /**
     * Gets the value of the numeroTrack property.
     * 
     */
    public int getNumeroTrack() {
        return numeroTrack;
    }

    /**
     * Sets the value of the numeroTrack property.
     * 
     */
    public void setNumeroTrack(int value) {
        this.numeroTrack = value;
    }

}
