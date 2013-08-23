
package com.musicservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for album complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="album">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaPublicacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0" form="unqualified"/>
 *         &lt;element name="generoAlbum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="idAlbum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" form="unqualified"/>
 *         &lt;element name="idArtista" type="{http://service.musicservice.com/}artista" minOccurs="0" form="unqualified"/>
 *         &lt;element name="nombreAlbum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "album", propOrder = {
    "fechaPublicacion",
    "generoAlbum",
    "idAlbum",
    "idArtista",
    "nombreAlbum"
})
public class Album {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaPublicacion;
    protected String generoAlbum;
    protected Integer idAlbum;
    protected Artista idArtista;
    protected String nombreAlbum;

    /**
     * Gets the value of the fechaPublicacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Sets the value of the fechaPublicacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPublicacion(XMLGregorianCalendar value) {
        this.fechaPublicacion = value;
    }

    /**
     * Gets the value of the generoAlbum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneroAlbum() {
        return generoAlbum;
    }

    /**
     * Sets the value of the generoAlbum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneroAlbum(String value) {
        this.generoAlbum = value;
    }

    /**
     * Gets the value of the idAlbum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdAlbum() {
        return idAlbum;
    }

    /**
     * Sets the value of the idAlbum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdAlbum(Integer value) {
        this.idAlbum = value;
    }

    /**
     * Gets the value of the idArtista property.
     * 
     * @return
     *     possible object is
     *     {@link Artista }
     *     
     */
    public Artista getIdArtista() {
        return idArtista;
    }

    /**
     * Sets the value of the idArtista property.
     * 
     * @param value
     *     allowed object is
     *     {@link Artista }
     *     
     */
    public void setIdArtista(Artista value) {
        this.idArtista = value;
    }

    /**
     * Gets the value of the nombreAlbum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAlbum() {
        return nombreAlbum;
    }

    /**
     * Sets the value of the nombreAlbum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAlbum(String value) {
        this.nombreAlbum = value;
    }

}
