/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spike;

import db.DbConn;
import domain.CommonFunctions;
import domain.League;
import domain.Match;
import domain.Player;
import domain.Result;
import domain.Season;
import domain.Sport;
import domain.Team;
import java.util.List;

/**
 *
 * @author Dator
 */
public class SmallDemo {
    
    public static void main(String[] args) {
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        Match match = new Match();
        Result result = new Result();
        League league = new League();
        Season season = new Season();
        Sport sport = new Sport();
        Team team = new Team();
        Player player = new Player();
        
        System.out.println();
        try {

//               team.setName("Lotus");
//                System.out.println("Lotus: " + team.getName());
//                System.out.println(team.insert());
//                team.setName("Enter");
//                System.out.println("Enter: " + team.getName());
//                System.out.println(team.insert());
//        List<Sport> lists = Sport.findAll();
//        for(Sport t:lists){
//            System.out.println(t.getName());
//        }
//                System.out.println("");
//        List<Team> list = team.findAll();
//        for(Team t:list){
//            System.out.println(t.getName());
//        }
            player.setName("Thomas");
            player.setTeamId(1);
            player.insert();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Exception");
        }
        
        dbConn.close();
//        String s = " foo     bar  ";
//            System.out.println(s);
//            System.out.println(new CommonFunctions().excessWhitespaceRemover(s));

    }
    
}
