/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import domain.Season;
import java.util.List;

/**
 * Return list of seasons based on sport_id
 * @author Dator
 */
public class GetAllSeasonsBySportIdService {
    private DbConn dbConn;
    private Broker broker;
    public void init(DbConn dbConn,Broker broker){
        this.dbConn = dbConn;
        this.broker = broker;
    }
    public <Sport> List execute(int id){
        if(id < 1){
            return null;
        }
        else{
            this.dbConn.open();
            List<Season> list = (List<Season>) broker.getSeasonBroker().findAllSQL("SELECT * FROM seasons WHERE sport_id = ?",Integer.toString(id));
            this.dbConn.close();
            return list;
        }
    }
}
