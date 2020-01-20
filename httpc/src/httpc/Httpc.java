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
public class Httpc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Httpc command = new Httpc();
        String result = command.execute(args);
        System.out.println(result);
    }
    
    public String execute(String[] args) {
        try {
            ValidateArguments(args);
            if(IsHelpCommand(args)) {
                return HelpMessages.GenerateHelpMessage(args);
            }
            
            CommandLineArgument[] arguments = CommandLineArgument.parseArguments(args);
            
            
        } catch(Exception e) {
            return e.getMessage();
        }
        return "An unknown error occurred";
    }
    
    public void ValidateArguments(String[] args) {
        if(args.length == 0) {
            throw new InputMismatchException("Expected at least 1 argument: recieved 0");
        }
        
        if(args[0] == "help") {
            if(args.length > 1
                && args[1] != "get"
                && args[1] != "post") {
                throw new InputMismatchException("Error: help must be followed by 'get', 'post', or nothing.");
            }
        } else if(args[0] != "get" && args[0] != "post") {
            throw new InputMismatchException("Error: first argument must be either 'help', 'get', or 'post'");
        }
    }
    
    public boolean IsHelpCommand(String[] args) {
        return args[0].equals("help");
    }
}
