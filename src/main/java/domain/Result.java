/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;

/**
 * Result object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Result extends Model {

    /**
     * get all result table content
     *
     * @return
     */
    public int getResultID() {
        return Integer.parseInt(getString("id"));
    }

    public int getResultMatchID() {
        return Integer.parseInt(getString("match_id"));
    }

    public int getResultTeamOneScore() {
        return Integer.parseInt(getString("team_one_score"));
    }

    public int getResultTeamTwoScore() {
        return Integer.parseInt(getString("team_two_score"));
    }

}
