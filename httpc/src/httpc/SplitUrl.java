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
        int start = url.indexOf("://");
        start += start == -1 ? 1 : 3;
        
        boolean passedFirstDot = false;
        for(int i = start; i < url.length(); i++) {
            char c = url.charAt(i);
            if(c == '.') {
                passedFirstDot = true;
            }
            if(c == '/' && passedFirstDot) {
                domain = url.substring(start, i);
                path = url.substring(i);
                return;
            }
        }
        
        domain = url.substring(start);
        path = "";
    }
    
    public String getDomain() {
        return domain;
    }
    
    public String getPath() {
        return path;
    }
}
