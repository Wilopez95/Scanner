package scanner;

import java.io.File;
import java.io.FileInputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wilson
 */
public class FileParser {
    FileInputStream entrada;
    File archivo;
    Boolean FlagComentarioLinea = false;
    Boolean FlagComentarioBloque = false;
    Boolean FlagComentarioBloque2 = false;
    int numerolinea;
    
    
    
    
    public String ExtraerTexto(File archivo){
    String texto="";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read())!= -1){
                char caracter = (char)ascci;
                texto = texto+caracter;
                
            }
        } catch (Exception e) {
        }
    return texto;
}
    
    public void SepararTexto(String texto){
        String[] listaReglones = texto.split("\\r?\\n");
        for (int i = 0; i < listaReglones.length; i++) {
            String[] listaPalabras = listaReglones[i].split(" ");
            FlagComentarioLinea = false;
            for (int j = 0; j < listaPalabras.length; j++) {
                char[] Tokench = listaPalabras[j].toCharArray();
                if(Tokench.length>1){
                //System.out.println("Palabra "+listaPalabras[j] + " Token " + Tokench[0]+Tokench[1]);
                if(Tokench[0] == '/' && Tokench[1] == '/'){
                    this.FlagComentarioLinea = true;
                }else if(Tokench[0] == '(' && Tokench[1] == '*'){
                    FlagComentarioBloque = true;  
                }else if(Tokench[0] == '{'){
                     FlagComentarioBloque2 = true;
                }else if(Tokench[Tokench.length-1] == ')' && Tokench[Tokench.length-2] == '*'){
                     FlagComentarioBloque = false;
                     break;
                }
                //System.out.println("TEST "+Tokench[Tokench.length-1]);
                if(!FlagComentarioLinea ){
                    if (!FlagComentarioBloque){
                        System.out.println("Numero reglon "+i+" Palabra: "+listaPalabras[j]);
                    }
                    
                }   
                }
            }
            //System.out.println("Lista: "+listaReglones[i]);
        }
    }
    
    
    
    
    
}


