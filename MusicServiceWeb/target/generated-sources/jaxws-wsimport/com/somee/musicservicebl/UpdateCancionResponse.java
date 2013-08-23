
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
 *         &lt;element name="updateCancionResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "updateCancionResult"
})
@XmlRootElement(name = "updateCancionResponse")
public class UpdateCancionResponse {

    protected boolean updateCancionResult;

    /**
     * Gets the value of the updateCancionResult property.
     * 
     */
    public boolean isUpdateCancionResult() {
        return updateCancionResult;
    }

    /**
     * Sets the value of the updateCancionResult property.
     * 
     */
    public void setUpdateCancionResult(boolean value) {
        this.updateCancionResult = value;
    }

}
