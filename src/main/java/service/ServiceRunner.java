/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import Broker.Broker;
import db.DbConn;
import domain.BetObject;

/**
 *
 * @author David Sjöblom
 */
public class ServiceRunner<T> {
    private final SportstatsService<T> service;
    public ServiceRunner(SportstatsService<T> service){
        this.service = service;
    }

    
    public T execute(){
        DbConn dbConn = DbConn.getInstance();
        service.init(new Broker());
        T result;
        try{
            dbConn.open();   
            result = service.execute();
        }catch(Exception e){
            throw e;
        }
        finally{
            dbConn.close();
        }
        return result;
    }
}
