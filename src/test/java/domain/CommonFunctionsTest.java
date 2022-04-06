/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

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
public class CommonFunctionsTest {


    /**
     * Test of getInteger method, of class CommonFunctions.
     */
    @Test
    public void testGetInteger() {
        System.out.println("getInteger");
        mockRecord modelMock = mock(mockRecord.class);
        when(modelMock.getString("id")).thenReturn("0");
        String arg = "id";
        CommonFunctions instance = new CommonFunctions();
        int expResult = 0;
        int result = instance.getInteger(modelMock, arg);
        assertEquals(expResult, result);
        verify(modelMock,times(1)).getString("id");
    }

    /**
     * Test of excessWhitespaceRemover method, of class CommonFunctions.
     */
    @Test
    public void testExcessWhitespaceRemover() {
        System.out.println("excessWhitespaceRemover");
        String string = "";
        String expResult = "";
        String result = CommonFunctions.excessWhitespaceRemover(string);
        assertEquals(expResult, result);
        
        expResult = "foo bar";
        string = "  foo     bar   ";
        result = CommonFunctions.excessWhitespaceRemover(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class CommonFunctions.
     */
    @Test
    public void testSetName() throws ExceptionClass {
        System.out.println("setName");
         mockRecord modelMock = mock(mockRecord.class);
        
        String name = "";
        int id = 0;
        CommonFunctions instance = new CommonFunctions();

        try {
            instance.setName(name, modelMock, id);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            System.out.println("Input may not only be whitespaces. Expected exception.");
        }
        name = "123";
        
        try {
            instance.setName(name,modelMock,id);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            System.out.println("Use of invalid characters. Expected exception.");
        }
        
        name = "Dav1d        ";
        
        try {
            instance.setName(name,modelMock,id); 
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            System.out.println("Use of invalid characters. Expected exception.");
        }
        
        name = "David        ";
        
        try {
            instance.setName(name,modelMock,id); 
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            System.out.println("Exception not expected, if shown -> test fail.");
        }
        
        verify(modelMock,times(1)).set("name","David");
        verify(modelMock,times(1)).set("id",0);
        
        
        
        
    }
    
    @Test
    public void testSetInteger(){
        System.out.println("setInteger");
        mockRecord modelMock = mock(mockRecord.class);
        String arg = "id";
        CommonFunctions instance = new CommonFunctions();
        instance.setInteger(modelMock, arg,5);
        verify(modelMock,times(1)).set("id",5);
    }
    
}
