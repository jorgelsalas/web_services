
package com.somee.musicservicebl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.musicservice.service.Artista;
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
 *         &lt;element name="pArtista" type="{http://service.musicservice.com/}artista" minOccurs="0"/>
 *         &lt;element name="pUsuario" type="{http://service.musicservice.com/}usuario" minOccurs="0"/>
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
    "pArtista",
    "pUsuario"
})
@XmlRootElement(name = "addArtistaFavoritoAUsuario")
public class AddArtistaFavoritoAUsuario {

    protected Artista pArtista;
    protected Usuario pUsuario;

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

    /**
     * Gets the value of the pUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getPUsuario() {
        return pUsuario;
    }

    /**
     * Sets the value of the pUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setPUsuario(Usuario value) {
        this.pUsuario = value;
    }

}
