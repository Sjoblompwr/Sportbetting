/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import Broker.BrokerFactory;
import db.DbConn;
import domain.Team;
import Broker.BrokerFactory_;

/**
 *
 * @author Dator
 */
public class GetTeamByIdService {
    private DbConn dbConn;
    private BrokerFactory brokerFactory;
    public void init(DbConn dbConn, BrokerFactory_ brokerFactory){
        this.dbConn = dbConn;
        this.brokerFactory =  (BrokerFactory) brokerFactory;
    }
    public Team execute(int id){
        this.dbConn.open();
        Team team;
        team = Team.findById(id);
        BrokerFactory.getSportBroker().findById(id);
        this.dbConn.close();
        return team;
    }
}
