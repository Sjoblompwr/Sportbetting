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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.verification.VerificationMode;

/**
 *
 * @author David Sjöblom
 */
public class AddNewSportServiceTest_ {


    /**
     * Test of init method, of class AddNewSportService.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        DbConn dbConn = null;
        Broker broker = null;
        AddNewSportService instance = new AddNewSportService();
        instance.init(dbConn, broker);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of execute method, of class AddNewSportService.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        String name = "";
        AddNewSportService service = new AddNewSportService();
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        DbConn dbConn = mock(DbConn.class);
        service.init(dbConn, broker);
        service.execute(name);
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
            when(sport.insert()).thenReturn(Boolean.TRUE);
        } catch (ExceptionClass ex) {
            System.out.println(ex + "Unexpected exception FAIL");
        }
        return broker; 
    } 

    private void verify(SportBroker sportBroker, VerificationMode times) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
