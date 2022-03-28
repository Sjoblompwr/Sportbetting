/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import domain.ExceptionClass;
import domain.Sport;

/**
 *
 * @author David Sjöblom
 */
public class AddNewSportService {

    private DbConn dbConn;
    private Broker broker;

    public void init(DbConn dbConn, Broker broker) {
        this.dbConn = dbConn;
        this.broker = broker;
    }

    public boolean execute(String name) throws ExceptionClass {
        if (dbConn == null) {
            throw new NullPointerException("Database has not been assigned/opened.");
        }
        if (broker == null) {
            throw new NullPointerException("Broker has not been initialized. (null)");
        }
        this.dbConn.open();
        Sport sport = broker.getSportBroker().create();
        sport.setName(name);
        Boolean bool = sport.insert();
        this.dbConn.close();
        return bool;
    }
}
