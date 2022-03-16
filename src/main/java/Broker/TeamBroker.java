/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

import domain.BetObject;
import domain.Team;
import java.util.List;
import java.util.stream.Collectors;
import records.TeamRecord;

/**
 *
 * @author Dator
 */
public class TeamBroker implements BrokerFactory{

    @Override
    public List<Team> findAll() { 
    return TeamRecord.findAll().stream() 
            .map(rec -> new Team((TeamRecord) rec)) 
            .collect(Collectors.toList()); 
    } 
    @Override
    public Team findById(int teamId) { 
        return new Team(TeamRecord.findById(teamId)); 
    } 
     @Override
    public Team create() { 
        return new Team(new TeamRecord());  
    }

    @Override
    public List<Team> findAllSQL(String query, String arg) {
        return Team.findAllSQL(query, arg);
    }


    
}
