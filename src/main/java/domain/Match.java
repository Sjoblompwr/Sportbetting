/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.MatchRecord;

/**
 * Match object , getting database connection throught the Record input. Which
 * Should extend Model.
 *
 * @author David Sjöblom
 */

public class Match implements BetObject {

    private final MatchRecord match;

    /**
     *
     */
    public Match() {
        this(new MatchRecord());
    }

    /**
     *
     * @param record
     */
    public Match(MatchRecord record) {
        this.match = record;
    }

    /**
     * Get id
     *
     * @return - id, Integer
     */
    public int getId() {
        return CommonFunctions.getInteger(match, "id");
    }

    /**
     * Get League id
     * @return league_id, integer
     */
    public int getLeagueId() {
        return CommonFunctions.getInteger(match, "league_id");
    }

    /**
     * Get Team One Id
     * @return - team_one_id, integer
     */
    public int getTeamOneId() {
        return CommonFunctions.getInteger(match, "team_one_id");
    }

    /**
     * get Team Two Id
     * @return - team_two_id, integer
     */
    public int getTeamTwoId() {
        return CommonFunctions.getInteger(match, "team_two_id");
    }

    /**
     * Set league_id
     * @param id
     */
    public void setLeagueId(int id) {
        CommonFunctions.setInteger(match, "league_id", id);
    }

    /**
     * Set team_one_id
     * @param id
     */
    public void setTeamOneId(int id) {
       CommonFunctions.setInteger(match, "team_one_id", id);
    }

    /**
     * Set team_two_id
     * @param id
     */
    public void setTeamTwoId(int id) {
        CommonFunctions.setInteger(match, "team_two_id", id);
    }

    /**
     * Insert current match into db. All attributes need to be set.
     * @return true for success otherwise false
     * @throws ExceptionClass
     */
    public boolean insert() throws ExceptionClass{
        CommonFunctions.setInteger(match, "id", MatchRecord.count().intValue() + 1);
//        if (this.getId() == 0) {
//            throw new NullPointerException("Something is wrong with the automatic assigning of id value.");
//        }
//        if(this.getLeagueId() == 0){
//            throw new ExceptionClass("LeagueId has not been set");
//        }
//        if(this.getTeamOneId() == 0){
//            throw new ExceptionClass("TeamOneId has not been set");
//        }
//        if(this.getTeamTwoId() == 0){
//            throw new ExceptionClass("TeamTwoId has not been set");
//        }
        return match.insert();
    }

    /**
     * Variant of findAll Model.findAll().
     * @return - list of all matches
     */
    public static List<Match> findAll() {
        List<MatchRecord> matchRecordList = MatchRecord.findAll();
        return matchRecordList.stream().map(record -> new Match(record)).collect(Collectors.toList());

    }
    public static List<Match> findAllSQL(String SQL, String params){
        List<MatchRecord> matchRecordList = MatchRecord.findBySQL(SQL, params);
        return matchRecordList.stream().map(record->new Match(record)).collect(Collectors.toList());
        
    }
    /**
     * Find match by id
     * @param id
     * @return - match
     */
    public static Match findById(int id) {
        return new Match(MatchRecord.findById(id));
    }
}
