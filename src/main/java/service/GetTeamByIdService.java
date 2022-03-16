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
    public void init(DbConn dbConn, Broker broker){
        this.dbConn = dbConn;
        this.broker =   broker;
    }
    public Team execute(int id){
        Team team;
        if(id < 1){
            return null;
        }
        else{
            this.dbConn.open();
            team = (Team) broker.getTeamBroker().findById(id);
            this.dbConn.close();
            return team;
        }
    }
}
