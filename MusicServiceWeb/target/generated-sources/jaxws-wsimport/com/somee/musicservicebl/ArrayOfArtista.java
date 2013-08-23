
package com.somee.musicservicebl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.musicservice.service.Artista;


/**
 * <p>Java class for ArrayOfArtista complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfArtista">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="artista" type="{http://service.musicservice.com/}artista" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfArtista", propOrder = {
    "artista"
})
public class ArrayOfArtista {

    @XmlElement(nillable = true)
    protected List<Artista> artista;

    /**
     * Gets the value of the artista property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artista property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtista().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Artista }
     * 
     * 
     */
    public List<Artista> getArtista() {
        if (artista == null) {
            artista = new ArrayList<Artista>();
        }
        return this.artista;
    }

}
