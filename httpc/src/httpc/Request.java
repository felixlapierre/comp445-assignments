/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Felix
 */
public class Request {

    public static String create(Options options) throws IOException {
        StringBuilder builder = new StringBuilder();

        builder.append(options.method.toUpperCase())
                .append(' ')
                .append(new SplitUrl(options.url).getPath())
                .append(' ')
                .append("HTTP/1.0\r\n");

        for (String s : options.getHeaders()) {
            builder.append(s).append("\r\n");
        }

        if (options.method.equals("post")) {
            if (options.inlineData != null) {
                String body = options.inlineData;
                builder.append("Content-Length: ")
                        .append(body.length())
                        .append("\r\n")
                        .append("\r\n")
                        .append(body);
            } else if (options.fileName != null) {
                String body = loadFile(options.fileName);
                builder.append("Content-Length: ")
                        .append(body.length())
                        .append("\r\n")
                        .append("\r\n")
                        .append(body);
            }
        } else {
            builder.append("\r\n");
        }

        return builder.toString();
    }

    public static String loadFile(String filename) throws IOException {
        FileInputStream input = new FileInputStream(filename);
        StringBuilder builder = new StringBuilder();

        int data = input.read();

        while (data != -1) {
            builder.append((char)data);
            data = input.read();
        }
        
        return builder.toString();
    }
}
