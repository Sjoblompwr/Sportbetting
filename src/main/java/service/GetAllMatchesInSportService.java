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
import java.util.Collection;
import java.util.List;
/**
 * Gets all Season by SportId & gets all Leagues with every SeasonId
 * If leagues exist, return matches otherwise null.
 * @author David Sjöblom
 */
public class GetAllMatchesInSportService {
    private DbConn dbConn;
    private Broker broker;
    public void init(DbConn dbConn,Broker broker){
        this.dbConn = dbConn;
        this.broker = broker;
    }
    public <Match>List execute(int id){
        if(id < 1){
            return null;
        }
        else{
            List <Season>  seasons;
            List <League> leagues = new ArrayList<>();
            List <Match> matches = new ArrayList<>();

            GetAllSeasonsBySportIdService getAllSeasonsBySportId = new GetAllSeasonsBySportIdService();
            getAllSeasonsBySportId.init(this.dbConn,this.broker);
            seasons = getAllSeasonsBySportId.execute(id);

            GetAllLeaguesBySeasonIdService getAllLeaguesBySeasonId = new GetAllLeaguesBySeasonIdService();
            getAllLeaguesBySeasonId.init(this.dbConn,this.broker);
            for(Season s: seasons){
                leagues.addAll(getAllLeaguesBySeasonId.execute(s.getId()));
            }
            //Avoid opening db if input is zero/null.
            if(!leagues.isEmpty()){
                this.dbConn.open();
                for(League l: leagues){
                    matches.addAll((Collection<? extends Match>) broker.getMatchBroker().findAllSQL("SELECT * FROM matches WHERE league_id = ?", Integer.toString(l.getId())));
                }
                this.dbConn.close();
            }
            return matches;
        }
    }
}
