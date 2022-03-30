/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.LeagueBroker;
import Broker.MatchBroker;
import Broker.SeasonBroker;
import db.DbConn;
import domain.League;
import domain.Match;
import domain.Season;
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
public class GetAllMatchesInSportServiceTest {

    /**
     * Test of execute method, of class GetAllMatchesInSportService. Making sure
     * execute goes all the way through with normal input.
     */
    @Test
    public void testExecute_behaviour() {
        System.out.println("execute_behaviour");
        int id = 1;
        GetAllMatchesInSportService service = new GetAllMatchesInSportService(id);
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        service.init(broker);
        service.execute();
        verify(broker.getMatchBroker(), times(1))
                .findAllSQL("SELECT * FROM matches WHERE league_id = ?", "0");
    }

    /**
     * Test of execute method, of class GetAllMatchesInSportService. Checking if
     * null is returned when input id is invalid.
     */
    @Test
    public void testExecute_errorHandling() {
        System.out.println("execute_errorHandling");
        int id = 0;

        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        assertThrows(IllegalArgumentException.class, () -> {
            GetAllMatchesInSportService service = new GetAllMatchesInSportService(id);
            service.init(broker);
            assertNull(service.execute());
        });

        verify(broker.getMatchBroker(), times(0)).findAllSQL("SELECT * FROM matches WHERE league_id = ?",
                "0");
    }

    private Broker getMockedBrokerFactory() {
        MatchBroker matchBroker = mock(MatchBroker.class);
        SeasonBroker seasonBroker = mock(SeasonBroker.class);
        LeagueBroker leagueBroker = mock(LeagueBroker.class);
        Broker broker = mock(Broker.class);
        when(broker.getMatchBroker()).thenReturn(matchBroker);
        when(broker.getSeasonBroker()).thenReturn(seasonBroker);
        when(broker.getLeagueBroker()).thenReturn(leagueBroker);
        return broker;
    }

    private Broker getMockedBrokerFactoryWithBrokersSetup() {
        Broker broker = getMockedBrokerFactory();
        MatchBroker matchBroker = broker.getMatchBroker();
        Match match = mock(Match.class);
        List<Match> matches = new ArrayList<>();
        matches.add(match);
        when(matchBroker.findAllSQL("SELECT * FROM matches WHERE league_id = ?",
                "1")).thenReturn(matches);

        SeasonBroker seasonBroker = broker.getSeasonBroker();
        Season season = mock(Season.class);
        season.setId(1);
        List<Season> seasons = new ArrayList<>();
        seasons.add(season);
        when(season.getId()).thenReturn(1);
        when(seasonBroker.findAllSQL("SELECT * FROM seasons WHERE sport_id = ?", "1"))
                .thenReturn(seasons);

        LeagueBroker leagueBroker = broker.getLeagueBroker();
        League league = mock(League.class);
        List<League> leagues = new ArrayList<>();
        leagues.add(league);
        when(leagueBroker.findAllSQL("SELECT * FROM leagues WHERE season_id = ?", "1"))
                .thenReturn(leagues);
        return broker;
    }
}
