/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.dao;

import com.musicservice.entities.Artista;
import com.musicservice.entities.Perfil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Kaver
 */
public class PerfilDAO extends BaseDAO {
    
    public static final String USUARIO = "Usuario";
    
    public Perfil findPerfilUsuario(){
        Perfil perfil = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Perfil.findByNombrePerfil");
            query.setParameter("nombrePerfil", USUARIO);
            perfil = (Perfil)query.getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return perfil;
    }
    
}
