
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
 *         &lt;element name="getCancionesDePaginaResult" type="{http://musicservicebl.somee.com}ArrayOfCancion" minOccurs="0"/>
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
    "getCancionesDePaginaResult"
})
@XmlRootElement(name = "getCancionesDePaginaResponse")
public class GetCancionesDePaginaResponse {

    protected ArrayOfCancion getCancionesDePaginaResult;

    /**
     * Gets the value of the getCancionesDePaginaResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCancion }
     *     
     */
    public ArrayOfCancion getGetCancionesDePaginaResult() {
        return getCancionesDePaginaResult;
    }

    /**
     * Sets the value of the getCancionesDePaginaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCancion }
     *     
     */
    public void setGetCancionesDePaginaResult(ArrayOfCancion value) {
        this.getCancionesDePaginaResult = value;
    }

}
