/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.musicservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author andresarias
 */
public class BaseDAO {
  protected EntityManagerFactory emf = null;
  
    
  protected EntityManager getEntityManager(){
      return (EntityManager)this.emf.createEntityManager();
  }

  public BaseDAO(){ 
      this.emf = Persistence.createEntityManagerFactory("com.serviciosweb_MusicService_war_1.0-SNAPSHOTPU");
  } 
}
