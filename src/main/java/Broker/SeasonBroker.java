/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

import domain.Season;
import java.util.List;
import java.util.stream.Collectors;
import records.SeasonRecord;

/**
 *
 * @author Dator
 */
public class SeasonBroker implements BrokerFactory{

    @Override
    public List<Season> findAll() { 
    return SeasonRecord.findAll().stream() 
            .map(rec -> new Season((SeasonRecord) rec)) 
            .collect(Collectors.toList()); 
    } 
    @Override
    public Season findById(int seasonId) { 
        return new Season(SeasonRecord.findById(seasonId)); 
    } 
     @Override
    public Season create() { 
        return new Season(new SeasonRecord());  
    }

    @Override
    public List<Season> findAllSQL(String query, String arg) {
        return Season.findAllSQL(query,arg);
    }


    
}
