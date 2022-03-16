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
public class GetAllSportsService {
    private DbConn dbConn;
    private Broker broker;
    public void init(DbConn dbConn,Broker broker){
        this.dbConn = dbConn;
        this.broker = broker;
    }
    public <Sport> List execute(){
        this.dbConn.open();
        List<Sport> list = (List<Sport>) broker.getSportBroker().findAll();
        this.dbConn.close();
        return list;
    }
}
