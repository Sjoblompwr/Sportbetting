/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package domain;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import records.LeagueRecord;

/**
 *
 * @author Dator
 */
public class LeagueTest {

    public LeagueTest() {
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
     * Test of getLeagueID method, of class League.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        LeagueRecord leagueRecordMock = mock(LeagueRecord.class);
        League instance = new League(leagueRecordMock);
        when(leagueRecordMock.getString("id")).thenReturn("1");
        instance.getId();
        verify(leagueRecordMock, times(1)).getString("id");
    }
    @Test
    public void testGetName() {
        System.out.println("getName");
        LeagueRecord leagueRecordMock = mock(LeagueRecord.class);
        when(leagueRecordMock.getString("name")).thenReturn("Hockey");
        League instance = new League(leagueRecordMock);
        instance.getName();
        verify(leagueRecordMock, times(1)).getString("name");
    }

/**
 * SetName can't be tested since it uses a static call. But functionallity is tested
 * in the CommonFunctionsTest.
 */


 

    /**
     * Test of getSeasonId method, of class League.
     */
    @Test
    public void testGetSeasonId() {
        System.out.println("getSeasonId");
        LeagueRecord leagueRecordMock = mock(LeagueRecord.class);
        League instance = new League(leagueRecordMock);
        when(leagueRecordMock.getString("season_id")).thenReturn("5");
        instance.getSeasonId();
        verify(leagueRecordMock,times (1)).getString("season_id");
    }
    
    @Test
    public void testSetSeasonId(){
        System.out.println("setSeasonId");
        LeagueRecord leagueRecordMock = mock(LeagueRecord.class);
        League instance = new League(leagueRecordMock);
        instance.setSeasonId(0);
        verify(leagueRecordMock,times(1)).set("season_id",0);
    }
    
//   @Test
//   public void testInsert(){
//        System.out.println("insert");
//        LeagueRecord leagueRecordMock = mock(LeagueRecord.class);
//        League instance = new League(leagueRecordMock);
//        when(leagueRecordMock.insert()).thenReturn(Boolean.TRUE);
//        when(instance.findAll()).thenReturn(null);
//        instance.insert();
//   }
}
