
package com.somee.musicservicebl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="getArtistasDePaginaResult" type="{http://musicservicebl.somee.com}ArrayOfArtista" minOccurs="0"/>
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
    "getArtistasDePaginaResult"
})
@XmlRootElement(name = "getArtistasDePaginaResponse")
public class GetArtistasDePaginaResponse {

    protected ArrayOfArtista getArtistasDePaginaResult;

    /**
     * Gets the value of the getArtistasDePaginaResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArtista }
     *     
     */
    public ArrayOfArtista getGetArtistasDePaginaResult() {
        return getArtistasDePaginaResult;
    }

    /**
     * Sets the value of the getArtistasDePaginaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArtista }
     *     
     */
    public void setGetArtistasDePaginaResult(ArrayOfArtista value) {
        this.getArtistasDePaginaResult = value;
    }

}
