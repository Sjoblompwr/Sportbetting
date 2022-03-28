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
public class GetAllLeaguesBySeasonIdService {

    private DbConn dbConn;
    private Broker broker;

    public void init(DbConn dbConn, Broker broker) {
        this.dbConn = dbConn;
        this.broker = broker;
    }

    public <League> List execute(int id) {
        if (dbConn == null) {
            throw new NullPointerException("Database has not been assigned/opened.");
        }
        if (broker == null) {
            throw new NullPointerException("Broker has not been initialized. (null)");
        }
        if (id < 1) {
            return null;
        } else {
            this.dbConn.open();
            List<League> list = (List<League>) broker.getLeagueBroker()
                    .findAllSQL("SELECT * FROM leagues WHERE season_id = ?", Integer.toString(id));
            this.dbConn.close();
            return list;
        }
    }
}
