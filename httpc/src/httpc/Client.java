/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Felix
 */
public class Client {
    private Options options;
    public Client(Options options) {
        this.options = options;
    }
    
    public String sendRequest() {
        SplitUrl url = new SplitUrl(options.url);
        
        try {
            Socket socket = new Socket(url.getDomain(), 80);
            
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            
            String request = Request.create(options);
            
            outputStream.write(request.getBytes());
            outputStream.flush();
            
            String response = Response.create(inputStream);
            
            if(!options.verbose) {
                String delimiter = "\r\n\r\n";
                int i = response.indexOf(delimiter);
                response = response.substring(i + delimiter.length());
            }
            
            socket.close();
            
            return response;
        } catch(Exception e) {
            return e.getClass() + ":" + e.getMessage();
        }
    }
}
