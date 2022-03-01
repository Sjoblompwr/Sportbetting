/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;
import records.MatchRecord;

/**
 * Match object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Match implements BetObject{
    private final MatchRecord match;
    public Match(){
        this(new MatchRecord());
    }
    public Match(MatchRecord record){
        this.match = record; 
    }
    /**
     * get all match table content
     *
     * @return
     */
    public int getId() {
        return Integer.parseInt(match.getString("id"));
    }

    public int getLeagueId() {
        return Integer.parseInt(match.getString("league_id"));
    }

    public int getTeamOneId() {
        return Integer.parseInt(match.getString("team_one_id"));
    }

    public int getTeamTwoId() {
        return Integer.parseInt(match.getString("team_two_id"));
    }


}
