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
public class GetAllTeamsBySportIdServiceIT {

    /**
     * Test of execute method, of class GetAllTeamsBySportIdService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        GetAllTeamsBySportIdService instance = null;
        List<Team> expResult = null;
        List<Team> result = instance.execute();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
