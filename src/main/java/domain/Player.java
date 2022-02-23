/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import org.javalite.activejdbc.Model;

/**
 * Player object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Player extends Model {

    /**
     * get all player table content
     *
     * @return
     */
    public int getPlayerID() {
        return Integer.parseInt(getString("id"));
    }

    public String getPlayerName() {
        return getString("player.name");
    }

    public int getPlayerTeamID() {
        return Integer.parseInt(getString("team_id"));
    }
}
