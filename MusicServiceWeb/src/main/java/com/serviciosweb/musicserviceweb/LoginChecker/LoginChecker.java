/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviciosweb.musicserviceweb.LoginChecker;

/**
 *
 * @author Kaver
 */
public interface LoginChecker {
    public boolean isValidLogin(String username, String password);
    public boolean isValidUsername(String username);
    public boolean isValidPassword(String password);
}
