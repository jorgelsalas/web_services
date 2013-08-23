
package com.musicservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for artista complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="artista">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="generoArtista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="idArtista" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" form="unqualified"/>
 *         &lt;element name="nombreArtista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artista", propOrder = {
    "generoArtista",
    "idArtista",
    "nombreArtista"
})
public class Artista {

    protected String generoArtista;
    protected Integer idArtista;
    protected String nombreArtista;

    /**
     * Gets the value of the generoArtista property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneroArtista() {
        return generoArtista;
    }

    /**
     * Sets the value of the generoArtista property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneroArtista(String value) {
        this.generoArtista = value;
    }

    /**
     * Gets the value of the idArtista property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdArtista() {
        return idArtista;
    }

    /**
     * Sets the value of the idArtista property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdArtista(Integer value) {
        this.idArtista = value;
    }

    /**
     * Gets the value of the nombreArtista property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreArtista() {
        return nombreArtista;
    }

    /**
     * Sets the value of the nombreArtista property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreArtista(String value) {
        this.nombreArtista = value;
    }

}
