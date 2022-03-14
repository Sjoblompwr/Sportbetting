/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

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
import service.GetAllLeaguesBySportId;
import service.GetAllMatchesInSportService;
import service.GetAllTeamsByLeagueId;
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
           
te = GetAllTeamsBySportIdService.execute(1);
for(Team t:te){
    System.out.println(t.getName() + "    "+ t.getId());
            
}
    }
    
}
