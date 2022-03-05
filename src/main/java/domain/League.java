/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import org.javalite.activejdbc.Model;
import records.LeagueRecord;

/**
 * League object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class League implements BetObject {

    /**
     * Attitional stuff to get main to work as is.
     */
    public static List<League> findAll() {
        List<LeagueRecord> leagueRecordList = LeagueRecord.findAll();
        return leagueRecordList.stream().map(record -> new League(record)).collect(Collectors.toList());
//        return (List<League>) (List<?>)cf.findAll(league);
    }

    public static League findById(int x) {
        return new League(LeagueRecord.findById(x));
    }
    private final LeagueRecord league;
    private final CommonFunctions cf = new CommonFunctions();

    public League() {
        this(new LeagueRecord()); // "snyggare" viss att skriva this.league = new LeagueRecord();
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
        return league.getString("name");
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
        league.set("season_id", id);
    }

    public boolean insert() {
        if (this.getName() == null) {
            throw new NullPointerException("Sport name has not been assigned");
        }

        for (League t : League.findAll()) {
            if (this.getName().equals(t.getName())) {
                System.out.println("League already exist."); //Should probebly be some sort of exception instead.
                return false;
            }
        }
        return league.insert();
    }

}
