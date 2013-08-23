
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
 *         &lt;element name="getAlbumsDePaginaResult" type="{http://musicservicebl.somee.com}ArrayOfAlbum" minOccurs="0"/>
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
    "getAlbumsDePaginaResult"
})
@XmlRootElement(name = "getAlbumsDePaginaResponse")
public class GetAlbumsDePaginaResponse {

    protected ArrayOfAlbum getAlbumsDePaginaResult;

    /**
     * Gets the value of the getAlbumsDePaginaResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAlbum }
     *     
     */
    public ArrayOfAlbum getGetAlbumsDePaginaResult() {
        return getAlbumsDePaginaResult;
    }

    /**
     * Sets the value of the getAlbumsDePaginaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAlbum }
     *     
     */
    public void setGetAlbumsDePaginaResult(ArrayOfAlbum value) {
        this.getAlbumsDePaginaResult = value;
    }

}
