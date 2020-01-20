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
        if(args.length == 0) {
            return "Expected at least 1 argument: recieved 0";
        }
        if(args[0].equals("help")) {
            if(args.length == 1) {
                return HelpMessages.BasicHelpMessage;
            } else if(args[1].equals("get")) {
                
            } else if(args[1].equals("post")) {
                
            } else {
                
            }
        }
        return "Nothing";
    }
    
    
    
}
