/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import domain.League;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Sjöblom
 */
public class GetAllLeaguesBySeasonIdServiceIT {

    /**
     * Test of execute method, of class GetAllLeaguesBySeasonIdService. 
     * IT with serviceRunner.
     */
    @Test
    public void testExecute() {
        System.out.println("GetAllLeaguesBySeasonId IT");
        int id = 1;
        GetAllLeaguesBySeasonIdService service = null;
        try {
            service = new GetAllLeaguesBySeasonIdService(id);
        } catch (Exception e) {
            fail(e + "id:" + id + " might not be allowed otherwise not exist.");
        }
        ServiceRunner<List<League>> serviceRunner = new ServiceRunner(service);
        List<League> result = serviceRunner.execute();
        assertTrue(result.get(0).getName().contains("Knatteligan"));
    }

}
