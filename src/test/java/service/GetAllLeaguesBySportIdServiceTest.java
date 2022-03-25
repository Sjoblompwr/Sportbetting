/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.LeagueBroker;
import Broker.SeasonBroker;
import db.DbConn;
import domain.League;
import domain.Season;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Dator
 */
public class GetAllLeaguesBySportIdServiceTest {
    

    /**
     * Test of execute method, of class GetAllLeaguesBySportIdService.
     * Check if correct method is called.
     * This service doesn't do any communication with the db itself.
     */
    @Test
    public void testExecute_behaviour() {
        System.out.println("execute_behaviour");
        int id = 1;
        GetAllLeaguesBySportIdService service = new GetAllLeaguesBySportIdService();
        DbConn dbConn = mock(DbConn.class);
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        service.init(dbConn, broker);
        assertNotNull(service.execute(id));
    }
    private Broker getMockedBrokerFactory() { 
        LeagueBroker leagueBroker = mock(LeagueBroker.class);
        SeasonBroker seasonBroker = mock(SeasonBroker.class);
        Broker broker = mock(Broker.class); 
        when(broker.getLeagueBroker()).thenReturn(leagueBroker); 
        when(broker.getSeasonBroker()).thenReturn(seasonBroker);
        return broker; 
    } 
    private Broker getMockedBrokerFactoryWithBrokersSetup() { 
        Broker broker = getMockedBrokerFactory();
        LeagueBroker leagueBroker =  broker.getLeagueBroker();
        SeasonBroker seasonBroker = broker.getSeasonBroker();
        League league = mock(League.class);
        Season season = mock(Season.class);
        List <League> leagues = new ArrayList<>();
        List <Season> seasons = new ArrayList<>();
        seasons.add(season);
        leagues.add(league);
        when(season.getId()).thenReturn(1);
        when(leagueBroker.findAllSQL("SELECT * FROM leagues WHERE season_id = ?","1")).thenReturn(leagues); 
        when(seasonBroker.findAllSQL("SELECT * FROM seasons WHERE sport_id = ?","1")).thenReturn(seasons);
        return broker; 
    } 
}
