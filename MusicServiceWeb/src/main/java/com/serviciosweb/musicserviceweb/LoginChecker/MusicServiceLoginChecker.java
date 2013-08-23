/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosweb.musicserviceweb.LoginChecker;

import com.somee.musicservicebl.BLWebService;
import com.somee.musicservicebl.BLWebServiceSoap;

/**
 *
 * @author Kaver
 */
public class MusicServiceLoginChecker implements LoginChecker{

    @Override
    public boolean isValidLogin(String username, String password) {
        boolean valid = false;
        try{
            BLWebService servicio = new BLWebService();
            BLWebServiceSoap port = servicio.getBLWebServiceSoap();
            
            valid = isValidUsername(username) 
                    && isValidPassword(password) 
                    && port.isValidLogin(username, password);
        }
        catch(Exception e){
            valid = false;
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public boolean isValidUsername(String username){
        return username != null && !username.equals("");
    }
    @Override
    public boolean isValidPassword(String password){
        return password != null && !password.equals("");
    }
    
}
