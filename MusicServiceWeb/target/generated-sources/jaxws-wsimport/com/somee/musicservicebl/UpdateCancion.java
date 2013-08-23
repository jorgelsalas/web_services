
package com.somee.musicservicebl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.musicservice.service.Cancion;


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
 *         &lt;element name="pCancion" type="{http://service.musicservice.com/}cancion" minOccurs="0"/>
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
    "pCancion"
})
@XmlRootElement(name = "updateCancion")
public class UpdateCancion {

    protected Cancion pCancion;

    /**
     * Gets the value of the pCancion property.
     * 
     * @return
     *     possible object is
     *     {@link Cancion }
     *     
     */
    public Cancion getPCancion() {
        return pCancion;
    }

    /**
     * Sets the value of the pCancion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cancion }
     *     
     */
    public void setPCancion(Cancion value) {
        this.pCancion = value;
    }

}
