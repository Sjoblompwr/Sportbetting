/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.List;
import java.util.stream.Collectors;
import records.PlayerRecord;

/**
 * Player object , getting database connection throught the Record input. Which
 * Should extend Model.
 *
 * @author David Sjöblom
 */
public class Player implements BetObject {


  

    private final PlayerRecord player;

    /**
     *
     */
    public Player() {
        this(new PlayerRecord());
    }

    /**
     *
     * @param record
     */
    public Player(PlayerRecord record) {
        this.player = record;
    }

    /**
     * get all player table content
     *
     * @return
     */
    public int getId() {
        return CommonFunctions.getInteger(player, "id");
    }

    /**
     *
     * @return
     */
    public String getName() {
        return CommonFunctions.getName(player);
    }
   
    /**
     *
     * @return
     */
    public int getTeamId(){
        return CommonFunctions.getInteger(player, "team_id");
    }

    /**
     *
     * @param name
     * @throws ExceptionClass
     */
    public void setName(String name) throws ExceptionClass {
        CommonFunctions.setName(name, player, PlayerRecord.count().intValue() + 1);
    }

    /**
     *
     * @param id
     */
    public void setTeamId(int id) {
        CommonFunctions.setInteger(player, "team_id", id);
    }

    /**
     *
     * @return
     * @throws ExceptionClass
     */
    public boolean insert() throws ExceptionClass{
//        if (this.getName() == null) {
//            throw new NullPointerException("Player name has not been assigned");
//        }
//        if(this.getTeamId() == 0){
//            throw new ExceptionClass("TeamId has not been selected.");
//        }

        return player.insert();
    }

    /**
     *
     * @return
     */
    public static List<Player> findAll() {
        List<PlayerRecord> playerRecordList = PlayerRecord.findAll();
        return playerRecordList.stream().map(record -> new Player(record)).collect(Collectors.toList());
    }

      public static List<Player> findAllSQL(String query, String arg) {
        List<PlayerRecord> playerRecordList = PlayerRecord.findBySQL(query, arg);
        return playerRecordList.stream().map(record->new Player(record)).collect(Collectors.toList());
        
    } 
    /**
     *
     * @param x
     * @return
     */
    public static Player findById(int x) {
        return new Player(PlayerRecord.findById(x));
    }
}
