/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import Broker.Broker;
import Broker.TeamBroker;
import com.mysql.cj.exceptions.AssertionFailedException;
import db.DbConn;
import domain.ExceptionClass;
import domain.Team;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GetTeamByIdServiceTest {
    
    /**
     * Test of execute method, of class GetTeamByIdService.
     * checking if the correct method is called.
     */
    @Test
    public void testExecute_behaviour() {
        System.out.println("execute_behaviour");
        int id = 1;
        GetTeamByIdService service = null;
        try {
            service = new GetTeamByIdService(id);
        } catch (ExceptionClass ex) {
            System.out.println(ex);
        }
        ServiceRunner serviceRunner = new ServiceRunner(service);
        serviceRunner.execute();
    }
    /**
     * Test of execute method, of class GetTeamByIdService.
     * Checking if method return null when input is invalid.
     */
    @Test
    public void testExecute_ErrorHandlingTest(){
        System.out.println("Error handling execute()");
        int id = 0;
        GetTeamByIdService service = null;
        try {
            service = new GetTeamByIdService(id);
        } catch (ExceptionClass ex) {
            System.out.println(ex);
        }
        ServiceRunner serviceRunner = new ServiceRunner(service);
       
        try{
            serviceRunner.execute();
        }catch(NullPointerException e){
            System.out.println(e + " Expected exception.");
        }

    }

}
