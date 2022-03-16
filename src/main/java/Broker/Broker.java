/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

/**
 *
 * @author Dator
 */
public class Broker{

    public SportBroker getSportBroker(){
        return new SportBroker();
    }
    public TeamBroker getTeamBroker(){
        return new TeamBroker();
    }
    public PlayerBroker getPlayerBroker(){
        return new PlayerBroker();
    }
    public SeasonBroker getSeasonBroker(){
        return new SeasonBroker();
    }
    public LeagueBroker getLeagueBroker(){
        return new LeagueBroker();
    }
    public MatchBroker getMatchBroker(){
        return new MatchBroker();
    }
    public ResultBroker getResultBroker(){
        return new ResultBroker();
    }
}
