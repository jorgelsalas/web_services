
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
 *         &lt;element name="GetCantidadDePaginasParaMostrarCancionesResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "getCantidadDePaginasParaMostrarCancionesResult"
})
@XmlRootElement(name = "GetCantidadDePaginasParaMostrarCancionesResponse")
public class GetCantidadDePaginasParaMostrarCancionesResponse {

    @XmlElement(name = "GetCantidadDePaginasParaMostrarCancionesResult")
    protected int getCantidadDePaginasParaMostrarCancionesResult;

    /**
     * Gets the value of the getCantidadDePaginasParaMostrarCancionesResult property.
     * 
     */
    public int getGetCantidadDePaginasParaMostrarCancionesResult() {
        return getCantidadDePaginasParaMostrarCancionesResult;
    }

    /**
     * Sets the value of the getCantidadDePaginasParaMostrarCancionesResult property.
     * 
     */
    public void setGetCantidadDePaginasParaMostrarCancionesResult(int value) {
        this.getCantidadDePaginasParaMostrarCancionesResult = value;
    }

}
