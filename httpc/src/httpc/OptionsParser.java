/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

import java.util.InputMismatchException;

/**
 *
 * @author Felix
 */
public class OptionsParser {
    public static Options parse(String[] args) {
        Options options = new Options();
        int i = 0;
        while(i < args.length) {
            String current = args[i];
            switch(current) {
                case "get":
                    validateGet(options);
                    options.method = "get";
                    break;
                case "post":
                    validatePost(options);
                    options.method = "post";
                    break;
                case "-v":
                    options.verbose = true;
                    break;
                case "-h":
                    i++;
                    String header = GetNextArgument(args, i);
                    options.addHeader(header);
                    break;
                case "-d":
                    validateInlineData(options);
                    i++;
                    String data = GetNextArgument(args, i);
                    options.inlineData = data;
                    break;
                case "-f":
                    validateFilename(options);
                    i++;
                    String filename = GetNextArgument(args, i);
                    options.fileName = filename;
                    break;
                default:
                    validateUrl(options);
                    options.url = args[i];
                    break;
            }
            i++;
        }
        
        return options;
    }
    
    private static String GetNextArgument(String[] args, int i) {
        if(i != args.length) {
            return args[i];
        } else {
            throw new InputMismatchException("Error: Flag should be followed by a value, not used as the last argument.");
        }
    }

    private static void validateGet(Options options) {
        if(options.method == "post")
            throw new InputMismatchException("Method was defined as both POST and GET");
        if(options.method == "get")
            throw new InputMismatchException("Method was defined as GET twice");
    }

    private static void validatePost(Options options) {
        if(options.method == "post")
            throw new InputMismatchException("Method was defined as POST twice");
        if(options.method == "get")
            throw new InputMismatchException("Method was defined as both GET and POST");
    }

    private static void validateInlineData(Options options) {
        if(options.method == "get")
            throw new InputMismatchException("Inline data (-d) can be added to POST requests, not GET requests.");
    }

    private static void validateFilename(Options options) {
        if(options.method == "get")
            throw new InputMismatchException("File data (-f) can be added to POST requests, not GET requests.");
    }

    private static void validateUrl(Options options) {
        if(options.url != null)
            throw new InputMismatchException("Only one URL can be entered");
    }
}
