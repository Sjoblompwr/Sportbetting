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
    public void testGetSportName() {
        System.out.println("getSportName");
        SportRecord sportRecordMock = mock(SportRecord.class);
        when(sportRecordMock.getString("name")).thenReturn(""); // kan chaina å skriva thenreturn . thenreturn, exakt hur de funkar får man prova
        
        Sport instance = new Sport(sportRecordMock);
        String expResult = "";
        String result = instance.getSportName();
        result = instance.getSportName();
        assertEquals(expResult, result);
        
        verify(sportRecordMock,times(2)).getString("name"); //Kontrollerar "beteendet" exakt hur många gånger vi kallar på just getString med parameratn
                                                            //name.
        // TODO review the generated test code and remove the default call to fail.

    }
    /**
     * Exempel på TDD, att just göra testet, inse att jag ej har metoden
     * Samt att metoden måste implementeras för att testet skall klaras.
     */
    @Test
    public void testSave(){
         SportRecord sportRecordMock = mock(SportRecord.class);
         Sport instance = new Sport(sportRecordMock);
         instance.save();
          verify(sportRecordMock,times(1)).save();
    }
    
    
}
