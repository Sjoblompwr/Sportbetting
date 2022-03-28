/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import Broker.Broker;
import db.DbConn;

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
        dbConn.open();
        service.init(new Broker());
        T result = service.execute();
        dbConn.close();
        return result;
    }
    
}
