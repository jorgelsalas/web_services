
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
 *         &lt;element name="getCorreosResult" type="{http://musicservicebl.somee.com}ArrayOfCorreo" minOccurs="0"/>
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
    "getCorreosResult"
})
@XmlRootElement(name = "getCorreosResponse")
public class GetCorreosResponse {

    protected ArrayOfCorreo getCorreosResult;

    /**
     * Gets the value of the getCorreosResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCorreo }
     *     
     */
    public ArrayOfCorreo getGetCorreosResult() {
        return getCorreosResult;
    }

    /**
     * Sets the value of the getCorreosResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCorreo }
     *     
     */
    public void setGetCorreosResult(ArrayOfCorreo value) {
        this.getCorreosResult = value;
    }

}
