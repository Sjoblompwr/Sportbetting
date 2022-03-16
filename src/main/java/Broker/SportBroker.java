/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

import domain.BetObject;
import domain.Sport;
import java.util.List;
import java.util.stream.Collectors;
import records.SportRecord;

/**
 *
 * @author Dator
 */
public class SportBroker implements BrokerFactory{
    @Override
    public List<Sport> findAll() { 
    return SportRecord.findAll().stream() 
            .map(rec -> new Sport((SportRecord) rec)) 
            .collect(Collectors.toList()); 
    } 
    @Override
    public Sport findById(int sportId) { 
        return new Sport(SportRecord.findById(sportId)); 
    } 
     @Override
    public Sport create() { 
        return new Sport(new SportRecord());  
    }

    @Override
    public List<Sport> findAllSQL(String query, String arg) {
        return Sport.findAllSQL(query,arg);
    }


}
