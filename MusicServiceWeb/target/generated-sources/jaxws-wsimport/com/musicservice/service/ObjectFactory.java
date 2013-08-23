
package com.musicservice.service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.musicservice.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.musicservice.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Artista }
     * 
     */
    public Artista createArtista() {
        return new Artista();
    }

    /**
     * Create an instance of {@link Album }
     * 
     */
    public Album createAlbum() {
        return new Album();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link Cancion }
     * 
     */
    public Cancion createCancion() {
        return new Cancion();
    }

    /**
     * Create an instance of {@link Perfil }
     * 
     */
    public Perfil createPerfil() {
        return new Perfil();
    }

}
