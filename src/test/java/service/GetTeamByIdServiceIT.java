/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import domain.ExceptionClass;
import domain.Team;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David Sjöblom
 */
public class GetTeamByIdServiceIT {
    

    /**
     * Integration test, of class GetTeamByIdService.
     */
    @Test
    public void testExecute() {
        System.out.println("ServiceRunnerIT with GetTeamByIdService");
        int id = 1;
        GetTeamByIdService instance = null;
        try {
            instance = new GetTeamByIdService(id);
        } catch (ExceptionClass ex) {
            System.out.println("If id error is thrown, make sure id is <1.");
        }
        ServiceRunner serviceRunner = new ServiceRunner(instance);
        Team team = (Team) serviceRunner.execute();
        assertTrue(team.getName().contains("Ducks"));
    }
    
}
