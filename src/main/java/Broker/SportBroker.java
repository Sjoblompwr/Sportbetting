/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

import domain.Sport;
import java.util.List;
import java.util.stream.Collectors;
import records.SportRecord;

/**
 *
 * @author Dator
 */
public class SportBroker implements BrokerFactory_{
    public List<Sport> findAll() { 
    return SportRecord.findAll().stream() 
            .map(rec -> new Sport((SportRecord) rec)) 
            .collect(Collectors.toList()); 
    } 
     
    public Sport findById(Long sportId) { 
        return new Sport(SportRecord.findById(sportId)); 
    } 
     
    // Create får samma frågor som 'new', dvs skall det finnas setters, eller skall  
    // allt finns i konstruktorn. Skall det vara sparat i databasen direkt så man får ett id? 
    public Sport create() { 
        return new Sport(new SportRecord());  // Olika beroende om ni kör med DAO eller Record 
    }
}
