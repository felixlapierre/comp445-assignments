/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

import java.util.InputMismatchException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felix
 */
public class OptionsParserTest {
    
    public OptionsParserTest() {
    }

    @Test
    public void testGetVerbose() {
        String[] args = new String[3];
        args[0] = "get";
        args[1] = "-v";
        args[2] = "http://httpbin.org";
        
        Options options = OptionsParser.parse(args);
        
        assertEquals(args[0], options.method);
        assertEquals(true, options.verbose);
        assertEquals(args[2], options.url);
    }
    
    @Test
    public void testPostInlineData() {
        String[] args = new String[4];
        args[0] = "post";
        args[1] = "-d";
        args[2] = "\'{\"Assignment\": 1}\'";
        args[3] = "http://httpbin.org";
        
        Options options = OptionsParser.parse(args);
        
        assertEquals(args[0], options.method);
        assertEquals("{\"Assignment\": 1}", options.inlineData);
        assertEquals(args[3], options.url);
    }
    
    @Test(expected = InputMismatchException.class)
    public void testThrowsExceptionNoInlineData() {
        String[] args = new String[2];
        args[0] = "post";
        args[1] = "-d";
        
        OptionsParser.parse(args);     
    }
    
}
