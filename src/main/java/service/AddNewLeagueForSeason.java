/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.ExceptionClass;
import domain.League;

/**
 *
 * @author Dator
 */
public class AddNewLeagueForSeason {
    //season id input
    public static boolean execute(int id,String name) throws ExceptionClass{
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        League league  = new League();
        league.setName(name);
        league.setSeasonId(id);
        boolean bool = league.insert();
        dbConn.close();
        return bool;
    }
}
