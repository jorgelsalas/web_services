/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosweb.musicserviceweb.LoginChecker;

/**
 *
 * @author Kaver
 */
public class LoginCheckerFactory {
        
    public static LoginChecker getLoginChecker(){
        return new MusicServiceLoginChecker();
    }
}
