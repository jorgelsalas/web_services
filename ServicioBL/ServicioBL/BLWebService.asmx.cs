using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using ServicioBL.DBServiceReference;
using Newtonsoft.Json;

namespace ServicioBL
{
    /// <summary>
    /// Summary description for BLWebService
    /// </summary>
    /* [WebService(Namespace = "http://musicblwebservice.com")]*/ /*/BLWebService.asmx*/
    [WebService(Namespace = "http://musicservicebl.somee.com")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class BLWebService : System.Web.Services.WebService
    {
        #region private attributes
        
        private MusicWebServiceClient dbService;

        #endregion

        #region const

        private const int CANTIDAD_TOP_ARTISTAS = 10;
        private const int CANTIDAD_ELEMENTOS_POR_PAGINA = 5;

        #endregion

        #region delegates

        private delegate int GetCantidadElementosDelegate();

        #endregion

        #region public methods

        public BLWebService()
        {
            try
            {
                dbService = new MusicWebServiceClient();
            }
            catch (Exception e) { }
        }

        private int GetCantidadPaginas(GetCantidadElementosDelegate cantidadElementosDelegate, int elementosPorPagina)
        {
            int cantidadPaginas = 1;
            try
            {
                cantidadPaginas =
                    (int)Math.Ceiling((double)cantidadElementosDelegate() / (double)elementosPorPagina);
            }
            catch (Exception e) {
                cantidadPaginas = 1;
            }
            return cantidadPaginas;
        }

        [WebMethod]
        public int GetCantidadDePaginasParaMostrarArtistas()
        {
            return this.GetCantidadPaginas(this.dbService.findCantidadArtistas, CANTIDAD_ELEMENTOS_POR_PAGINA);
        }

        [WebMethod]
        public int GetCantidadDePaginasParaMostrarAlbums()
        {
            return this.GetCantidadPaginas(this.dbService.findCantidadAlbums, CANTIDAD_ELEMENTOS_POR_PAGINA);
        }

        [WebMethod]
        public int GetCantidadDePaginasParaMostrarCanciones()
        {
            return this.GetCantidadPaginas(this.dbService.findCantidadCanciones, CANTIDAD_ELEMENTOS_POR_PAGINA);
        }

        //get top 10 artistas
        [WebMethod]
        public List<artista> getTopArtistas() {
            List<artista> topArtistas = null;
            try
            {
                artista [] artistas = this.dbService.findRangeArtistas(0, CANTIDAD_TOP_ARTISTAS);
                if (artistas != null) {
                    topArtistas = new List<artista>(artistas);
                }
            }
            catch(Exception e) {
                topArtistas = null;
            }
            return topArtistas;
        }

        //get all artistas
        [WebMethod]
        public List<artista> getArtistasDePagina(int numeroPagina)
        {
            List<artista> artistas = null;
            try
            {
                artista[] artistasEnBD
                    = this.dbService.findRangeArtistas(
                        numeroPagina * CANTIDAD_ELEMENTOS_POR_PAGINA, 
                        CANTIDAD_ELEMENTOS_POR_PAGINA
                      );
                if (artistasEnBD != null)
                {
                    artistas = new List<artista>(artistasEnBD);
                }

            }
            catch (Exception e)
            {
                artistas = null;
            }
            return artistas;
        }

        //get artista with name
        [WebMethod]
        public artista getArtistaByNombre(string name)
        {
            artista artistaByNombre = null;
            try
            {
                artistaByNombre = this.dbService.findArtistaByNombre(name);
            }
            catch (Exception e) { 
            
            }
            return artistaByNombre;
        }

        //get artista by 
        [WebMethod]
        public artista getArtistaById(int id)
        {
            artista artistaById = null;
            try
            {
                artistaById = this.dbService.findArtistaById(id);
            }
            catch (Exception e) {
                artistaById = null; 
            }
            return artistaById;
        }

        //update artista
        [WebMethod]
        public bool updateArtista(artista pArtista)

        {
            bool error = false;
            try
            {
                error = this.dbService.updateArtista(pArtista);
            }
            catch (Exception e) {
                error = true;
            }

            return error;
        }

        //add artista
        [WebMethod]
        public bool addArtista(artista pArtista)
        {
            bool error = false;
            try
            {
                error = this.dbService.addArtista(pArtista);
            }
            catch (Exception e)
            {
                error = true;
            }

            return error;
        }

        //delete artista
        [WebMethod]
        public bool deleteArtista(artista pArtista)
        {
            bool error = false;
            try
            {
                error = this.dbService.deleteArtista(pArtista);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;

        }

        [WebMethod]
        public List<album> getAlbumsDePagina(int numeroPagina)
        {
            List<album> albums = null;
            try
            {
                album[] albumsEnBD
                    = this.dbService.findRangeAlbums(
                        numeroPagina * CANTIDAD_ELEMENTOS_POR_PAGINA,
                        CANTIDAD_ELEMENTOS_POR_PAGINA
                      );
                if (albumsEnBD != null)
                {
                    albums = new List<album>(albumsEnBD);
                }

            }
            catch (Exception e)
            {
                albums = null;
            }
            return albums;
        }

        //add album a artista
        [WebMethod]
        public bool addAlbum(album pAlbum)
        {
            bool error = false;
            try
            {
                error = this.dbService.addAlbum(pAlbum);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;
        }

        //update album 
        [WebMethod]
        public bool updateAlbum(album pAlbum)
        {
            bool error = false;
            try
            {
                error = this.dbService.updateAlbum(pAlbum);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;
        }

        //delete album
        [WebMethod]
        public bool deleteAlbum(album pAlbum)
        {
            bool error = false;
            try
            {
                error = this.dbService.deleteAlbum(pAlbum);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;
        }

        [WebMethod]
        public album getAlbumById(int pId) {
            album albumById = null;
            try
            {
                albumById = this.dbService.findAlbumById(pId);
            }
            catch (Exception e) {
                albumById = null;
                
            }
            return albumById;
        }

        //find albums de artista
        [WebMethod]
        public List<album> getAlbumsDeArtista(artista pArtista)
        {
            List<album> albumsDeArtista = null; 
            try
            {
                album[] albums = this.dbService.findAlbumsByIdArtista(pArtista.idArtista);
                if (albums != null) {
                    albumsDeArtista = new List<album>(albums);
                }
                
            }
            catch (Exception e)
            {
                albumsDeArtista = null;
            }
            return albumsDeArtista;
        }



        //find albums con nombre
        [WebMethod]
        public List<album> getAlbumsByNombre(string nombre)
        {
            List<album> albumsByNombre = null;
            try
            {
                album[] albums = this.dbService.findAlbumByNombre(nombre);
                if (albums != null)
                {
                    albumsByNombre = new List<album>(albums);
                }

            }
            catch (Exception e)
            {
                albumsByNombre = null;
            }
            return albumsByNombre;
        }

        [WebMethod]
        public List<cancion> getCancionesDePagina(int numeroPagina)
        {
            List<cancion> canciones = null;
            try
            {
                cancion[] cancionesEnBD
                    = this.dbService.findRangeCanciones(
                        numeroPagina * CANTIDAD_ELEMENTOS_POR_PAGINA,
                        CANTIDAD_ELEMENTOS_POR_PAGINA
                      );
                if (cancionesEnBD != null)
                {
                    canciones = new List<cancion>(cancionesEnBD);
                }

            }
            catch (Exception e)
            {
                canciones = null;
            }
            return canciones;
        }

        //find canciones de album
        [WebMethod]
        public List<cancion> getCancionesDeAlbum(album pAlbum)
        {
            List<cancion> canciones = null;

            try
            {
                cancion[] listaCanciones = dbService.findCancionesByAlbumId(pAlbum.idAlbum);
                if (listaCanciones != null) {
                    canciones = new List<cancion>(listaCanciones);
                }
            }
            catch {
                canciones = null;
            }
            return canciones;
        }

        //add cancion a album
        [WebMethod]
        public bool addCancion(cancion pCancion) {
            bool error = false;
            try {
                error = dbService.addCancion(pCancion);
            }
            catch {
                error = true;
            }
            return error;
        }

        //delete cancion
        [WebMethod]
        public bool deleteCancion(cancion pCancion)
        {
            bool error = false;
            try
            {
                error = dbService.deleteCancion(pCancion);
            }
            catch
            {
                error = true;
            }
            return error;     
        }

        //update cancion
        [WebMethod]
        public bool updateCancion(cancion pCancion) {
            bool error = false;
            try
            {
                error = dbService.updateCancion(pCancion);
            }
            catch {
                error = true;
            }

            return error;
        }

        //find canciones con nombre
        [WebMethod]
        public List<cancion> getCancionesConNombre(string nombre) {
            List<cancion> canciones = null;
            try {
                cancion[] listaCanciones = dbService.findCancionesByNombre(nombre);
                if (listaCanciones != null) {
                    canciones = new List<cancion>(listaCanciones);
                }
            }
            catch {
                canciones = null;
            }
            return canciones;
        }

        //Usuario by id
        [WebMethod]
        public usuario getUsuarioById(int id) {
            usuario usuarioById = null;
            try
            {
                usuarioById = dbService.findUsuarioById(id);
            }
            catch (Exception e) {
                usuarioById = null;
            }
            return usuarioById;
        }

        //Usuario by username
        [WebMethod]
        public usuario getUsuarioByUsername(string username)
        {
            usuario usuarioByUsername = null;
            try
            {
                usuarioByUsername = dbService.findUsuarioByUsername(username);
            }
            catch (Exception e)
            {
                usuarioByUsername = null;
            }
            return usuarioByUsername;
        }

        //add usuario

        [WebMethod]
        public bool addUsuario(usuario pUsuario)
        {
            bool error = false;
            try
            {
                error = this.dbService.addUsuario(pUsuario);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;
        }

        //update usuario
        [WebMethod]
        public bool updateUsuario(usuario pUsuario)
        {
            bool error = false;
            try
            {
                error = this.dbService.updateUsuario(pUsuario);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;
        }

        //delete usuario
        [WebMethod]
        public bool deleteUsuario(usuario pUsuario)
        {
            bool error = false;
            try
            {
                error = this.dbService.deleteUsuario(pUsuario);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;
        }

        //is valid username / password
        [WebMethod]
        public bool isValidLogin(string username, string password)
        {
            bool valid = false;
            try
            {
                valid = this.dbService.matches(username, password);
            }
            catch (Exception e) {
                valid = false;
            }
            //NOT IMPLEMENTED YET.
            return valid;
        }

        [WebMethod]
        public List<artista> getFavoritosDeUsuario(usuario pUsuario) {
            List<artista> artistas = null;
            try
            {
                artista [] artistaArray = this.dbService.findFavoritos(pUsuario);
                if (artistaArray != null) {
                    artistas = new List<artista>(artistaArray);
                }
            }
            catch (Exception e) {
                artistas = null;
            }
            return artistas;
        }

        //add favorito a usuario
        [WebMethod]
        public bool addArtistaFavoritoAUsuario(artista pArtista, usuario pUsuario)
        {
            bool error = false;
            try
            {
                error = this.dbService.addArtistaFavorito(pUsuario, pArtista);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;
        }

        //delete favorito a usuario
        [WebMethod]
        public bool deleteArtistaFavoritoAUsuario(artista pArtista, usuario pUsuario)
        {
            bool error = false;
            try
            {
                error = this.dbService.deleteArtistaFavorito(pUsuario, pArtista);
            }
            catch (Exception e)
            {
                error = true;
            }
            return error;
        }

        //Invocacion al servicio del grupo Benchmark
        [WebMethod]
        public List<Correo> getCorreos(){
            List<Correo> correos = null;
            try {
                string url = "http://pastelillo.patitocreations.com/BussinessLogicLayerWSBenchmark/webresources/ServicioRest/correosServicioOtroGrupo";
                RestHelper helper = new RestHelper();
                string resultado = helper.WebRequest(RestHelper.Method.GET, url, string.Empty);
                correos = JsonConvert.DeserializeObject<List<Correo>>(resultado);
            }
            catch {
                correos = null;
            }
            return correos;
        }


        #endregion

    }
}
