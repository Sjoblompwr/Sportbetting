/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.LeagueBroker;
import Broker.SeasonBroker;
import Broker.TeamBroker;
import db.DbConn;
import domain.League;
import domain.Season;
import domain.Team;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author David Sjöblom
 */
public class GetAllTeamsBySportIdServiceTest {

    /**
     * Testing error handling, if input is invalid.
     */
    @Test
    public void testExecute_ErrorHandlingTest() {
        System.out.println("Error handling execute()");
        int id = 0;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        assertThrows(IllegalArgumentException.class, () -> {
            GetAllTeamsBySportIdService service = new GetAllTeamsBySportIdService(id);
            service.init(broker);
            assertNull(service.execute());
        });
    }

    /**
     * test execute behaviour
     */
    @Test
    public void testExecute_Behaviour() {
        System.out.println("execute_behaviour");
        int id = 1;
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        GetAllTeamsBySportIdService service = new GetAllTeamsBySportIdService(id);
        service.init(broker);
        assertNotNull(service.execute());
    }

    private Broker getMockedBrokerFactory() {
        TeamBroker teamBroker = mock(TeamBroker.class);
        LeagueBroker leagueBroker = mock(LeagueBroker.class);
        SeasonBroker seasonBroker = mock(SeasonBroker.class);
        Broker broker = mock(Broker.class);
        when(broker.getTeamBroker()).thenReturn(teamBroker);
        when(broker.getSeasonBroker()).thenReturn(seasonBroker);
        when(broker.getLeagueBroker()).thenReturn(leagueBroker);
        return broker;
    }

    private Broker getMockedBrokerFactoryWithBrokersSetup() {
        Broker broker = getMockedBrokerFactory();
        Team team = mock(Team.class);
        Season season = mock(Season.class);
        League league = mock(League.class);
        List<League> leagues = new ArrayList<>();
        List<Season> seasons = new ArrayList<>();
        List<Team> teams = new ArrayList<>();
        teams.add(team);
        seasons.add(season);
        leagues.add(league);
        when(broker.getTeamBroker().findAllSQL("SELECT * FROM teams WHERE league_id = ?", "1"))
                .thenReturn(teams);
        when(broker.getSeasonBroker().findAllSQL("SELECT * FROM seasons WHERE sport_id = ?", "1"))
                .thenReturn(seasons);
        when(broker.getLeagueBroker()
                .findAllSQL("SELECT * FROM leagues WHERE season_id = ?", "1"))
                .thenReturn(leagues);
        when(league.getId()).thenReturn(1);
        when(season.getId()).thenReturn(1);
        return broker;
    }
}
