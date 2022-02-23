/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import org.javalite.activejdbc.Model;
import records.SportRecord;

/**
 * Sport object inheriting from the model class. With some added methods for
 * "comfort"
 * A Sport contain the attributes:  ID ("primekey")
 *                                  name
 *
 * @author David Sjöblom
 */
public class Sport {
    
    private final SportRecord sport;
        
    public Sport(){
        this(new SportRecord());
    }    
    public Sport(SportRecord record){
        this.sport = record;
    }

    /**
     * get all of sport table content
     *
     * @return
     */
    public int getSportID() {
        return Integer.parseInt(sport.getString("id"));
    }

    public String getSportName() {
        return sport.getString("name");
    }
    
    /** 
     *We want to implement the "base" error handling here, such as we don't accept
     * the empty string as a sport name or already existing id, maybe not even 
     * allow id input to be fair.
     *
     */
    public boolean setName(String name){
        sport.set("name", name);
        return true;
    }
    public boolean setID(int id){
        sport.set("id",id);
        return true;
    }
    public boolean insert(){
        return sport.insert();
    }
    
    
    /**
     * Attitional stuff to get main to work as is.
     */
    public static List<Sport> findAll(){
        List<SportRecord> sportRecordList = SportRecord.findAll();
        return sportRecordList.stream().map(record->new Sport(record)).collect(Collectors.toList());
    }

    public static Sport findById(int x){
        return  new Sport(SportRecord.findById(x));
    }
    public void save(){
        sport.save();
    }
}
