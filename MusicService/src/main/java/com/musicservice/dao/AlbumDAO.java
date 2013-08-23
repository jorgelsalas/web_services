/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.dao;

import com.musicservice.entities.Album;
import com.musicservice.entities.Artista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Kaver
 */
public class AlbumDAO extends BaseDAO {
    public List<Album> findAll(){
        return findRange(0, findCantidadAlbums());
    }
    
    public List<Album> findRange(int indiceDePrimerAlbum, int cantidad){
        List<Album> albums = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Album.findAll")
                    .setFirstResult(indiceDePrimerAlbum)
                    .setMaxResults(cantidad);
            albums = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return albums;    
    }
    
    public int findCantidadAlbums(){
        int cantidad = 0;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Album.findCantidadAlbums");
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
    public boolean storeAlbum(Album album){
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(album);
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
    
    public boolean updateAlbum(Album album){
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(album);
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
    
    public boolean deleteAlbum(Album album){
        Album a = null;
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            //TODO: Document why is this needed
            int idAlbum = album.getIdAlbum();
            Query query = entityManager.createNamedQuery("Album.findByIdAlbum");
            query.setParameter("idAlbum", idAlbum);
            a = (Album) query.getSingleResult();
            
            entityManager.getTransaction().commit();
            
            entityManager.getTransaction().begin();
            entityManager.remove(a);
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
    
    public Album getAlbumById(int id){
        List<Album> listAlbums = null;
        Album album = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Album.findByIdAlbum");
            query.setParameter("idAlbum", id);
            listAlbums = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            if(listAlbums != null && listAlbums.size() > 0){
                album = listAlbums.get(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return album;
    }
    
    public List<Album> getAlbumsByArtista(Artista artista){
        List<Album> albums = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Album.findByIdArtista");
            query.setParameter("idArtista", artista);
            albums = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return albums;
    }
    
    public List<Album> getAlbumsByNombre(String nombre){
        List<Album> listAlbums = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Album.findByNombreAlbum");
            query.setParameter("nombreAlbum", nombre);
            listAlbums = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return listAlbums;
    }
}
