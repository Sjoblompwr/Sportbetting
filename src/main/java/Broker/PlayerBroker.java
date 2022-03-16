/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

import domain.Player;
import java.util.List;
import java.util.stream.Collectors;
import records.PlayerRecord;

/**
 *
 * @author Dator
 */
public class PlayerBroker implements BrokerFactory{

    @Override
    public List<Player> findAll() { 
    return PlayerRecord.findAll().stream() 
            .map(rec -> new Player((PlayerRecord) rec)) 
            .collect(Collectors.toList()); 
    } 
    @Override
    public Player findById(int playerId) { 
        return new Player(PlayerRecord.findById(playerId)); 
    } 
     @Override
    public Player create() { 
        return new Player(new PlayerRecord());  
    }

    @Override
    public List<Player> findAllSQL(String query, String arg) {
        return Player.findAllSQL(query,arg);
    }


}
