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
public class GetAllLeaguesBySportIdServiceIT {

    /**
     * Test of execute method, of class GetAllLeaguesBySportIdService. IT with
     * ServiceRunner
     */
    @Test
    public void testExecute() {
        System.out.println("GetAllLeaguesBySport IT");
        int id = 1;
        GetAllLeaguesBySportIdService service = null;
        try {
            service = new GetAllLeaguesBySportIdService(id);
        } catch (Exception e) {
            fail(e + "id: " + id + " might not exist or not allowed");
        }
        ServiceRunner<List<League>> serviceRunner = new ServiceRunner(service);
        List<League> result = serviceRunner.execute();
        assertTrue(result.get(0).getName().contains("Knatteligan"));

    }

}
