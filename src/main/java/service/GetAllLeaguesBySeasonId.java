/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.League;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllLeaguesBySeasonId {
    public static <League>List execute(int id){
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        List<League> list = (List<League>) domain.League.findAllSQL("SELECT * FROM leagues WHERE season_id = ?", Integer.toString(id));
        dbConn.close();
        return list;
    }
}
