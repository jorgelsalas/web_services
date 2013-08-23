
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
 *         &lt;element name="getAlbumsDeArtistaResult" type="{http://musicservicebl.somee.com}ArrayOfAlbum" minOccurs="0"/>
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
    "getAlbumsDeArtistaResult"
})
@XmlRootElement(name = "getAlbumsDeArtistaResponse")
public class GetAlbumsDeArtistaResponse {

    protected ArrayOfAlbum getAlbumsDeArtistaResult;

    /**
     * Gets the value of the getAlbumsDeArtistaResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAlbum }
     *     
     */
    public ArrayOfAlbum getGetAlbumsDeArtistaResult() {
        return getAlbumsDeArtistaResult;
    }

    /**
     * Sets the value of the getAlbumsDeArtistaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAlbum }
     *     
     */
    public void setGetAlbumsDeArtistaResult(ArrayOfAlbum value) {
        this.getAlbumsDeArtistaResult = value;
    }

}
