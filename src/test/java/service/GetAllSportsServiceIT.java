/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import domain.Sport;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Sjöblom
 */
public class GetAllSportsServiceIT {

    /**
     * Test of execute method, of class GetAllSportsService.
     * Integration testing with ServiceRunner.
     */
    @Test
    public void testExecute() {
        System.out.println("GetAllSportsService IT");
        GetAllSportsService service = new GetAllSportsService();
        ServiceRunner<List<Sport>> serviceRunner = new ServiceRunner(service);
        
        List<Sport> result = serviceRunner.execute();
        assertTrue(result.get(0).getName().contains("Hockey") &&
                result.get(1).getName().contains("Fotboll"));
    }
    
}
