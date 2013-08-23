
package com.musicservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for perfil complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="perfil">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPerfil" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0" form="unqualified"/>
 *         &lt;element name="nombrePerfil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "perfil", propOrder = {
    "idPerfil",
    "nombrePerfil"
})
public class Perfil {

    protected Integer idPerfil;
    protected String nombrePerfil;

    /**
     * Gets the value of the idPerfil property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdPerfil() {
        return idPerfil;
    }

    /**
     * Sets the value of the idPerfil property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdPerfil(Integer value) {
        this.idPerfil = value;
    }

    /**
     * Gets the value of the nombrePerfil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePerfil() {
        return nombrePerfil;
    }

    /**
     * Sets the value of the nombrePerfil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePerfil(String value) {
        this.nombrePerfil = value;
    }

}
