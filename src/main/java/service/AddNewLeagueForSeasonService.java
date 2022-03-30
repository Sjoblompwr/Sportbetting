/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import domain.ExceptionClass;
import domain.League;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Sjöblom
 */
public class AddNewLeagueForSeasonService extends BaseService<Boolean>{

    private int id;
    private String name;
    public AddNewLeagueForSeasonService(int id,String name){
        if(id<1){
            throw new IllegalArgumentException("id must be above 0");
        }
        if(name == null){
            throw new IllegalArgumentException("Name is null");
        }
        this.id = id;
        this.name = name;
    }

    @Override
    public Boolean execute(){
        if (id < 1) {
            return false;
        } else {
            League league = (League) getBroker().getLeagueBroker().create();
            try {
                league.setName(name);
            } catch (ExceptionClass ex) {
                System.out.println(ex);
            }
            league.setSeasonId(id);
            boolean bool = league.insert();
            return bool;
        }
    }
}
