
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
 *         &lt;element name="addAlbumResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "addAlbumResult"
})
@XmlRootElement(name = "addAlbumResponse")
public class AddAlbumResponse {

    protected boolean addAlbumResult;

    /**
     * Gets the value of the addAlbumResult property.
     * 
     */
    public boolean isAddAlbumResult() {
        return addAlbumResult;
    }

    /**
     * Sets the value of the addAlbumResult property.
     * 
     */
    public void setAddAlbumResult(boolean value) {
        this.addAlbumResult = value;
    }

}
