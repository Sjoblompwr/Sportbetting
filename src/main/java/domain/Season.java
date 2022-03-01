/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.SeasonRecord;

/**
 * Season object inheriting from the model class.
 *
 * @author David Sjöblom
 */
public class Season implements BetObject {
    private final SeasonRecord season;
    public Season(){
        this(new SeasonRecord());
    }
    public Season(SeasonRecord record){
        this.season = record;
    }
//    getid
//            get year
//                    getsportid
//                    setyear
//                            setsportid

    
    public int getId(){
        return Integer.parseInt(season.getString("id"));
    }
    public Short getYear(){
        return Short.parseShort(season.getString("year"));
    }
    public int getSportId(){
        return Integer.parseInt(season.getString("sportid"));
    }
    //Might consider changing datatype in database or way of input. ( scrollbar input would be prefered)
    public void setYear(int year) throws ExceptionClass{
        if(2155 < year && year < 1901){
             throw new ExceptionClass ("Too long ago sql YEAR datatype can only handle 1901-2155");
        }
        season.set("year",year);
        
    }
    public void setSportId(int sportId){
        season.set("sport_id",sportId);
    }
    
    public boolean insert() throws ExceptionClass {
        if (this.getYear() == null) {
            throw new NullPointerException("Year has not been assigned");
        }
        //Not sure, null wasn't allowed.
        if(this.getSportId() == 0){
            throw new NullPointerException("Sport id has not been set.");
        }

        for (Season s : Season.findAll()) {
            if (this.getYear().equals(s.getYear())) {
                System.out.println("Year already exist."); //Should probebly be some sort of exception instead.
                return false;
            }
        }
        
        
        return season.insert();
    }


    /**
     * Attitional stuff to get main to work as is.
     */

    public  static List<Season> findAll() {
        List<SeasonRecord> seasonRecordList = SeasonRecord.findAll();
        return seasonRecordList.stream().map(record -> new Season(record)).collect(Collectors.toList());
//        return (List<Team>) (List<?>)cf.findAll(team);
    }
    
}
