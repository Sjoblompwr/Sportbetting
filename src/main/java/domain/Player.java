/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import records.PlayerRecord;


/**
 * Player object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Player {
    private final PlayerRecord player;
    public Player(){
        this(new PlayerRecord());
    }
    public Player(PlayerRecord record){
        this.player = record;
    }
    /**
     * get all player table content
     *
     * @return
     */
    public int getPlayerID() {
        return Integer.parseInt(player.getString("id"));
    }

    public String getPlayerName() {
        return player.getString("player.name");
    }

    public int getPlayerTeamID() {
        return Integer.parseInt(player.getString("team_id"));
    }
}
