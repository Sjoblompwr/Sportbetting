/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import domain.League;
import domain.Season;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllTeamsBySportIdService {
    private DbConn dbConn;
    private Broker broker;
    public void init(DbConn dbConn,Broker broker){
        this.dbConn = dbConn;
        this.broker = broker;
    }
    public  <Team>List execute(int id){ 
        if(id < 1){
            return null;
        }
        else{
            GetAllSeasonsBySportIdService getAllSeasonsBySportId = new GetAllSeasonsBySportIdService();
            getAllSeasonsBySportId.init(this.dbConn,this.broker);
            List<Season> seasons = getAllSeasonsBySportId.execute(id);

            List<League> leagues = new ArrayList<>();
            List<Team> teams = new ArrayList<>();

            GetAllLeaguesBySeasonIdService getAllLeaguesBySeasonId = new GetAllLeaguesBySeasonIdService();
            getAllLeaguesBySeasonId.init(this.dbConn,new Broker());

            for(Season s: seasons){
                leagues.addAll(getAllLeaguesBySeasonId.execute(s.getId()));
            }

            GetAllTeamsByLeagueIdService getAllTeamsByLeagueId = new GetAllTeamsByLeagueIdService();
            getAllTeamsByLeagueId.init(this.dbConn,this.broker);
            for(League l: leagues){
                teams.addAll(getAllTeamsByLeagueId.execute(l.getId()));
            }

            return teams;
        }
    }
}
