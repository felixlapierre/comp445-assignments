/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpc;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Felix
 */
public class CommandLineArgument {
    public Type type;
    public String contents;
    
    public CommandLineArgument(Type type, String contents) {
        this.type = type;
        this.contents = contents;
    }
    
    public static enum Type {
        Method,
        VerboseFlag,
        Header,
        InlineData,
        FileData,
        URL
    }
    
    public static CommandLineArgument[] parseArguments(String[] args) {
        ArrayList<CommandLineArgument> result = new ArrayList<>();
        int i = 0;
        while(i < args.length) {
            String current = args[i];
            switch(current) {
                case "get":
                    result.add(new CommandLineArgument(Type.Method, "get"));
                    break;
                case "post":
                    result.add(new CommandLineArgument(Type.Method, "post"));
                    break;
                case "-v":
                    result.add(new CommandLineArgument(Type.VerboseFlag, "-v"));
                    break;
                case "-h":
                    i++;
                    String header = GetNextArgument(args, i, Type.Header);
                    result.add(new CommandLineArgument(Type.Header, header));
                    break;
                case "-d":
                    i++;
                    String data = GetNextArgument(args, i, Type.InlineData);
                    result.add(new CommandLineArgument(Type.InlineData, data));
                    break;
                case "-f":
                    i++;
                    String filename = GetNextArgument(args, i, Type.FileData);
                    result.add(new CommandLineArgument(Type.FileData, filename));
                    break;
                default:
                    result.add(new CommandLineArgument(Type.URL, args[i]));
                    break;
            }
            i++;
        }
        return result.toArray(new CommandLineArgument[result.size()]);
    }
    
    private static String GetNextArgument(String[] args, int i, Type type) {
        if(i != args.length) {
            return args[i];
        } else {
            throw new InputMismatchException("Error: Flag " + type.name() + " should be followed by a value, not used as the last argument.");
        }
    }
}
