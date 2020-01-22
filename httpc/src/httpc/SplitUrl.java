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
public class SplitUrl {
    private String domain;
    private String path;
    public SplitUrl(String url) {
        boolean passedFirstDot = false;
        int i = 0;
        for(char c : url.toCharArray()) {
            if(c == '.') {
                passedFirstDot = true;
            }
            if(c == '/' && passedFirstDot) {
                domain = url.substring(0, i);
                path = url.substring(i);
                return;
            }
            i++;
        }
        
        domain = url;
        path = "";
    }
    
    public String getDomain() {
        return domain;
    }
    
    public String getPath() {
        return path;
    }
}
