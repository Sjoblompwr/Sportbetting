package service;

import Broker.Broker;
import db.DbConn;
import domain.Team;

/**
 *
 * @author Dator
 */
public class GetTeamByIdService {

    private DbConn dbConn;
    private Broker broker;

    public void init(DbConn dbConn, Broker broker) {
        this.dbConn = dbConn;
        this.broker = broker;
    }

    public Team execute(int id) {
        if (dbConn == null) {
            throw new NullPointerException("Database has not been assigned/opened.");
        }
        if (broker == null) {
            throw new NullPointerException("Broker has not been initialized. (null)");
        }
        Team team;
        if (id < 1) {
            return null;
        } else {
            this.dbConn.open();
            team = (Team) broker.getTeamBroker().findById(id);
            this.dbConn.close();
            return team;
        }
    }
}
