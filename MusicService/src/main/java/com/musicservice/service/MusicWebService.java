/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.service;

import com.musicservice.dao.AlbumDAO;
import com.musicservice.dao.ArtistaDAO;
import com.musicservice.dao.CancionDAO;
import com.musicservice.dao.UsuarioDAO;
import com.musicservice.entities.Album;
import com.musicservice.entities.Artista;
import com.musicservice.entities.Cancion;
import com.musicservice.entities.Usuario;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Kaver
 */
@WebService(serviceName = "MusicWebService")
public class MusicWebService {
    
    private ArtistaDAO artistaDAO;
    private AlbumDAO albumDAO; 
    private CancionDAO cancionDAO; 
    private UsuarioDAO usuarioDAO; 

    public MusicWebService(){
        try{
            this.artistaDAO = new ArtistaDAO();
            this.albumDAO = new AlbumDAO();
            this.cancionDAO = new CancionDAO();
            this.usuarioDAO = new UsuarioDAO();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @WebMethod(operationName = "findAllArtistas")
    public List<Artista> findAllArtistas(){
        return artistaDAO.findAll();
    }
    
    @WebMethod(operationName = "findRangeArtistas")
    public List<Artista> findRangeArtistas(int indicePrimerArtista, int cantidad){
        return artistaDAO.findRange(indicePrimerArtista, cantidad);
    }
    
    @WebMethod(operationName = "findCantidadArtistas")
    public int findCantidadArtistas(){
        return artistaDAO.findCantidadArtistas();
    }
    
    @WebMethod(operationName = "findArtistaById")
    public Artista findArtistaById(int id){
        return artistaDAO.getArtistaById(id);
    }
    
    @WebMethod(operationName = "findArtistaByNombre")
    public Artista findArtistaByNombre(String nombre){
        return artistaDAO.getArtistaByNombre(nombre);
    }
    
    @WebMethod(operationName = "updateArtista")
    public boolean updateArtista(Artista artista){
        return artistaDAO.updateArtista(artista);
    }
    
    @WebMethod(operationName = "addArtista")
    public boolean addArtista(Artista artista){
        return artistaDAO.storeArtista(artista);
    }    
    
    @WebMethod(operationName = "deleteArtista")
    public boolean deleteArtista(Artista artista){
        return artistaDAO.deleteArtista(artista);
    }
    
    @WebMethod(operationName = "findAllAlbums")
    public List<Album> findAllAlbums(){
        return albumDAO.findAll();
    }
    
    @WebMethod(operationName = "findRangeAlbums")
    public List<Album> findRangeAlbums(int indicePrimerAlbum, int cantidad){
        return albumDAO.findRange(indicePrimerAlbum, cantidad);
    }
    
   @WebMethod(operationName = "findCantidadAlbums")
    public int findCantidadAlbums(){
        return albumDAO.findCantidadAlbums();
    }
    
    //find all albums by id artista
    @WebMethod(operationName = "findAlbumsByIdArtista")
    public List<Album> findAlbumsByIdArtista(int id){
        Artista artista = artistaDAO.getArtistaById(id);
        return albumDAO.getAlbumsByArtista(artista);
    }

    //find album by id
    @WebMethod(operationName = "findAlbumById")
    public Album findAlbumById(int id){
        return albumDAO.getAlbumById(id);
    }
    
    //find album by nombre
    @WebMethod(operationName = "findAlbumByNombre")
    public List<Album> findAlbumsByNombre(String nombre){
        return albumDAO.getAlbumsByNombre(nombre);
    }
    
    //update album
    @WebMethod(operationName = "updateAlbum")
    public boolean updateAlbum(Album album){
        return albumDAO.updateAlbum(album);
    }
            
    //add album
    @WebMethod(operationName = "addAlbum")
    public boolean addAlbum(Album album){
        return albumDAO.storeAlbum(album);
    }
    
    //update album
    @WebMethod(operationName = "deleteAlbum")
    public boolean deleteAlbum(Album album){
        return albumDAO.deleteAlbum(album);
    }
    
    
    //CANCIONES
    
    @WebMethod(operationName = "findAllCanciones")
    public List<Cancion> findAllCanciones(){
        return cancionDAO.findAll();
    }
    
    @WebMethod(operationName = "findRangeCanciones")
    public List<Cancion> findRangeCanciones(int indicePrimerCancion, int cantidad){
        return cancionDAO.findRange(indicePrimerCancion, cantidad);
    }

   @WebMethod(operationName = "findCantidadCanciones")
    public int findCantidadCanciones(){
        return cancionDAO.findCantidadCanciones();
    }
    
   @WebMethod(operationName = "findCancionById")
    public Cancion findCancionById(int id){
        return cancionDAO.getCancionById(id);
    }
   
    @WebMethod(operationName = "findCancionesByNombre")
    public List<Cancion> findCancionesByNombre(String nombre){
        return cancionDAO.getCancionesByNombre(nombre);
    }
    
    @WebMethod(operationName = "updateCancion")
    public boolean updateCancion(Cancion cancion){
        return cancionDAO.updateCancion(cancion);
    }
    
    @WebMethod(operationName = "deleteCancion")
    public boolean deleteCancion(Cancion cancion){
        return cancionDAO.deleteCancion(cancion);
    }
    
    @WebMethod(operationName = "addCancion")
    public boolean addCancion(Cancion cancion){
       return cancionDAO.storeCancion(cancion);
    }       
    
    @WebMethod(operationName = "findCancionesByAlbumId")
    public List<Cancion> findCancionesByAlbumId(int id){
        Album album = albumDAO.getAlbumById(id);
        return cancionDAO.getCancionesByAlbum(album);
    }
     
    //USUARIO
   
    //get usuario by id
    @WebMethod(operationName = "findUsuarioById")
    public Usuario findUsuarioById(int id){
        return usuarioDAO.getUsuarioByIdUsuario(id);
    }
    
    //get usuario by username
    @WebMethod(operationName = "findUsuarioByUsername")
    public Usuario findUsuarioByUsername(String nombre){
        return usuarioDAO.getUsuarioByUsername(nombre);
    }
    
    //update usuario
    @WebMethod(operationName = "updateUsuario")
    public boolean updateUsuario(Usuario usuario){
        return usuarioDAO.updateUsuario(usuario);
    }
    
    //add usuario
    @WebMethod(operationName = "addUsuario")
    public boolean addUsuario(Usuario usuario){
        return usuarioDAO.storeUsuario(usuario);
    }
    
    //delete usuasrio
    @WebMethod(operationName = "deleteUsuario")
    public boolean deleteUsuario(Usuario usuario){
        return usuarioDAO.deleteUsuario(usuario);
    }
    
    //add artista favorito a usuario
    @WebMethod(operationName = "addArtistaFavorito")
    public boolean addArtistaFavorito(Usuario usuario, Artista artista){
        return artistaDAO.addArtistaFavorito(usuario, artista);
    }
    
    //delete artista favorito a usuario
    @WebMethod(operationName = "deleteArtistaFavorito")
    public boolean deleteArtistaFavorito(Usuario usuario, Artista artista){
        return artistaDAO.deleteArtistaFavorito(usuario, artista);
    }
    
    @WebMethod(operationName = "findFavoritos")
    public List<Artista> findFavoritos (Usuario usuario){
        return usuarioDAO.getFavoritos(usuario);
    }
    
    //bool matches
    @WebMethod(operationName = "matches")
    public boolean matches(String username, String password){
        return usuarioDAO.matches(username, password);
    }
    
}
