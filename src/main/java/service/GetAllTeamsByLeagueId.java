/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.Team;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllTeamsByLeagueId {
    //SELECT * FROM Teams WHERE league_id = x;
    public static <Team>List execute(int id){
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        List<Team> list = (List<Team>) domain.Team.findAllSQL("SELECT * FROM teams WHERE league_id = ?",Integer.toString(id));
        dbConn.close();
        return list;
    }
}
