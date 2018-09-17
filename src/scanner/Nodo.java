/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Wilson
 */
public class Nodo {
   

    private List<Integer> Reglones = new ArrayList<Integer>();
    private List<Integer> CantidadRep = new ArrayList<Integer>();
    private String Token;
    private String TipoToken;
    
    public  Nodo(int reglon,String token){
        Reglones.add(reglon);
        this.Token = token;
        this.TipoToken = "UNDEFINED";
    }
     public void TokenRep (int reglon){
         Reglones.add(reglon);
     }


    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getTipoToken() {
        return TipoToken;
    }

    public void setTipoToken(String TipoToken) {
        this.TipoToken = TipoToken;
    }
    public String getReglones(){
        String reglones="";
        for (int i = 0; i <Reglones.size(); i++) {
            reglones=reglones+" "+Reglones.get(i).toString();
        }
        return reglones;
    }
    
    
    
}
