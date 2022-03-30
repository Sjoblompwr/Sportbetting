/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.SeasonBroker;
import db.DbConn;
import domain.Season;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author David Sjöblom
 */
public class GetAllSeasonsBySportIdServiceTest{
    
    /**
     * Test of execute method, of class GetAllSeasonsBySeasonIdService.
     * Check if expected null is "thrown" when input it invalid.
     */
    @Test
    public void testExecute_ReturnNull() {
        System.out.println("execute_ReturnNull");
        int id = 0;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        Exception exception = assertThrows(IllegalArgumentException.class,()->{
            GetAllSeasonsBySportIdService service = new GetAllSeasonsBySportIdService(id);
            service.init(broker);
        });
        assertTrue("Id must be above 0.".contains(exception.getMessage()));
    }
        
    /**
     * Test of execute method, of class GetAllSeasonsBySeasonIdService.
     * Check if something returns when expected input happens
     */
    @Test
    public void testExecute_ReturnList() {
        System.out.println("execute_ReturnList");
        int id = 1;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        GetAllSeasonsBySportIdService service = new GetAllSeasonsBySportIdService(id);
        service.init(broker);
        assertNotNull(service.execute());
    }
    /**
     * Test of execute method, of class GetAllSeasonsBySeasonIdService.
     * Checking if correct method is called
     */
    @Test
    public void testExecute_Behaviour() {
        System.out.println("execute_Behaviour");
        int id = 1;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        GetAllSeasonsBySportIdService service = new GetAllSeasonsBySportIdService(id);
        service.init(broker);
        service.execute();
        verify(broker.getSeasonBroker(),times(1)).findAllSQL("SELECT * FROM seasons WHERE sport_id = ?","1");
    }
    private Broker getMockedBrokerFactory() { 
        SeasonBroker seasonBroker = mock(SeasonBroker.class); 
        Broker broker = mock(Broker.class); 
        when(broker.getSeasonBroker()).thenReturn(seasonBroker); 
        return broker; 
    } 
    private Broker getMockedBrokerFactoryWithBrokersSetup() { 
        Broker broker = getMockedBrokerFactory();
        SeasonBroker seasonBroker =  broker.getSeasonBroker();
        Season season = mock(Season.class);
        List <Season> seasons = new ArrayList<>();
        seasons.add(season);
        when(seasonBroker.findAllSQL("SELECT * FROM seasons WHERE sport_id = ?","1")).thenReturn(seasons); 
        return broker; 
    } 
}
