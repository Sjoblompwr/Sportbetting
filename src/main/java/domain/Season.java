/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.SeasonRecord;

/**
 * Season object , getting database connection throught the Record input. Which
 * Should extend Model.
 *
 * @author David Sjöblom
 */
public class Season implements BetObject {

    private final SeasonRecord season;

    /**
     *
     */
    public Season() {
        this(new SeasonRecord());
    }

    /**
     *
     * @param record
     */
    public Season(SeasonRecord record) {
        this.season = record;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return CommonFunctions.getInteger(season, "id");
    }

    /**
     *
     * @return Format: "YEAR-MONTH-DAY"
     */
    public String getYear() {
        return season.getString("year");
    }

    /**
     *
     * @return
     */
    public int getSportId() {
        return CommonFunctions.getInteger(season, "sport_id");
    }
    
    public void setId(int id){
        CommonFunctions.setInteger(season, "id", id);
    }
    //Might consider changing datatype in database or way of input. ( scrollbar input would be prefered)

    /**
     *
     * @param year
     * @throws ExceptionClass
     */
    public void setYear(int year) throws ExceptionClass {
        if (2155 < year || year < 1901) {
            throw new ExceptionClass("Too long ago sql YEAR datatype can only handle 1901-2155");
        }
        CommonFunctions.setInteger(season, "year", year);
    }

    /**
     *
     * @param id
     */
    public void setSportId(int id) {
        CommonFunctions.setInteger(season, "sport_id", id);
    }

    /**
     * Season needed a special insert method compared to the other domain object
     * which only had name/id input.
     *
     * @return
     * @throws ExceptionClass
     */
    public boolean insert() throws ExceptionClass {
//        if (this.getYear() == 0) {
//            throw new NullPointerException("Year has not been assigned");
//        }
//        //Not sure, null wasn't allowed.
//        if (this.getSportId() == 0) {
//            throw new NullPointerException("Sport id has not been set.");
//        }

        for (Season s : Season.findAll()) {
            if (this.getYear() == s.getYear()) {
                System.out.println("Year already exist.");
                return false;
            }
        }

        return season.insert();
    }

    /**
     * Attitional stuff to get main to work as is.
     * @return 
     */
    public static List<Season> findAll() {
        List<SeasonRecord> seasonRecordList = SeasonRecord.findAll();
        return seasonRecordList.stream().map(record -> new Season(record)).collect(Collectors.toList());
//        return (List<Season>) (List<?>)CommonFunctions.findAll(season);
    }
    public static List<Season> findAllSQL(String SQL, String params){
        List<SeasonRecord> seasonRecordList = SeasonRecord.findBySQL(SQL, params);
        return seasonRecordList.stream().map(record->new Season(record)).collect(Collectors.toList());
        
    }
}
