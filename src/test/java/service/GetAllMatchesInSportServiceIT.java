/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import domain.Match;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Sjöblom
 */
public class GetAllMatchesInSportServiceIT {

    /**
     * Test of execute method, of class GetAllMatchesInSportService. IT with
     * ServiceRunner
     */
    @Test
    public void testExecute() {
        System.out.println("GetAllMatchesInSportService IT");
        int id = 1;
        GetAllMatchesInSportService service = null;
        try {
            service = new GetAllMatchesInSportService(id);
        } catch (Exception e) {
            System.out.println(e + "Exception not expected id:" + id + " might"
                    + "not exist or id is not allowed");
            fail();
        }
        ServiceRunner<List<Match>> serviceRunner = new ServiceRunner(service);
        List<Match> result = serviceRunner.execute();
        assertTrue(result.get(0).getTeamOneId() == 1
                && result.get(0).getTeamTwoId() == 2);
    }

}
