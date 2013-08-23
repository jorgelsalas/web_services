
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
 *         &lt;element name="deleteAlbumResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteAlbumResult"
})
@XmlRootElement(name = "deleteAlbumResponse")
public class DeleteAlbumResponse {

    protected boolean deleteAlbumResult;

    /**
     * Gets the value of the deleteAlbumResult property.
     * 
     */
    public boolean isDeleteAlbumResult() {
        return deleteAlbumResult;
    }

    /**
     * Sets the value of the deleteAlbumResult property.
     * 
     */
    public void setDeleteAlbumResult(boolean value) {
        this.deleteAlbumResult = value;
    }

}
