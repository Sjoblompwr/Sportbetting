/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DbConn;
import domain.League;
import domain.Season;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllTeamsBySportIdService {
    public  static <Team>List execute(int id){

        
        List<Season> seasons = GetAllSeasonsBySportId.execute(id);
        List<League> leagues = new ArrayList<>();
        List<Team> teams = new ArrayList<>();
        for(Season s: seasons){
            leagues.addAll(GetAllLeaguesBySeasonId.execute(s.getId()));
        }
        
        for(League l: leagues){
            teams.addAll(GetAllTeamsByLeagueId.execute(l.getId()));
        }

        return teams;
        
    }
}
