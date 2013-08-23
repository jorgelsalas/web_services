package com.serviciosweb.musicserviceweb;


import com.serviciosweb.musicserviceweb.LoginChecker.LoginCheckerFactory;
import com.serviciosweb.musicserviceweb.LoginChecker.LoginChecker;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.somee.musicservicebl.BLWebService;
import com.somee.musicservicebl.BLWebServiceSoap;
import com.musicservice.service.Usuario;

/**
 *
 * @author Kaver
 */
public class LoginHelper {
    
    private LoginChecker checker;
    private static final String USERNAME_COOKIE_NAME = "username";
    private static final String PASSWORD_COOKIE_NAME = "password";
    private static final String PROFILE_COOKIE_NAME = "profile";
    
    public LoginHelper(){
        checker = LoginCheckerFactory.getLoginChecker();
    }
    
    public boolean isUserLoggedIn(HttpServletRequest request){
        boolean isLoggedIn = false;
        Cookie usernameCookie = this.getUsernameCookie(request);
        Cookie passwordCookie = this.getPasswordCookie(request);
        
       return isValidCookie(passwordCookie) && isValidCookie(usernameCookie);
               
    }
    
    public boolean login(String username, String password, HttpServletResponse response){
        boolean error = true;
        try{       
            if(this.checker.isValidLogin(username, password)){
                Cookie usernameCookie = new Cookie(USERNAME_COOKIE_NAME, username);
                usernameCookie.setMaxAge(365*24*60*60); //Validez de un año
                Cookie passwordCookie = new Cookie(PASSWORD_COOKIE_NAME, password);
                passwordCookie.setMaxAge(365*24*60*60);
                
                BLWebService servicio = new BLWebService();
                BLWebServiceSoap port = servicio.getBLWebServiceSoap();
                Usuario usuario = port.getUsuarioByUsername(username);
                int profile = usuario.getIdPerfil().getIdPerfil();
                Cookie profileCookie = new Cookie(PROFILE_COOKIE_NAME, Integer.toString(profile));
                profileCookie.setMaxAge(365*24*60*60);
                
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                response.addCookie(profileCookie);
                
                error = false;
            }
        }
        catch(Exception e){
            error = true;
            e.printStackTrace();
        }
        return error;
    }
    
    public boolean logout(HttpServletRequest request, HttpServletResponse response){
        boolean error = true;
        try{
            Cookie usernameCookie = this.getUsernameCookie(request);
            Cookie passwordCookie = this.getPasswordCookie(request);
            Cookie profileCookie = this.getProfileCookie(request);

            //JSP no deja borrar cookies, así que dejamos cookies en blanco
            if(usernameCookie != null && passwordCookie != null){
                usernameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                error = false;
            }
            
            if(profileCookie != null){
                profileCookie.setMaxAge(0);
                response.addCookie(profileCookie);
            }
            
        } catch (Exception e){
            error = true;
        }
        return error;
    }
    
    public String getUsername(HttpServletRequest request){
        String username = null;
        try{
            if(this.isUserLoggedIn(request) && this.getUsernameCookie(request) != null){
                username = this.getUsernameCookie(request).getValue();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return username;
    }
    
    public String getProfile(HttpServletRequest request){
        String profile = null;
        try{
            if(this.isUserLoggedIn(request) && this.getProfileCookie(request) != null){
                profile = this.getProfileCookie(request).getValue();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return profile;
    }
            
    private Cookie getCookie(Cookie [] cookies, String cookieName){
        if(cookies != null){
            for(int i = 0; i < cookies.length; ++i){
                if(cookies[i].getName().equals(cookieName)){
                    return cookies[i];
                }
            }
        }
        return null;
    }
    
    private Cookie getUsernameCookie(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        return this.getCookie(cookies, USERNAME_COOKIE_NAME);
    }
    
    private Cookie getPasswordCookie(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        return this.getCookie(cookies, PASSWORD_COOKIE_NAME);
    }
    
    private Cookie getProfileCookie(HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        return this.getCookie(cookies, PROFILE_COOKIE_NAME);
    }
    
    private boolean isValidCookie(Cookie cookie){
        return cookie != null && !cookie.getValue().equals("");
    }
    
}
