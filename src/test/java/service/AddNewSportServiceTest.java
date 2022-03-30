/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.SportBroker;
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
     * Test of execute method, of class AddNewSportService. Checking if the
     * correct method is called in normal programflow.
     */
    @Test
    public void testExecute_behaviour() {
        System.out.println("execute_behaviour");
        String name = "";
        AddNewSportService service = new AddNewSportService(name);
        Broker broker = getMockedBrokerFactoryWithBrokersSetup();
        service.init(broker);
        boolean bool = service.execute();
        assertTrue(bool);
        verify(broker.getSportBroker(), times(1)).create();
    }

    private Broker getMockedBrokerFactory() {
        SportBroker sportBroker = mock(SportBroker.class);
        Broker broker = mock(Broker.class);
        when(broker.getSportBroker()).thenReturn(sportBroker);
        return broker;
    }

    private Broker getMockedBrokerFactoryWithBrokersSetup() {
        Broker broker = getMockedBrokerFactory();
        SportBroker sportBroker = broker.getSportBroker();
        Sport sport = mock(Sport.class);
        when(sportBroker.create()).thenReturn(sport);
        when(sport.insert()).thenReturn(Boolean.TRUE);

        return broker;
    }
}
