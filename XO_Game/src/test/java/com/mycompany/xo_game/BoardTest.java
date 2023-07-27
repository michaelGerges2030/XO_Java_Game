
package com.mycompany.xo_game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    Board b;
    
    @BeforeEach
    public void beforeEachTest(){
        b = new Board();
    }
    
    @Test
    public void getRow(){
        assertEquals(1, b.getRow(4));
    }
    
    @Test 
    public void getRowWithNeg(){
        assertEquals(-1,b.getRow(-4));
    }
    
    @Test
    public void isEmp(){
        assertEquals(true, b.isEmpty(5));
    }
    
    @Test
    public void repChar(){
        Player p = new Player("Ahmed",'x');
        b.replaceChar(5, p);
        assertEquals(b.arr[1][1],'x');
    }
    
    @Test 
    public void isEmpWithOp(){
        Player p = new Player("Ahmed", 'x');
        b.replaceChar(5, p);
        assertEquals(false, b.isEmpty(5));
    }
}