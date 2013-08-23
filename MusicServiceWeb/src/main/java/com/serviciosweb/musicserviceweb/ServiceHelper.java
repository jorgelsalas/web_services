/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosweb.musicserviceweb;

import com.musicservice.service.Album;
import com.musicservice.service.Artista;
import com.musicservice.service.Cancion;
import com.musicservice.service.Usuario;
import com.somee.musicservicebl.ArrayOfArtista;
import com.somee.musicservicebl.BLWebService;
import com.somee.musicservicebl.BLWebServiceSoap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kaver
 */
public class ServiceHelper {
    
    private BLWebService service;
    private BLWebServiceSoap port;
    
    public ServiceHelper(){
        try{
            this.service = new BLWebService();
            this.port = this.service.getBLWebServiceSoap();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public int getCantidadDePaginasDeArtistas(){
        int cantidad = 0;
        try{
            cantidad = this.port.getCantidadDePaginasParaMostrarArtistas();
        }
        catch(Exception e){
            cantidad = 0;
        }
        return cantidad;
    }
    
    public Artista getArtistaById(int idArtista){
        Artista artista = null;
        try{
            artista = this.port.getArtistaById(idArtista);
        }
        catch(Exception e){
            artista = null;
            e.printStackTrace();
        }
        return artista;
    }
    
    public Album getAlbumById(int idAlbum){
        Album album = null;
        try{
            album = this.port.getAlbumById(idAlbum);
        }
        catch(Exception e){
            album = null;
            e.printStackTrace();
        }
        return album;
    }
    
    public List<Artista> getArtistas(int numPagina){
        List<Artista> artistas = null;
        try{
            artistas = this.port.getArtistasDePagina(numPagina-1).getArtista();
        }
        catch(Exception e){
            artistas = null;
            e.printStackTrace();
        }
        return artistas;
    }
        
    public List<Album> getAlbumsDeArtista(int idArtista){
        List<Album> albums = null;
        try{
            Artista artista = this.getArtistaById(idArtista);
            if(artista != null){
                albums = this.port.getAlbumsDeArtista(artista).getAlbum();
            }
        }
        catch(Exception e){
            albums = null;
            e.printStackTrace();
        }
        return albums;
    }
    
    public List<Cancion> getCancionesDeAlbum(int idAlbum){
        List<Cancion> canciones = null;
        try{
            Album album = this.getAlbumById(idAlbum);
            if(album != null){
                canciones = this.port.getCancionesDeAlbum(album).getCancion();
            }
        }
        catch(Exception e){
            canciones = null;
            e.printStackTrace();
        }
        return canciones;
    }
    
    public Usuario getUsuarioByUsername(String username){
        Usuario usuario = null;
        try{
            usuario = port.getUsuarioByUsername(username);
        }
        catch(Exception e){
            usuario = null;
            e.printStackTrace();
        }
        return usuario;
    }
    
    public boolean addFavorito(String username, int idArtista){
        Usuario usuario = this.getUsuarioByUsername(username);
        boolean error = true;
        try{
            Artista artista = this.getArtistaById(idArtista);
            error = port.addArtistaFavoritoAUsuario(artista, usuario);
        }
        catch(Exception e){
            e.printStackTrace();
            error = true;
        }
        return error;
    }
    
    public boolean deleteFavorito(String username, int idArtista){
        Usuario usuario = this.getUsuarioByUsername(username);
        boolean error = true;
        try{
            Artista artista = this.getArtistaById(idArtista);
            error = port.deleteArtistaFavoritoAUsuario(artista, usuario);
        }
        catch(Exception e){
            e.printStackTrace();
            error = true;
        }
        return error;
    }
    
    public boolean esFavorito(String username, Artista artista){
        Usuario usuario = this.getUsuarioByUsername(username);
        boolean esFavorito = false;
        try{
            List<Artista> favoritosDeUsuario = this.port.getFavoritosDeUsuario(usuario).getArtista();
            esFavorito = favoritosDeUsuario.contains(artista);
        }
        catch(Exception e){
            esFavorito = false;
            e.printStackTrace();
        }
        return esFavorito;
    }
    
    public List<Artista> favoritosDeUsuario(Usuario usuario){
        List<Artista> favoritosDeUsuario = null;
         try{
            ArrayOfArtista artistaArray = this.port.getFavoritosDeUsuario(usuario);
            if(artistaArray != null){
                favoritosDeUsuario = artistaArray.getArtista();
            }
        }
        catch(Exception e){
            favoritosDeUsuario = null;
            e.printStackTrace();
        }
         if(favoritosDeUsuario == null){
             favoritosDeUsuario = new LinkedList<Artista>();
         }
        return favoritosDeUsuario;
    }
}
