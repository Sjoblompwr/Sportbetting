/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.javalite.activejdbc.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Dator
 */
public class CommonFunctionsTest {
    
    public CommonFunctionsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getInteger method, of class CommonFunctions.
     */
    @Test
    public void testGetInteger() {
        System.out.println("getInteger");
        Model model = null;
        String arg = "";
        CommonFunctions instance = new CommonFunctions();
        int expResult = 0;
        int result = instance.getInteger(model, arg);
        assertEquals(expResult, result);

    }

    /**
     * Test of excessWhitespaceRemover method, of class CommonFunctions.
     */
    @Test
    public void testExcessWhitespaceRemover() {
        System.out.println("excessWhitespaceRemover");
        String s = "";
        String expResult = "";
        String result = CommonFunctions.excessWhitespaceRemover(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class CommonFunctions.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
         Model modelMock = mock(Model.class);
        
       when(modelMock.getString("name")).thenReturn("Foo bar");
        String name = "";
        Model model = null;
        int id = 0;
        CommonFunctions instance = new CommonFunctions();
        try {
            instance.setName(name, model, id);
        } catch (ExceptionClass ex) {
            System.out.println(ex);
            System.out.println("Input may not only be whitespaces. Expected exception.");
        }
        name = "123";
        
        try {
            instance.setName(name,model,id);
        } catch (ExceptionClass ex) {
            System.out.println(ex);
            System.out.println("Use of invalid characters. Expected exception.");
        }
        
        name = "David";
        
        try {
            instance.setName(name,model,id); //Model is null.
        } catch (ExceptionClass ex) {
            System.out.println(ex);
            System.out.println("Exception not expected, if shown -> test fail.");
        }
        
        
        
        
    }
    
}
