
package com.somee.musicservicebl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.musicservice.service.Artista;


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
 *         &lt;element name="getArtistaByIdResult" type="{http://service.musicservice.com/}artista" minOccurs="0"/>
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
    "getArtistaByIdResult"
})
@XmlRootElement(name = "getArtistaByIdResponse")
public class GetArtistaByIdResponse {

    protected Artista getArtistaByIdResult;

    /**
     * Gets the value of the getArtistaByIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link Artista }
     *     
     */
    public Artista getGetArtistaByIdResult() {
        return getArtistaByIdResult;
    }

    /**
     * Sets the value of the getArtistaByIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Artista }
     *     
     */
    public void setGetArtistaByIdResult(Artista value) {
        this.getArtistaByIdResult = value;
    }

}
