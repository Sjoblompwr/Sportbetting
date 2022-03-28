/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import domain.Season;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllLeaguesBySportIdService {

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
            List<Season> seasons;
            List<League> leagues = new ArrayList<>();

            GetAllSeasonsBySportIdService getAllSeasonsBySportId = new GetAllSeasonsBySportIdService();
            getAllSeasonsBySportId.init(this.dbConn, this.broker);
            seasons = getAllSeasonsBySportId.execute(id);

            GetAllLeaguesBySeasonIdService getAllLeaguesBySeasonId = new GetAllLeaguesBySeasonIdService();
            getAllLeaguesBySeasonId.init(this.dbConn, this.broker);
            for (Season s : seasons) {
                leagues.addAll(getAllLeaguesBySeasonId.execute(s.getId()));
            }

            return leagues;
        }
    }
}
