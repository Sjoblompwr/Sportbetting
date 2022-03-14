/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.ExceptionClass;
import domain.Team;

/**
 *
 * @author Dator
 */
public class AddNewTeamService {
    public static boolean execute(int sport_id,int season_id,int league_id,String name) throws ExceptionClass{
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        Team team = new Team();
        team.setName(name);
        team.setLeagueId(league_id);
        boolean bool = team.insert();
        dbConn.close();
        return bool;
    }
}
