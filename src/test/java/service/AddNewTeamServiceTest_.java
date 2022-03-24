/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Sjöblom
 */
public class AddNewTeamServiceTest_ {


    /**
     * Test of execute method, of class AddNewTeamService.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        int sport_id = 0;
        int season_id = 0;
        int league_id = 0;
        String name = "";
        AddNewTeamService instance = new AddNewTeamService();
    }
       private Broker getMockedBrokerFactory() { 
        LeagueBroker leagueBroker = mock(LeagueBroker.class); 
        Broker broker = mock(Broker.class); 
        when(broker.getLeagueBroker()).thenReturn(leagueBroker); 
        return broker; 
    } 
    private Broker getMockedBrokerFactoryWithBrokersSetup() { 
        Broker broker = getMockedBrokerFactory();
        LeagueBroker leagueBroker =  broker.getLeagueBroker();
        League league = mock(League.class);
        List <League> leagues = new ArrayList<>();
        leagues.add(league);
        when(leagueBroker.findAll()).thenReturn(leagues); 
        return broker; 
    }  
}
