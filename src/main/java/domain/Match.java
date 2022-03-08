/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import org.javalite.activejdbc.Model;
import records.MatchRecord;

/**
 * Match object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Match implements BetObject {

    private final MatchRecord match;
    private final CommonFunctions cf = new CommonFunctions();

    public Match() {
        this(new MatchRecord());
    }

    public Match(MatchRecord record) {
        this.match = record;
    }

    /**
     * get all match table content
     *
     * @return
     */
    public int getId() {
        return cf.getInteger(match, "id");
    }

    public int getLeagueId() {
        return cf.getInteger(match, "league_id");
    }

    public int getTeamOneId() {
        return cf.getInteger(match, "team_one_id");
    }

    public int getTeamTwoId() {
        return cf.getInteger(match, "team_two_id");
    }

    public void setLeagueId(int id) {
        cf.setInteger(match, "league_id", id);
    }

    public void setTeamOneId(int id) {
       cf.setInteger(match, "team_one_id", id);
    }

    public void setTeamTwoId(int id) {
        cf.setInteger(match, "team_two_id", id);
    }

    public boolean insert() throws ExceptionClass{
        cf.setInteger(match, "id", MatchRecord.count().intValue() + 1);
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


    public static List<Match> findAll() {
        List<MatchRecord> matchRecordList = MatchRecord.findAll();
        return matchRecordList.stream().map(record -> new Match(record)).collect(Collectors.toList());

    }

    public static Match findById(int id) {
        return new Match(MatchRecord.findById(id));
    }
}
