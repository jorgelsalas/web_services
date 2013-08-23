
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
 *         &lt;element name="addCancionResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "addCancionResult"
})
@XmlRootElement(name = "addCancionResponse")
public class AddCancionResponse {

    protected boolean addCancionResult;

    /**
     * Gets the value of the addCancionResult property.
     * 
     */
    public boolean isAddCancionResult() {
        return addCancionResult;
    }

    /**
     * Sets the value of the addCancionResult property.
     * 
     */
    public void setAddCancionResult(boolean value) {
        this.addCancionResult = value;
    }

}
