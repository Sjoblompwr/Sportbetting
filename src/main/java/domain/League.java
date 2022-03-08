/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.LeagueRecord;

/**
 * League object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class League implements BetObject {

    private final LeagueRecord league;
    private final CommonFunctions cf = new CommonFunctions();

    public League() {
        this(new LeagueRecord());
    }

    public League(LeagueRecord record) {
        this.league = record;
    }

    /**
     * get all league table content
     *
     * @return
     */
    public int getId() {
        return cf.getInteger(league, "id");
    }

    public String getName() {
        return cf.getName(league);
    }

    /**
     * Id is set when name is set, since it's an automatically incremential
     * variable
     *
     * @param name
     * @throws ExceptionClass
     */
    public void setName(String name) throws ExceptionClass {
        cf.setName(name, league, LeagueRecord.count().intValue() + 1); // Calling the static method to get the id will cause the test to fail.
    }
    
    public int getSeasonId() {
        return cf.getInteger(league, "season_id");
    }

    public void setSeasonId(int id) {
        cf.setInteger(league, "season_id", id);
    }
    
    
    /**
     * Attitional stuff to get main to work as is.
     * @return 
     */
    public static List<League> findAll() {
        List<LeagueRecord> leagueRecordList = LeagueRecord.findAll();
        return leagueRecordList.stream().map(record -> new League(record)).collect(Collectors.toList());
    }

    public static League findById(int x) {
        return new League(LeagueRecord.findById(x));
    }
    /**
     * Unable to properly move over the static functionallities into cf class.
     * @return 
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
