/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.Season;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllSeasonsBySportId {
    public static <Sport> List execute(int id){        
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        List<Season> list = (List<Season>) domain.Season.findAllSQL("SELECT * FROM seasons WHERE sport_id = ?",Integer.toString(id));
        dbConn.close();
        return list;
    }
}
