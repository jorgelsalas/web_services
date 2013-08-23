
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
 *         &lt;element name="getTopArtistasResult" type="{http://musicservicebl.somee.com}ArrayOfArtista" minOccurs="0"/>
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
    "getTopArtistasResult"
})
@XmlRootElement(name = "getTopArtistasResponse")
public class GetTopArtistasResponse {

    protected ArrayOfArtista getTopArtistasResult;

    /**
     * Gets the value of the getTopArtistasResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArtista }
     *     
     */
    public ArrayOfArtista getGetTopArtistasResult() {
        return getTopArtistasResult;
    }

    /**
     * Sets the value of the getTopArtistasResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArtista }
     *     
     */
    public void setGetTopArtistasResult(ArrayOfArtista value) {
        this.getTopArtistasResult = value;
    }

}
