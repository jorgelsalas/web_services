
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
 *         &lt;element name="pAlbum" type="{http://service.musicservice.com/}album" minOccurs="0"/>
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
    "pAlbum"
})
@XmlRootElement(name = "addAlbum")
public class AddAlbum {

    protected Album pAlbum;

    /**
     * Gets the value of the pAlbum property.
     * 
     * @return
     *     possible object is
     *     {@link Album }
     *     
     */
    public Album getPAlbum() {
        return pAlbum;
    }

    /**
     * Sets the value of the pAlbum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Album }
     *     
     */
    public void setPAlbum(Album value) {
        this.pAlbum = value;
    }

}
