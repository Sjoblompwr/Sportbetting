/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Broker;

/**
 *
 * @author Dator
 */
public class BrokerFactory implements BrokerFactory_{

    public BrokerFactory_ getSportBroker(){
        return new SportBroker();
    }
    public BrokerFactory_ getTeamBroker(){
        return new SportBroker();
    }
    public BrokerFactory_ getPlayerBroker(){
        return new SportBroker();
    }
    public BrokerFactory_ getSeasonBroker(){
        return new SportBroker();
    }
    public BrokerFactory_ getLeagueBroker(){
        return new SportBroker();
    }
    public BrokerFactory_ getMatchBroker(){
        return new SportBroker();
    }
    public BrokerFactory_ getResultBroker(){
        return new SportBroker();
    }
}
