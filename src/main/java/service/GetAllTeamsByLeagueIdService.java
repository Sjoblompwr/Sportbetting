/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllTeamsByLeagueIdService {
    private DbConn dbConn;
    private Broker broker;
    public void init(DbConn dbConn,Broker broker){
        this.dbConn = dbConn;
        this.broker = broker;
               
    }
    public <Team>List execute(int id){
        if(id < 1){
            return null;
        }
        else{
            this.dbConn.open();
            List<Team> list = (List<Team>) broker.getTeamBroker().findAllSQL("SELECT * FROM teams WHERE league_id = ?",Integer.toString(id));
            this.dbConn.close();
            return list;
        }
    }
}
