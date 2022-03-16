/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

import domain.BetObject;
import domain.Match;
import java.util.List;
import java.util.stream.Collectors;
import records.MatchRecord;

/**
 *
 * @author Dator
 */
public class MatchBroker implements BrokerFactory {

    @Override
    public List<Match> findAll() { 
    return MatchRecord.findAll().stream() 
            .map(rec -> new Match((MatchRecord) rec)) 
            .collect(Collectors.toList()); 
    } 
    @Override
    public Match findById(int matchId) { 
        return new Match(MatchRecord.findById(matchId)); 
    } 
     @Override
    public Match create() { 
        return new Match(new MatchRecord());  
    }

    @Override
    public List<Match> findAllSQL(String query, String arg) {
        return Match.findAllSQL(query, arg);
    }


    
}
