/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

import java.util.StringTokenizer;


/**
 *
 * @author Wilson
 */
public class Scanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainWindows  mw = new MainWindows();
        mw.show();
        
    /*String line = System.getProperty("line.separator"); 
    String demo = "Hola morocha me gusta la melcocha\n" +
    "Tambien el arroz y los frijoles "; 
    System.out.println("Original: " + demo); 
    System.out.println("Sin saltos: " + demo.replace("\n", " ")); //reemplaza el salto de line por nada, es decir lo elimina 
    StringTokenizer tokenizer = new StringTokenizer(demo, line); //creo un tokenize con la cadena y como delimitador el salto de linea 
    System.out.println("Hay " + tokenizer.countTokens() + " cadenas entre saltos de linea ");	//numero de cadenas 
         
    
    
    String[] lista = demo.split("((?<=\\s)(?!\\s))|((?<!\\s)(?=\\s))");
        for (int i = 0; i < lista.length; i++) {
            if(lista[i].equals("\n")){
                System.out.println("yes "+lista[i]);
            }else{
               System.out.println("no "+lista[i]); 
            }
        }*/
    
    }
    
}
