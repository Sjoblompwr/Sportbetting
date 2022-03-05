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

    public int getMatchOneId() {
        return cf.getInteger(match, "match_one_id");
    }

    public int getMatchTwoId() {
        return cf.getInteger(match, "match_two_id");
    }

    public void setLeagueId(int id) {
        match.set("league_id", id);
    }

    public void setMatchOneId(int id) {
        match.set("match_one_id", id);
    }

    public void setMatchTwoId(int id) {
        match.set("match_two_id", id);
    }

    public boolean insert() {
        if (this.getId() == 0) {
            throw new NullPointerException("Match id has not been assigned");
        }

        for (Match m : Match.findAll()) {
            if (this.getId() == m.getId()) {
                System.out.println("Match already exist."); //Should probebly be some sort of exception instead.
                return false;
            }
        }
        return match.insert();
    }

    /**
     * Attitional stuff to get main to work as is.
     */
    public static List<Match> findAll() {
        List<MatchRecord> matchRecordList = MatchRecord.findAll();
        return matchRecordList.stream().map(record -> new Match(record)).collect(Collectors.toList());
//        return (List<Match>) (List<?>)cf.findAll(match);
    }

    public static Match findById(int id) {
        return new Match(MatchRecord.findById(id));
    }
}
