
package com.somee.musicservicebl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.musicservice.service.Album;


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
 *         &lt;element name="getAlbumByIdResult" type="{http://service.musicservice.com/}album" minOccurs="0"/>
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
    "getAlbumByIdResult"
})
@XmlRootElement(name = "getAlbumByIdResponse")
public class GetAlbumByIdResponse {

    protected Album getAlbumByIdResult;

    /**
     * Gets the value of the getAlbumByIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link Album }
     *     
     */
    public Album getGetAlbumByIdResult() {
        return getAlbumByIdResult;
    }

    /**
     * Sets the value of the getAlbumByIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Album }
     *     
     */
    public void setGetAlbumByIdResult(Album value) {
        this.getAlbumByIdResult = value;
    }

}
