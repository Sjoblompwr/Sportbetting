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
public class Player implements BetObject{
    private final PlayerRecord player;
    private final CommonFunctions cf = new CommonFunctions();
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
    public int getId() {
        return Integer.parseInt(player.getString("id"));
    }

    public String getName() {
        return player.getString("player.name");
    }
    public void setName(String name) throws ExceptionClass{
        cf.setName(name, player, PlayerRecord.count().intValue() + 1);
    }

    public int getTeamID() {
        return Integer.parseInt(player.getString("team_id"));
    }


}
