/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.LeagueRecord;

/**
 * League domain, getting database connection throught the Record input. Which
 * Should extend Model.
 *
 * @author David Sjöblom
 */
public class League implements BetObject {

    private final LeagueRecord league;

    /**
     *
     */
    public League() {
        this(new LeagueRecord());
    }

    /**
     *
     * @param record
     */
    public League(LeagueRecord record) {
        this.league = record;
    }

    /**
     * Get id attribute
     *
     * @return - id, Integer
     */
    public int getId() {
        return CommonFunctions.getInteger(league, "id");
    }

    /**
     *Get name attribute
     * @return - name, String
     */
    public String getName() {
        return CommonFunctions.getName(league);
    }

    /**
     * Id is set when name is set, since it's an automatically incremential
     * variable
     *
     * @param name - League name
     * @throws ExceptionClass
     */
    public void setName(String name) throws ExceptionClass{
        CommonFunctions.setName(name, league, LeagueRecord.count().intValue() + 1); 
    }
    
    /**
     * Get season id.
     * @return season_id, Integer
     */
    public int getSeasonId() {
        return CommonFunctions.getInteger(league, "season_id");
    }

    /**
     * Set season_id
     * @param id - season_id
     */
    public void setSeasonId(int id) {
        CommonFunctions.setInteger(league, "season_id", id);
    }
    
    
    /**
     * Variant of findAll Model.findAll().
     * @return - list of all leagues
     */
    public static List<League> findAll() {
        List<LeagueRecord> leagueRecordList = LeagueRecord.findAll();
        return leagueRecordList.stream().map(record -> new League(record)).collect(Collectors.toList());
    }
    public static List<League> findAllSQL(String SQL, String params){
        List<LeagueRecord> leagueRecordList = LeagueRecord.findBySQL(SQL, params);
        return leagueRecordList.stream().map(record->new League(record)).collect(Collectors.toList());
        
    }
    /**
     * Find league by id
     * @param id 
     * @return - league
     */
    public static League findById(int id) {
        return new League(LeagueRecord.findById(id));
    }
    /**
     * Insert current league into db. All attributes need to be set.
     * @return true for success otherwise false
     */
    public boolean insert() {
        for (League t : League.findAll()) {
            if (this.getName().equals(t.getName())) {
                System.out.println("League already exist."); //Should probebly be some sort of exception instead.
                return false;
            }
        }
        return league.insert();
    }

}
