/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.dao;

import com.musicservice.entities.Artista;
import com.musicservice.entities.Usuario;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Kaver
 */
public class ArtistaDAO extends BaseDAO {
    
    public List<Artista> findAll(){
        return findRange(0, findCantidadArtistas());
    }
    
    public List<Artista> findRange(int indiceDePrimerArtista, int cantidad){
        List<Artista> artistas = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Artista.findAll")
                    .setFirstResult(indiceDePrimerArtista)
                    .setMaxResults(cantidad);
            artistas = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return artistas;    
    }
    
    public int findCantidadArtistas(){
        int cantidad = 0;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Artista.findCantidadArtistas");
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
    
    public boolean storeArtista(Artista artista){
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(artista);
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
    
    public boolean updateArtista(Artista artista){
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(artista);
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
    
    public boolean deleteArtista(Artista artista){
        Artista a = null;
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            
            int idArtista = artista.getIdArtista();
            Query query = entityManager.createNamedQuery("Artista.findByIdArtista");
            query.setParameter("idArtista", idArtista);
            a = (Artista) query.getSingleResult();
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
        
    public Artista getArtistaById(int id){
        List<Artista> listArtistas = null;
        Artista artista = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Artista.findByIdArtista");
            query.setParameter("idArtista", id);
            listArtistas = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            if(listArtistas != null && listArtistas.size() > 0){
                artista = listArtistas.get(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return artista;
    }
    
    public Artista getArtistaByNombre(String nombre){
        List<Artista> listArtistas = null;
        Artista artista = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Artista.findByNombreArtista");
            query.setParameter("nombreArtista", nombre);
            listArtistas = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            if(listArtistas != null && listArtistas.size() > 0){
                artista = listArtistas.get(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return artista;
    }
    
    
    //favoritos
    
        
    public boolean addArtistaFavorito(Usuario usuario, Artista artista){
        boolean error = false;
        try{            
            if(artista != null){
                
                EntityManager entityManager = this.getEntityManager();
                entityManager.getTransaction().begin();
               
                Query query = entityManager.createNamedQuery("Artista.findByIdArtista");
                query.setParameter("idArtista", artista.getIdArtista());
                Artista artistaBD = (Artista)query.getSingleResult();
                entityManager.getTransaction().commit();
                
                Query queryUsuario = entityManager.createNamedQuery("Usuario.findByIdUsuario");
                entityManager.getTransaction().begin();
                queryUsuario.setParameter("idUsuario", usuario.getIdUsuario());
                Usuario usuarioBD = (Usuario)queryUsuario.getSingleResult();
                entityManager.getTransaction().commit();

                if(!artistaBD.getUsuarioCollection().contains(usuarioBD)){
                    artistaBD.getUsuarioCollection().add(usuarioBD); 
                }
                if(!usuarioBD.getArtistaCollection().contains(artistaBD)){
                    usuarioBD.getArtistaCollection().add(artistaBD);
                }
                
                entityManager.getTransaction().begin();
                entityManager.merge(artistaBD);
                entityManager.flush();
                entityManager.getTransaction().commit();
                
                entityManager.getTransaction().begin();
                entityManager.merge(usuarioBD);
                entityManager.flush();
                entityManager.getTransaction().commit();
                
                entityManager.close();       
            }
            else{
                error = true;
            }
        
        }
        catch(Exception e){
            e.printStackTrace();
            error = true;
        }
        return error;
    }
    
    public boolean deleteArtistaFavorito(Usuario usuario, Artista artista){
        boolean error = false;
        try{            
            if(artista != null){
                EntityManager entityManager = this.getEntityManager();
                entityManager.getTransaction().begin();
               
                Query query = entityManager.createNamedQuery("Artista.findByIdArtista");
                query.setParameter("idArtista", artista.getIdArtista());
                Artista artistaBD = (Artista)query.getSingleResult();
                entityManager.getTransaction().commit();
                
                entityManager.getTransaction().begin();
                Query queryUsuario = entityManager.createNamedQuery("Usuario.findByIdUsuario");
                queryUsuario.setParameter("idUsuario", usuario.getIdUsuario());
                Usuario usuarioBD = (Usuario)queryUsuario.getSingleResult();
                entityManager.getTransaction().commit();

                if(artistaBD.getUsuarioCollection().contains(usuarioBD)){
                    artistaBD.getUsuarioCollection().remove(usuarioBD); 
                }
                if(usuarioBD.getArtistaCollection().contains(artistaBD)){
                    usuarioBD.getArtistaCollection().remove(artistaBD);
                }
                
                entityManager.getTransaction().begin();
                entityManager.merge(artistaBD);
                entityManager.flush();
                entityManager.getTransaction().commit();
                
                entityManager.getTransaction().begin();
                entityManager.merge(usuarioBD);
                entityManager.flush();
                entityManager.getTransaction().commit();
                
                entityManager.close();          
            }
            else{
                error = true;
            }
        
        }
        catch(Exception e){
            e.printStackTrace();
            error = true;
        }
        return error;
    }

   
}
