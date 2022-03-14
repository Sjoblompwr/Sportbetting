/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domain.Season;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dator
 */
public class GetAllLeaguesBySportId {
    public static <League>List execute(int id){
        List<Season> seasons= new ArrayList<>(); 
        List<League> leagues = new ArrayList<>();
        seasons = GetAllSeasonsBySportId.execute(id);
        for(Season s:seasons){
            leagues.addAll(GetAllLeaguesBySeasonId.execute(s.getId()));
        }
        return leagues;
    }
}
