/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

import domain.BetObject;
import domain.League;
import java.util.List;
import java.util.stream.Collectors;
import records.LeagueRecord;

/**
 *
 * @author Dator
 */
public class LeagueBroker implements BrokerFactory{

    @Override
    public List<League> findAll() { 
    return LeagueRecord.findAll().stream() 
            .map(rec -> new League((LeagueRecord) rec)) 
            .collect(Collectors.toList()); 
    } 
    @Override
    public League findById(int leagueId) { 
        return new League(LeagueRecord.findById(leagueId)); 
    } 
     @Override
    public League create() { 
        return new League(new LeagueRecord());  
    }
    @Override
    public List<League> findAllSQL(String query, String arg) {
        return League.findAllSQL(query, arg);
    }


    
}
