/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.dao;

import com.musicservice.entities.Artista;
import com.musicservice.entities.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Carlos Solis
 */
public class UsuarioDAO extends BaseDAO {
    
    private PerfilDAO perfilDAO = new PerfilDAO();
    
    public List<Usuario> findAll(){
        List<Usuario> usuarios = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Usuario.findAll");
            usuarios = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return usuarios;
    }
    public boolean storeUsuario(Usuario usuario){
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            usuario.setIdPerfil(perfilDAO.findPerfilUsuario()); //evitar que inserten admins
            if(!encryptPasswordForUser(usuario)){
                error = true;
            }
            else{
                entityManager.persist(usuario);
                entityManager.flush();
                entityManager.getTransaction().commit();
                entityManager.close();
            }
        }
        catch(Exception e){
            error = true;
            e.printStackTrace();
        }
        return error;
    }
    
    public boolean updateUsuario(Usuario usuario){
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            usuario.setIdPerfil(perfilDAO.findPerfilUsuario()); //evitar que inserten admins
            if(!encryptPasswordForUser(usuario)){
                error = true;
            }
            else{
                entityManager.merge(usuario);
                entityManager.flush();
                entityManager.getTransaction().commit();
                entityManager.close();
            }
        }
        catch(Exception e){
            error = true;
            e.printStackTrace();
        }
        return error;
    }
    
    public boolean deleteUsuario(Usuario usuario){
        Usuario u = null;
        boolean error = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            //TODO: document why is this needed
            int idUsuario = usuario.getIdUsuario();
            Query query = entityManager.createNamedQuery("Usuario.findByIdUsuario");
            query.setParameter("idUsuario", idUsuario);
            u = (Usuario) query.getSingleResult();
            entityManager.getTransaction().commit();
            
            entityManager.getTransaction().begin();
            entityManager.remove(u);
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
    
    public Usuario getUsuarioByIdUsuario(int idUsuario){
        List<Usuario> listUsuarios = null;
        Usuario usuario = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Usuario.findByIdUsuario");
            query.setParameter("idUsuario", idUsuario);
            listUsuarios = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            if(listUsuarios != null && listUsuarios.size() > 0){
                usuario = listUsuarios.get(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    public Usuario getUsuarioByUsername(String username){
        List<Usuario> listUsuarios = null;
        Usuario usuario = null;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Usuario.findByUsername");
            query.setParameter("username", username);
            listUsuarios = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            if(listUsuarios != null && listUsuarios.size() > 0){
                usuario = listUsuarios.get(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    public boolean matches(String username, String password){
        //Usado para revisar si dado el usuario y la contraseña,
        //es válido dejarlo entrar al sistema.
        //TODO: implementar seguridad
        
        List<Usuario> listUsuarios = null;
        Usuario usuario = null;
        boolean result = false;
        try{
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNamedQuery("Usuario.findByUsername");
            query.setParameter("username", username);
            listUsuarios = query.getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            if(listUsuarios != null && listUsuarios.size() > 0){
                usuario = listUsuarios.get(0);
                if (usuario.getPassword().equals(md5(password))){
                    result = true;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    
    public boolean addArtistaFavorito(Usuario usuario, Artista artista){
        boolean error = false;
        try{
            Usuario usuarioEnBD = this.getUsuarioByIdUsuario(usuario.getIdUsuario());
            usuario.setArtistaCollection(usuarioEnBD.getArtistaCollection());
            
            if(artista != null){
                //cache de entity manager no elimina repetidos
                if(!usuario.getArtistaCollection().contains(artista)){
                    usuario.getArtistaCollection().add(artista); 
                }
                EntityManager entityManager = this.getEntityManager();
                entityManager.getTransaction().begin();
                entityManager.merge(usuario);
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
            Usuario usuarioEnBD = this.getUsuarioByIdUsuario(usuario.getIdUsuario());
            usuario.setArtistaCollection(usuarioEnBD.getArtistaCollection());
            
            if(artista != null){
                usuario.getArtistaCollection().remove(artista);
                EntityManager entityManager = this.getEntityManager();
                entityManager.getTransaction().begin();
                entityManager.merge(usuario);
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
    
    public List<Artista> getFavoritos(Usuario usuario){
        List<Artista> favoritos = new LinkedList<Artista>();
        try{
            Usuario usuarioEnBD = this.getUsuarioByIdUsuario(usuario.getIdUsuario());
            for(Artista artista : usuarioEnBD.getArtistaCollection()){
                //cache de entity manager no elimina repetidos
                if(!favoritos.contains(artista)){
                    favoritos.add(artista);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return favoritos;
    }
    
    
    
    private boolean encryptPasswordForUser(Usuario usuario){
        boolean validEncryption = false;
        String encryptedPassword = md5(usuario.getPassword());
        if(usuario.getPassword() != null && !usuario.getPassword().equals("") 
                && encryptedPassword != null && !encryptedPassword.equals("") ){
            usuario.setPassword(encryptedPassword);
            validEncryption = true;
        }
        return validEncryption;
    }
    
    private String md5(String input) {
         
        String md5 = null;
         
        if(null == input) return null;
         
        try {
             
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(input.getBytes(), 0, input.length());
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }
        return md5;
    }
}
