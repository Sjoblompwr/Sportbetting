/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import Broker.Broker;
import db.DbConn;
import domain.CommonFunctions;
import domain.ExceptionClass;
import domain.League;
import domain.Match;
import domain.Player;
import domain.Result;
import domain.Season;
import domain.Sport;
import domain.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.AddNewSportService;
import service.GetAllLeaguesBySeasonIdService;
import service.GetAllLeaguesBySportIdService;
import service.GetAllMatchesInSportService;
import service.GetAllTeamsByLeagueIdService;
import service.GetAllTeamsBySportIdService;

/**
 *
 * @author Dator
 */
public class SmallDemo {
    
    public static void main(String[] args) {

//        Match match = new Match();
//        Result result = new Result();
//        League league = new League();
//        Season season = new Season();
//        Sport sport = new Sport();
//        Team team = new Team();
//        Player player = new Player();
    List <Team> te = new ArrayList<>();
    GetAllTeamsBySportIdService getAllTeamsBySportIdService = new GetAllTeamsBySportIdService();
    DbConn dbConn = DbConn.getInstance();
    getAllTeamsBySportIdService.init(DbConn.getInstance(),new Broker());
    
    te = getAllTeamsBySportIdService.execute(1);
    for(Team t:te){
        System.out.println(t.getName() + "    "+ t.getId());

    }
    GetAllLeaguesBySeasonIdService getAllLeaguesBySeasonid = new GetAllLeaguesBySeasonIdService();
    getAllLeaguesBySeasonid.init(dbConn, new Broker());

    List<League> list = getAllLeaguesBySeasonid.execute(1);
    for(League l: list){
        System.out.println(l.getId() + "   " + l.getName() + "    " +  l.getSeasonId());
    }

    }
    
}
