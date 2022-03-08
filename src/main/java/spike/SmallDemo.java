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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            //        try {
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
league.setName("hej");
        } catch (ExceptionClass ex) {
            Logger.getLogger(SmallDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(league.getId());
            
//        } catch (ExceptionClass ex) {
//            System.out.println(ex);
//        }
        
        dbConn.close();
//        String s = " foo     bar  ";
//            System.out.println(s);
//            System.out.println(new CommonFunctions().excessWhitespaceRemover(s));

    }
    
}
