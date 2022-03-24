/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.SportBroker;
import db.DbConn;
import domain.ExceptionClass;
import domain.Sport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author David Sjöblom
 */
public class AddNewSportServiceTest {


    /**
     * Test of execute method, of class AddNewSportService.
     * Checking if the correct method is called in normal programflow.
     */
    @Test
    public void testExecute_behaviour()  {
        System.out.println("execute_behaviour");
        String name = "";
        AddNewSportService service = new AddNewSportService();
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        DbConn dbConn = mock(DbConn.class);
        service.init(dbConn, broker);
        try {
            assertTrue(service.execute(name));
        } catch (ExceptionClass ex) {
            System.out.println(ex + "Exception not expected FAIL");
        }
        verify(broker.getSportBroker(),times(1)).create();
    }
    
    private Broker getMockedBrokerFactory() { 
        SportBroker sportBroker = mock(SportBroker.class); 
        Broker broker = mock(Broker.class); 
        when(broker.getSportBroker()).thenReturn(sportBroker); 
        return broker; 
    } 
    private Broker getMockedBrokerFactoryWithBrokersSetup() { 
        Broker broker = getMockedBrokerFactory();
        SportBroker sportBroker =  broker.getSportBroker();
        Sport sport = mock(Sport.class);
        when(sportBroker.create()).thenReturn(sport); 
        try {
          //  when(sport.setName(name))
            when(sport.insert()).thenReturn(Boolean.TRUE);
        } catch (ExceptionClass ex) {
            System.out.println(ex + "Unexpected exception FAIL");
        }
        return broker; 
    } 
}