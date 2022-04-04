/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import domain.Team;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Sjöblom
 */
public class GetAllTeamsByLeagueIdServiceIT {

    /**
     * Test of execute method, of class GetAllTeamsByLeagueIdService.
     * Integration testing with serviceRunner.
     */
    @Test
    public void testExecute() {
        System.out.println("GetAllTeamsByLeagueIdService IT");
        int id = 1;
        GetAllTeamsByLeagueIdService service = null;
        try {
            service = new GetAllTeamsByLeagueIdService(id);
        } catch (Exception e) {
            System.out.println(e + "Exception not expected, "
                    + "might be empty database at league_id:" + id);
            fail();
        }
        ServiceRunner<List<Team>> serviceRunner = new ServiceRunner(service);
        List<Team> result = serviceRunner.execute();
        assertTrue(result.get(0).getName().contains("Lotus")
                && result.get(1).getName().contains("Hockey"));
    }

}
