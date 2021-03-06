
package com.somee.musicservicebl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.musicservice.service.Usuario;


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
 *         &lt;element name="getUsuarioByIdResult" type="{http://service.musicservice.com/}usuario" minOccurs="0"/>
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
    "getUsuarioByIdResult"
})
@XmlRootElement(name = "getUsuarioByIdResponse")
public class GetUsuarioByIdResponse {

    protected Usuario getUsuarioByIdResult;

    /**
     * Gets the value of the getUsuarioByIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getGetUsuarioByIdResult() {
        return getUsuarioByIdResult;
    }

    /**
     * Sets the value of the getUsuarioByIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setGetUsuarioByIdResult(Usuario value) {
        this.getUsuarioByIdResult = value;
    }

}
