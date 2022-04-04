/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import domain.Season;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dator
 */
public class GetAllSeasonsBySportIdServiceIT {

    /**
     * Test of execute method, of class GetAllSeasonsBySportIdService.
     * Integration testing with ServiceRunner
     */
    @Test
    public void testExecute() {
        System.out.println("GetAllSeasonsBySportIdIT");
        int id = 1;
        GetAllSeasonsBySportIdService service = null;
        try {
            service = new GetAllSeasonsBySportIdService(id);
        } catch (Exception e) {
            System.out.println(e + "Might not be connected to same db, or it has "
                    + "changed");
            fail();
        }
        ServiceRunner<List<Season>> serviceRunner = new ServiceRunner(service);
        List<Season> result = serviceRunner.execute();
        assertTrue(result.get(0).getSportId() == 1
                && result.get(0).getYear().contains("2000"));
    }
    
}
