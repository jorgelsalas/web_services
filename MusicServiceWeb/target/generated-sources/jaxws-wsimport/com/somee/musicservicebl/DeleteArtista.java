
package com.somee.musicservicebl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.musicservice.service.Artista;


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
 *         &lt;element name="pArtista" type="{http://service.musicservice.com/}artista" minOccurs="0"/>
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
    "pArtista"
})
@XmlRootElement(name = "deleteArtista")
public class DeleteArtista {

    protected Artista pArtista;

    /**
     * Gets the value of the pArtista property.
     * 
     * @return
     *     possible object is
     *     {@link Artista }
     *     
     */
    public Artista getPArtista() {
        return pArtista;
    }

    /**
     * Sets the value of the pArtista property.
     * 
     * @param value
     *     allowed object is
     *     {@link Artista }
     *     
     */
    public void setPArtista(Artista value) {
        this.pArtista = value;
    }

}
