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
     * Integration test with class GetAllTeamsBySportIdService.
     * *Note output is sorted firstly based on seasons, then leagues and lastly
     * teams. So expect team with "low leagues" to be first in list.
     */
    @Test
    public void testExecute() {
        System.out.println("GetAllTeamsBySportIdService IT");
        int id = 1;
        GetAllTeamsBySportIdService instance = null;
        try{
           instance = new GetAllTeamsBySportIdService(id);
        }catch(Exception e){
            System.out.println(e + "Exception not expected test fail.");
            fail("Test fail.");
        }
        List<Team> result = (List<Team>) new ServiceRunner(instance).execute();
        assertTrue(result.get(0).getName().contains("Lotus") && 
                    result.get(1).getName().contains("Hockey") &&
                    result.get(2).getName().contains("Pelikans"));
        }

}
