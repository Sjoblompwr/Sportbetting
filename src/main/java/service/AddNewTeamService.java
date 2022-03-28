/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import domain.ExceptionClass;
import domain.Team;

/**
 *
 * @author Dator
 */
public class AddNewTeamService {

    private DbConn dbConn;
    private Broker broker;

    public void init(DbConn dbConn, Broker broker) {
        this.dbConn = dbConn;
        this.broker = broker;
    }

    public boolean execute(int sport_id, int season_id, int league_id, String name) throws ExceptionClass {
        if (dbConn == null) {
            throw new NullPointerException("Database has not been assigned/opened.");
        }
        if (broker == null) {
            throw new NullPointerException("Broker has not been initialized. (null)");
        }
        if (sport_id < 1 || season_id < 1 || league_id < 1) {
            return false;
        } else {
            Team team = (Team) broker.getTeamBroker().create();
            team.setName(name);
            team.setLeagueId(league_id);
            this.dbConn.open();
            boolean bool = team.insert();
            this.dbConn.close();
            return bool;
        }
    }
}
