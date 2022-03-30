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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author David Sjöblom
 */
public class GetAllLeaguesBySeasonIdServiceTest {

    /**
     * Test of execute method, of class GetAllLeaguesBySeasonIdService. Checking
     * if method calls correct methods when input is correct.
     */
    @Test
    public void testExecute_behaviour() {
        System.out.println("execute_behaviour");
        int id = 1;
        GetAllLeaguesBySeasonIdService service = new GetAllLeaguesBySeasonIdService(id);
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        service.init(broker);
        assertNotNull(service.execute());
        verify(broker.getLeagueBroker(), times(1)).findAllSQL("SELECT * FROM leagues WHERE season_id = ?", "1");

    }

    /**
     * Test of execute method, of class GetAllLeaguesBySeasonIdService. Checking
     * if method calls correct methods when input is incorrect.
     */
    @Test
    public void testExecute_getNullIfBadInput() {
        System.out.println("execute_getNullIfBadInput");
        int id = 0;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GetAllLeaguesBySeasonIdService service = new GetAllLeaguesBySeasonIdService(id);
            service.init(broker);
            service.execute();
        });
        
        verify(broker.getLeagueBroker(), times(0)).findAllSQL("SELECT * FROM leagues WHERE season_id = ?", "0");

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
        List<League> leagues = new ArrayList<>();
        leagues.add(league);
        when(leagueBroker.findAllSQL("SELECT * FROM leagues WHERE season_id = ?", "1")).thenReturn(leagues);
        return broker;
    }
}
