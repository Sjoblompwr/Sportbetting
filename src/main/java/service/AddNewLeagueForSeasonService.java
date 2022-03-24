/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import domain.ExceptionClass;
import domain.League;

/**
 *
 * @author David Sjöblom
 */
public class AddNewLeagueForSeasonService {    
    private DbConn dbConn;
    private Broker broker;
    public void init(DbConn dbConn, Broker broker){
        this.dbConn = dbConn;
        this.broker =   broker;
    }
     public boolean execute(int id,String name) throws ExceptionClass{
        if(id < 1){
            return false;
        }
        else{
            League league =  (League) broker.getLeagueBroker().create();
            league.setName(name);
            league.setSeasonId(id);
            this.dbConn.open();
            boolean bool = league.insert();
            this.dbConn.close();
            return bool;
        }
    }
}
