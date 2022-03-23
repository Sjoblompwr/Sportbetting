/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.LeagueBroker;
import db.DbConn;
import domain.League;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Dator
 */
public class GetAllLeaguesBySeasonIdServiceTest_ {
    //get all leagues by seasonid
    /**
     * Test of execute method, of class GetAllLeaguesBySeasonIdService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int id = 0;
        GetAllLeaguesBySeasonIdService instance = new GetAllLeaguesBySeasonIdService();
        List expResult = null;
        List result = instance.execute(id);
        assertEquals(expResult, result);
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
