/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.dao;

import com.musicservice.entities.Album;
import com.musicservice.entities.Cancion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Carlos Solis
 */
public class CancionDAO extends BaseDAO {
    public List<Cancion> findAll(){
        return findRange(0, findCantidadCanciones());
    }
    
    public List<Cancion> findRange(int indiceDePrimerArtista, int cantidad){
        List<Cancion> canciones = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Cancion.findAll")
                    .setFirstResult(indiceDePrimerArtista)
                    .setMaxResults(cantidad);
            canciones = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return canciones;    
    }
    
    public int findCantidadCanciones(){
        int cantidad = 0;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Cancion.findCantidadCanciones");
            Number cantidadNumber = (Number)query.getSingleResult();
            cantidad = cantidadNumber.intValue();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cantidad;
    }
    public boolean storeCancion (Cancion cancion){
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(cancion);
            entityManager.flush();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            error = true;
            e.printStackTrace();
        }
        return error;
    }
    
    public boolean updateCancion(Cancion cancion){
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(cancion);
            entityManager.flush();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            error = true;
            e.printStackTrace();
        }
        return error;
    }
    
    public boolean deleteCancion(Cancion cancion){
        Cancion c = null;
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            
            int idCancion = cancion.getIdCancion();
            Query query = entityManager.createNamedQuery("Cancion.findByIdCancion");
            query.setParameter("idCancion", idCancion);
            c = (Cancion) query.getSingleResult();
            
            entityManager.getTransaction().commit();
            
            entityManager.getTransaction().begin();
            
            entityManager.remove(c);
            entityManager.flush();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            error = true;
            e.printStackTrace();
        }
        return error;
    }
    
    public Cancion getCancionById(int id){
        List<Cancion> listCanciones = null;
        Cancion cancion = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Cancion.findByIdCancion");
            query.setParameter("idCancion", id);
            listCanciones = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            if(listCanciones != null && listCanciones.size() > 0){
                cancion = listCanciones.get(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cancion;
    }
    
    public List<Cancion> getCancionesByNombre (String nombre){
        List<Cancion> listCanciones = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Cancion.findByNombreCancion");
            query.setParameter("nombreCancion", nombre);
            listCanciones = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return listCanciones;
    }
    public List<Cancion> getCancionesByAlbum(Album album){
        List<Cancion> canciones = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Cancion.findByIdAlbum");
            query.setParameter("idAlbum", album);
            canciones = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return canciones;
    }
}
