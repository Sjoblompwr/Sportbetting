/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import Broker.Broker;
import db.DbConn;
import domain.League;
import domain.Team;
import java.util.ArrayList;
import java.util.List;
import service.GetAllLeaguesBySeasonIdService;
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
    GetAllTeamsBySportIdService getAllTeamsBySportIdService = new GetAllTeamsBySportIdService(1);
    getAllTeamsBySportIdService.init(new Broker());
    
    te = getAllTeamsBySportIdService.execute();
    for(Team t:te){
        System.out.println(t.getName() + "    "+ t.getId());

    }
    GetAllLeaguesBySeasonIdService getAllLeaguesBySeasonid = new GetAllLeaguesBySeasonIdService(1);
    getAllLeaguesBySeasonid.init(new Broker());

    List<League> list = getAllLeaguesBySeasonid.execute();
    for(League l: list){
        System.out.println(l.getId() + "   " + l.getName() + "    " +  l.getSeasonId());
    }

    }
    
}
