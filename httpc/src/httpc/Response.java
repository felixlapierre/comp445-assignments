/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Felix
 */
public class Response {
    public static String create(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();

        int data = inputStream.read();

        while(data != -1) {
            builder.append((char)data);
            data = inputStream.read();
        }
        
        return builder.toString();
    }
}
