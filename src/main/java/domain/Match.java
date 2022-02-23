/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;

/**
 * Match object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Match extends Model {

    /**
     * get all match table content
     *
     * @return
     */
    public int getMatchID() {
        return Integer.parseInt(getString("id"));
    }

    public int getMatchLeagueID() {
        return Integer.parseInt(getString("league_id"));
    }

    public int getMatchTeamOneID() {
        return Integer.parseInt(getString("team_one_id"));
    }

    public int getMatchTeamTwoID() {
        return Integer.parseInt(getString("team_two_id"));
    }
}
