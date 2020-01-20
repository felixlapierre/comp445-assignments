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
            ValidateAtLeastOneArgument(args);
            if(IsHelpCommand(args)) {
                return HelpMessages.GenerateHelpMessage(args);
            }
        } catch(Exception e) {
            return e.getMessage();
        }
        return "An unknown error occurred";
    }
    
    public void ValidateAtLeastOneArgument(String[] args) {
        if(args.length == 0) {
            throw new InputMismatchException("Expected at least 1 argument: recieved 0");
        }
    }
    
    public boolean IsHelpCommand(String[] args) {
        return args[0].equals("help");
    }
}
