/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Felix
 */
public class Options {
    public String method;
    public boolean verbose = false;
    private List<String> headers;
    public String inlineData;
    public String fileName;
    public String url;
    
    public Options() {
        headers = new LinkedList<>();
    }
    
    public void addHeader(String header) {
        headers.add(header);
    }
    
    public Iterable<String> getHeaders() {
        return headers;
    }
}
