/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.LeagueBroker;
import db.DbConn;
import domain.League;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 *
 * @author David Sjöblom
 */
public class AddNewLeagueForSeasonTest {

    /**
     * Test of execute method, of class AddNewLeagueForSeason. Check if method
     * acts correctly when input is valid.
     */
    @Test
    public void testExecute_behaviour() throws Exception {
        System.out.println("execute_behaviour");
        int id = 1;
        String name = "";
        AddNewLeagueForSeasonService service = new AddNewLeagueForSeasonService(id,name);
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        service.init(broker);
        assertTrue(service.execute());
        verify(broker.getLeagueBroker(), times(1)).create();
    }

    /**
     * Test of execute method, of class AddNewLeagueForSeason. Making sure
     * method return false if id input is invalid.
     */
    @Test
    public void testExecute_errorHandling() throws Exception {
        System.out.println("execute_errorHandling");
        int id = 0;
        String name = "";
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        assertThrows(IllegalArgumentException.class, () -> {
            AddNewLeagueForSeasonService service = new AddNewLeagueForSeasonService(id,name);
            service.init(broker);
            assertFalse(service.execute());
        });

        verify(broker.getLeagueBroker(), times(0)).create();
    }

    private Broker getMockedBrokerFactory() {
        LeagueBroker leagueBroker = mock(LeagueBroker.class);
        Broker broker = mock(Broker.class);
        when(broker.getLeagueBroker()).thenReturn(leagueBroker);
        return broker;
    }

    private Broker getMockedBrokerFactoryWithBrokersSetup() {
        Broker broker = getMockedBrokerFactory();
        LeagueBroker leagueBroker = broker.getLeagueBroker();
        League league = mock(League.class);
        when(broker.getLeagueBroker().create()).thenReturn(league);
        when(league.insert()).thenReturn(Boolean.TRUE);
        return broker;
    }
}
