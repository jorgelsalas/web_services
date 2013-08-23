
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
 *         &lt;element name="getCancionesDeAlbumResult" type="{http://musicservicebl.somee.com}ArrayOfCancion" minOccurs="0"/>
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
    "getCancionesDeAlbumResult"
})
@XmlRootElement(name = "getCancionesDeAlbumResponse")
public class GetCancionesDeAlbumResponse {

    protected ArrayOfCancion getCancionesDeAlbumResult;

    /**
     * Gets the value of the getCancionesDeAlbumResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCancion }
     *     
     */
    public ArrayOfCancion getGetCancionesDeAlbumResult() {
        return getCancionesDeAlbumResult;
    }

    /**
     * Sets the value of the getCancionesDeAlbumResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCancion }
     *     
     */
    public void setGetCancionesDeAlbumResult(ArrayOfCancion value) {
        this.getCancionesDeAlbumResult = value;
    }

}
