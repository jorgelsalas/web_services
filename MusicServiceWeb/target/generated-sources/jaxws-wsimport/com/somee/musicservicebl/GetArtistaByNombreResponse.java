
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
 *         &lt;element name="getArtistaByNombreResult" type="{http://service.musicservice.com/}artista" minOccurs="0"/>
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
    "getArtistaByNombreResult"
})
@XmlRootElement(name = "getArtistaByNombreResponse")
public class GetArtistaByNombreResponse {

    protected Artista getArtistaByNombreResult;

    /**
     * Gets the value of the getArtistaByNombreResult property.
     * 
     * @return
     *     possible object is
     *     {@link Artista }
     *     
     */
    public Artista getGetArtistaByNombreResult() {
        return getArtistaByNombreResult;
    }

    /**
     * Sets the value of the getArtistaByNombreResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Artista }
     *     
     */
    public void setGetArtistaByNombreResult(Artista value) {
        this.getArtistaByNombreResult = value;
    }

}
