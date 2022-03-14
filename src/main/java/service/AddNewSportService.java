/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.ExceptionClass;
import domain.Sport;

/**
 *
 * @author Dator
 */
public class AddNewSportService {
    public static boolean execute(String name) throws ExceptionClass{
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        Sport sport = new Sport();
        sport.setName(name);
        Boolean bool = sport.insert();
        dbConn.close();
        return bool;
    }
}
