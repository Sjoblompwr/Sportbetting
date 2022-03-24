/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import db.DbConn;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dator
 */
public class GetAllLeaguesBySportIdServiceTest_ {
    

    /**
     * Test of execute method, of class GetAllLeaguesBySportIdService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        int id = 0;
        GetAllLeaguesBySportIdService instance = new GetAllLeaguesBySportIdService();
        List expResult = null;
        List result = instance.execute(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
