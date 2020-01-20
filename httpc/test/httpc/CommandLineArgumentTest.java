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
public class CommandLineArgumentTest {
    
    public CommandLineArgumentTest() {
    }

    @Test
    public void testGetVerbose() {
        String[] args = new String[3];
        args[0] = "get";
        args[1] = "-v";
        args[2] = "http://httpbin.org";
        
        CommandLineArgument[] result = CommandLineArgument.parseArguments(args);
        
        assertEquals(result[0].type, CommandLineArgument.Type.Method);
        assertEquals(result[0].contents, args[0]);
        assertEquals(result[1].type, CommandLineArgument.Type.VerboseFlag);
        assertEquals(result[2].type, CommandLineArgument.Type.URL);
        assertEquals(result[2].contents, args[2]);
    }
    
    @Test
    public void testPostInlineData() {
        String[] args = new String[4];
        args[0] = "post";
        args[1] = "-d";
        args[2] = "{\"Assignment\": 1}";
        args[3] = "http://httpbin.org";
        
        CommandLineArgument[] result = CommandLineArgument.parseArguments(args);
        
        assertEquals(result[0].type, CommandLineArgument.Type.Method);
        assertEquals(result[0].contents, args[0]);
        assertEquals(result[1].type, CommandLineArgument.Type.InlineData);
        assertEquals(result[1].contents, args[2]);
        assertEquals(result[2].type, CommandLineArgument.Type.URL);
        assertEquals(result[2].contents, args[3]);
    }
    
    @Test(expected = InputMismatchException.class)
    public void testThrowsExceptionNoInlineData() {
        String[] args = new String[2];
        args[0] = "post";
        args[1] = "-d";
        
        CommandLineArgument.parseArguments(args);        
    }
    
}
