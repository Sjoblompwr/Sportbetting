/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.TeamBroker;
import db.DbConn;
import domain.Team;
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
public class AddNewTeamServiceTest {

    /**
     * Test of execute method, of class AddNewTeamService. Checking the right
     * method is called if the input is accepted.
     */
    @Test
    public void testExecute_behaviour() throws Exception {
        System.out.println("execute_behaviour");
        int sport_id = 1;
        int season_id = 1;
        int team_id = 1;
        String name = "";
        AddNewTeamService service = new AddNewTeamService(sport_id, season_id, team_id, name);
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        service.init(broker);
        assertTrue(service.execute());
        verify(broker.getTeamBroker(), times(1)).create();
    }

    /**
     * Test of execute method, of class AddNewTeamService. Making sure method
     * return false if any Id is below one.
     */
    @Test
    public void testExecute_returnFalseIfIdInputBelowOne() throws Exception {
        System.out.println("execute_returnFalseIfIdInputBelowOne");
        int sport_id = 1;
        int season_id = 1;
        int team_id = 1;
        String name = "";
        AddNewTeamService service = new AddNewTeamService(sport_id, season_id, team_id, name);
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        service.init(broker);
        assertTrue(service.execute());
        assertThrows(IllegalArgumentException.class, () -> {
            service.setId(0, "sport");
        });
        assertThrows(IllegalArgumentException.class, () -> {

            service.setId(0, "season");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            service.setId(0, "team");
        });
    }

    private Broker getMockedBrokerFactory() {
        TeamBroker teamBroker = mock(TeamBroker.class);
        Broker broker = mock(Broker.class);
        when(broker.getTeamBroker()).thenReturn(teamBroker);
        return broker;
    }

    private Broker getMockedBrokerFactoryWithBrokersSetup() {
        Broker broker = getMockedBrokerFactory();
        TeamBroker teamBroker = broker.getTeamBroker();
        Team team = mock(Team.class);
        when(teamBroker.create()).thenReturn(team);
        when(team.insert()).thenReturn(Boolean.TRUE);
        return broker;
    }
}
