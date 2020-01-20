/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felix
 */
public class HttpcTest {
    
    public HttpcTest() {
    }

    @Test
    public void testGeneralHelp() {
        Httpc command = new Httpc();
        String[] args = new String[1];
        args[0] = "help";
        String response = command.execute(args);
        assertEquals(HelpMessages.BasicHelpMessage, response);
    }
    
    @Test
    public void testGetUsageHelp() {
        Httpc command = new Httpc();
        String[] args = new String[2];
        args[0] = "help";
        args[1] = "get";
        String response = command.execute(args);
        assertEquals(HelpMessages.GetUsageHelpMessage, response);
    }
    
    @Test
    public void testPostUsageHelp() {
        Httpc command = new Httpc();
        String[] args = new String[2];
        args[0] ="help";
        args[1] = "post";
        String response = command.execute(args);
        assertEquals(HelpMessages.PostUsageHelpMessage, response);
    }
    
    @Test
    public void testGetWithQueryParams() {
        Httpc command = new Httpc();
        String[] args = new String[2];
        args[0] = "get";
        args[1] = "'http://httpbin.org/get?course=networking&assignment=1'";
        String response = command.execute(args);
        assertTrue(response.contains("\"assignment\": \"1\","));
        assertTrue(response.contains("\"course\": \"networking\","));
    }
    
}
