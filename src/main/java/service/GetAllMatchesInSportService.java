/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.League;
import domain.Season;
import domain.Match;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 *
 * @author Dator
 */
public class GetAllMatchesInSportService {
    public static <Match>List execute(int id){
        List <Season>  seasons = new ArrayList<>();
        List <League> leagues = new ArrayList<>();
        List <Match> matches = new ArrayList<>();
        seasons = GetAllSeasonsBySportId.execute(id);
        for(Season s: seasons){
            leagues.addAll(GetAllLeaguesBySeasonId.execute(s.getId()));
        }
        DbConn dbConn = DbConn.getInstance();
        dbConn.open();
        for(League l: leagues){
            matches.addAll((Collection<? extends Match>) domain.Match.findAllSQL("SELECT * FROM matches WHERE league_id = ?", Integer.toString(l.getId())));
        }
        dbConn.close();
        return matches;
    }
}
