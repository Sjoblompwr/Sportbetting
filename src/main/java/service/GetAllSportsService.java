/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllSportsService {
    public static <Sport> List execute(){
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        List<Sport> list = (List<Sport>)domain.Sport.findAll();
        dbConn.close();
        return list;
    }
}
