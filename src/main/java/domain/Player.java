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
        return player.getString("name");
    }

    public void setName(String name) throws ExceptionClass {
        cf.setName(name, player, PlayerRecord.count().intValue() + 1);
    }

    public void setTeamId(int id) {
        player.set("team_id", id);
    }

    public boolean insert() {
        if (this.getName() == null) {
            throw new NullPointerException("Player name has not been assigned");
        }

        for (Player p : Player.findAll()) {
            if (this.getName().equals(p.getName())) {
                System.out.println("Player already exist."); //Should probebly be some sort of exception instead.
                return false;
            }
        }
        return player.insert();
    }

    /**
     * Attitional stuff to get main to work as is.
     */
    public static List<Player> findAll() {
        List<PlayerRecord> playerRecordList = PlayerRecord.findAll();
        return playerRecordList.stream().map(record -> new Player(record)).collect(Collectors.toList());
//        return (List<Player>) (List<?>)cf.findAll(player);
    }

    public static Player findById(int x) {
        return new Player(PlayerRecord.findById(x));
    }
}
