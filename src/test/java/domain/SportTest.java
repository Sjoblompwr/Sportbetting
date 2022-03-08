/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import records.SportRecord;

/**
 *
 * @author Dator
 */
public class SportTest {

    public SportTest() {
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
     * Test of getSportName method, of class Sport.
     */
    @Test
    public void testGetName() {
        SportRecord sportRecordMock = mock(SportRecord.class);
        Sport instance = new Sport(sportRecordMock);
        when(sportRecordMock.getString("name")).thenReturn("1");
        instance.getName();

        verify(sportRecordMock, times(1)).getString("name");
    }




    /**
     * Test of getId method, of class Sport.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        SportRecord sportRecordMock = mock(SportRecord.class);
        Sport instance = new Sport(sportRecordMock);
        when(sportRecordMock.getString("id")).thenReturn("1");
        instance.getId();

        verify(sportRecordMock, times(1)).getString("id");
    }

//
//    /**
//     * Test of setName method, of class Sport.
//     */
//    @Test
//    public void testSetName() throws Exception {
//        System.out.println("setName");
//        String name = "";
//        Sport instance = new Sport();
//        instance.setName(name);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class Sport.
//     */
//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//        List<Sport> expResult = null;
//        List<Sport> result = Sport.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findById method, of class Sport.
//     */
//    @Test
//    public void testFindById() {
//        System.out.println("findById");
//        int x = 0;
//        Sport expResult = null;
//        Sport result = Sport.findById(x);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

 
}
