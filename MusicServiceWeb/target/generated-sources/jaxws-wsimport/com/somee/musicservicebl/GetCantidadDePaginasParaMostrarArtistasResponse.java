
package com.somee.musicservicebl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCantidadDePaginasParaMostrarArtistasResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCantidadDePaginasParaMostrarArtistasResult"
})
@XmlRootElement(name = "GetCantidadDePaginasParaMostrarArtistasResponse")
public class GetCantidadDePaginasParaMostrarArtistasResponse {

    @XmlElement(name = "GetCantidadDePaginasParaMostrarArtistasResult")
    protected int getCantidadDePaginasParaMostrarArtistasResult;

    /**
     * Gets the value of the getCantidadDePaginasParaMostrarArtistasResult property.
     * 
     */
    public int getGetCantidadDePaginasParaMostrarArtistasResult() {
        return getCantidadDePaginasParaMostrarArtistasResult;
    }

    /**
     * Sets the value of the getCantidadDePaginasParaMostrarArtistasResult property.
     * 
     */
    public void setGetCantidadDePaginasParaMostrarArtistasResult(int value) {
        this.getCantidadDePaginasParaMostrarArtistasResult = value;
    }

}
