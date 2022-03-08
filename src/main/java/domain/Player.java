/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.PlayerRecord;

/**
 * Player object inheriting from the model class. With some added methods for
 * "comfort"
 *
 * @author David Sjöblom
 */
public class Player implements BetObject {

    private final PlayerRecord player;
    private final CommonFunctions cf = new CommonFunctions();

    public Player() {
        this(new PlayerRecord());
    }

    public Player(PlayerRecord record) {
        this.player = record;
    }

    /**
     * get all player table content
     *
     * @return
     */
    public int getId() {
        return cf.getInteger(player, "id");
    }

    public String getName() {
        return cf.getName(player);
    }
   
    public int getTeamId(){
        return cf.getInteger(player, "team_id");
    }

    public void setName(String name) throws ExceptionClass {
        cf.setName(name, player, PlayerRecord.count().intValue() + 1);
    }

    public void setTeamId(int id) {
        cf.setInteger(player, "team_id", id);
    }

    public boolean insert() throws ExceptionClass{
//        if (this.getName() == null) {
//            throw new NullPointerException("Player name has not been assigned");
//        }
//        if(this.getTeamId() == 0){
//            throw new ExceptionClass("TeamId has not been selected.");
//        }

        return player.insert();
    }


    public static List<Player> findAll() {
        List<PlayerRecord> playerRecordList = PlayerRecord.findAll();
        return playerRecordList.stream().map(record -> new Player(record)).collect(Collectors.toList());
    }

    public static Player findById(int x) {
        return new Player(PlayerRecord.findById(x));
    }
}
