/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.dao;

import com.musicservice.entities.Artista;
import java.util.List;

/**
 *
 * @author Kaver
 */
public class FavoritosDAO {
    
    public boolean addFavorito(int idUsuario, int idArtista){
        boolean error = true;
        try{
        
        }
        catch(Exception e){
            error = true;
            e.printStackTrace();
        }
        return error;
    }
    
    public boolean deleteFavorito(int idUsuario, int idArtista){
        boolean error = true;
        try{
        
        }
        catch(Exception e){
            error = true;
            e.printStackTrace();
        }
        return error;
    }
    
    public List<Artista> findFavoritos(int idUsuario){
        List<Artista> favoritos = null;
        try{
        
        }
        catch(Exception e){
            favoritos = null;
            e.printStackTrace();
        }
        return favoritos;
    }
    
}
