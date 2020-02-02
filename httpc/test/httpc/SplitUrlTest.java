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
public class SplitUrlTest {
    
    public SplitUrlTest() {
    }
    
    @Test
    public void testSplitUrlNoPath() {
        String url = "http://httpbin.org";
        SplitUrl split = new SplitUrl(url);
        
        assertEquals("httpbin.org", split.getDomain());
        assertEquals("", split.getPath());
    }
    
    @Test
    public void testSplitUrlRootPath() {
        String url = "http://httpbin.org/";
        SplitUrl split = new SplitUrl(url);
        
        assertEquals("httpbin.org", split.getDomain());
        assertEquals("/", split.getPath());
    }

    @Test
    public void testSplitUrlGet() {
        String url = "http://httpbin.org/get";
        SplitUrl split = new SplitUrl(url);
        
        assertEquals("httpbin.org", split.getDomain());
        assertEquals("/get", split.getPath());
    }
    
    @Test
    public void testSplitUrlNoProtocol() {
        String url = "httpbin.org/get";
        SplitUrl split = new SplitUrl(url);
        
        assertEquals("httpbin.org", split.getDomain());
        assertEquals("/get", split.getPath());
    }
    
}
