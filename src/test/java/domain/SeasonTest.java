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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import records.SeasonRecord;

/**
 *
 * @author Dator
 */
public class SeasonTest {

    public SeasonTest() {
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
     * Test of getId method, of class Season.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        SeasonRecord seasonRecordMock = mock(SeasonRecord.class);
        Season instance = new Season(seasonRecordMock);
        when(seasonRecordMock.getString("id")).thenReturn("1");
        instance.getId();
        verify(seasonRecordMock,times(1)).getString("id");

    }

    /**
     * Test of getYear method, of class Season.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        SeasonRecord seasonRecordMock = mock(SeasonRecord.class);
        Season instance = new Season(seasonRecordMock);
        when(seasonRecordMock.getString("year")).thenReturn("1");
        instance.getYear();
        verify(seasonRecordMock,times(1)).getString("year");
    }

    /**
     * Test of getSportId method, of class Season.
     */
    @Test
    public void testGetSportId() {
        System.out.println("getSportId");
        SeasonRecord seasonRecordMock = mock(SeasonRecord.class);
        Season instance = new Season(seasonRecordMock);
        when(seasonRecordMock.getString("sport_id")).thenReturn("1");
        instance.getSportId();
        verify(seasonRecordMock,times(1)).getString("sport_id");
    }

    /**
     * Test of setYear method, of class Season.
     */
    @Test
    public void testSetYear() throws Exception {
        System.out.println("setYear");
        SeasonRecord seasonRecordMock = mock(SeasonRecord.class);
        Season instance = new Season(seasonRecordMock);
        try{
        instance.setYear(5);
        }catch(Exception e){
            System.out.println(e + "Exception expected.");
        }
        try{
                    instance.setYear(2000);
        }catch(Exception e){
            System.out.println(e + "Exception not expected.");
        }
        
        verify(seasonRecordMock,times(0)).set("year",5);
        verify(seasonRecordMock,times(1)).set("year",2000);
    }

    /**
     * Test of setSportId method, of class Season.
     */
    @Test
    public void testSetSportId() {
        System.out.println("setSportId");
        SeasonRecord seasonRecordMock = mock(SeasonRecord.class);
        Season instance = new Season(seasonRecordMock);
        instance.setSportId(1);
        verify(seasonRecordMock,times(1)).set("sport_id",1);
    }

//    /**
//     * Test of insert method, of class Season.
//     */
//    @Test
//    public void testInsert() throws Exception {
//        System.out.println("insert");
//        Season instance = new Season();
//        boolean expResult = false;
//        boolean result = instance.insert();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class Season.
//     */
//    @Test
//    public void testFindAll() {
//        System.out.println("findAll");
//        List<Season> expResult = null;
//        List<Season> result = Season.findAll();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
