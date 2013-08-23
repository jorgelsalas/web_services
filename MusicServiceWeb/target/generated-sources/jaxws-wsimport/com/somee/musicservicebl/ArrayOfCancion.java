
package com.somee.musicservicebl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.musicservice.service.Cancion;


/**
 * <p>Java class for ArrayOfCancion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCancion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancion" type="{http://service.musicservice.com/}cancion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCancion", propOrder = {
    "cancion"
})
public class ArrayOfCancion {

    @XmlElement(nillable = true)
    protected List<Cancion> cancion;

    /**
     * Gets the value of the cancion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cancion }
     * 
     * 
     */
    public List<Cancion> getCancion() {
        if (cancion == null) {
            cancion = new ArrayList<Cancion>();
        }
        return this.cancion;
    }

}
