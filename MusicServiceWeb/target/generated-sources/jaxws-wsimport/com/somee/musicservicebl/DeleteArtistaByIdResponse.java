
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
 *         &lt;element name="deleteArtistaByIdResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "deleteArtistaByIdResult"
})
@XmlRootElement(name = "deleteArtistaByIdResponse")
public class DeleteArtistaByIdResponse {

    protected boolean deleteArtistaByIdResult;

    /**
     * Gets the value of the deleteArtistaByIdResult property.
     * 
     */
    public boolean isDeleteArtistaByIdResult() {
        return deleteArtistaByIdResult;
    }

    /**
     * Sets the value of the deleteArtistaByIdResult property.
     * 
     */
    public void setDeleteArtistaByIdResult(boolean value) {
        this.deleteArtistaByIdResult = value;
    }

}
