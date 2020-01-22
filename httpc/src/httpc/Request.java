/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

/**
 *
 * @author Felix
 */
public class Request {
    public static String create(Options options) {
        StringBuilder builder = new StringBuilder();

        builder.append(options.method.toUpperCase())
            .append(' ')
            .append(new SplitUrl(options.url).getPath())
            .append(' ')
            .append("HTTP/1.0\r\n");

        for(String s : options.getHeaders()) {
            builder.append(s).append("\r\n");
        }

        if(options.method == "post" && options.inlineData != null) {
            String body = options.inlineData;
            builder.append("Content-Length: ")
                .append(body.length())
                .append("\r\n")
                .append("\r\n")
                .append(body);
        } else {
            builder.append("\r\n");
        }
        
        return builder.toString();
    }
}
