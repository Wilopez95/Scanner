package scanner;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

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
    private Boolean FlagComentarioLinea = false;
    private Boolean FlagComentarioBloque = false;
    private Boolean FlagComentarioBloque2 = false;
    public ArrayList<Nodo> ListaPalabras = new ArrayList<Nodo>();
    
    
    
    /*ExtraerTexto
    *Este metodo recibe el archivo txt que se lee 
    *y extrae todas las palabras para ponerlas en un string
    *returna el string texto que contiene el texto del archivo.
    */
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
    /*SepararTexto
     *Recibe un texto y lo separa en reglones 
     *posteriormente en cada linea lo separa en palabras 
     *se le aplica el analisis de comentarios a cada palabra 
     *para analizar los comentarios se emplean banderas ,
     *si la bandera esta activa entonces el texto esta comentado y se ignora por completo
     */
     
    public void SepararTexto(String texto){
        String[] listaReglones = texto.split("\\r?\\n");
        for (int i = 0; i < listaReglones.length; i++) {
            String[] listaPalabras = listaReglones[i].split(" ");
            FlagComentarioLinea = false;
            for (int j = 0; j < listaPalabras.length; j++) {
                //Pasar todas las palabras a mayusculas
                listaPalabras[j] = listaPalabras[j].toUpperCase();
                //Pasar cada palabra a lista de caracteres
                char[] Tokench = listaPalabras[j].toCharArray();
                if(Tokench.length>1){
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
                }
                if(Tokench[Tokench.length-1] =='}' ){
                    FlagComentarioBloque2 = false;
                     break;
                }
                if(!FlagComentarioLinea ){
                    if (!FlagComentarioBloque){
                        if(!FlagComentarioBloque2){  
                            insertaPalabraEnLista(listaPalabras[j], i);
                        }
                    }
                    
                }
            }
            
        }
        verListaPalabras();
    }
    
    private void insertaPalabraEnLista(String palabra, int reglon){
      
        if(ListaPalabras.isEmpty()){
            Nodo n = new Nodo(reglon, palabra);
            ListaPalabras.add(n);
        }else{
            if(!insertarRepetida(reglon, palabra)){
                Nodo n = new Nodo(reglon, palabra);
                ListaPalabras.add(n);
            }
        }
        
    }
    
    private boolean insertarRepetida(int reglon , String palabra){
        for (int i = 0; i < ListaPalabras.size(); i++) {
                if(ListaPalabras.get(i).getToken().equals(palabra)){ 
                    //System.out.println("ENTRO");
                    ListaPalabras.get(i).TokenRep(reglon);        
                    return true;
                }
            }
        return false;
    }
    
    
    private void verListaPalabras(){
        for (int i = 0; i < ListaPalabras.size(); i++) {
            System.out.println("Linea: "+ListaPalabras.get(i).getReglones()+" , Token: "+ListaPalabras.get(i).getToken()+" Tipo token: "+ListaPalabras.get(i).getTipoToken());
            
        }
    }
    
    
    
    
    
}


