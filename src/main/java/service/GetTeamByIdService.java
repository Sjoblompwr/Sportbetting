/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.Team;

/**
 *
 * @author Dator
 */
public class GetTeamByIdService {
    public static Team execute(int id){
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        Team team;
        team = Team.findById(id);
        dbConn.close();
        return team;
    }
}
