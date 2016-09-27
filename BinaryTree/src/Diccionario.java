/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joice Miranda
 * @author Jorge Suchite
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
public class Diccionario {
    
    
    
    //Inicializacion de variables 
    File direccion = null;
    FileReader fr = null;
    BufferedReader br = null;
    BinaryTree<Association<String,String>>raiz;
    ArrayList <String> texto = new ArrayList<String>();
    
    public Diccionario(){
        //Se crea un binaryTree que asocia dos strings 
        raiz=new BinaryTree<Association<String,String>>(null, null, null, null);
    }
    
    
    //Metodo sacado de internet que crea un nuevo nodo 
    public void NewNode(BinaryTree<Association<String,String>> papa, Association<String,String> dato)
    {
        
        Association<String,String> asociacion=papa.value();
        String llavepapa=asociacion.getKey();
        String llaveDato=dato.getKey();
        int num=llavepapa.compareToIgnoreCase(llaveDato);
        if(num>0 && papa.left()==null){
          
            papa.setLeft(new BinaryTree<Association<String,String>>(null, null, null,null));
            papa.left().setValue(dato);
        }else if(papa.left()!=null){
            
            NewNode(papa.left(),dato);
        }
        
        if(num<0 && papa.right()==null){
            
            papa.setRight(new BinaryTree<Association<String,String>>(null, null, null,null));
            papa.right().setValue(dato);
        }else if(papa.right()!=null){
           
            NewNode(papa.right(),dato);
        }
    }
    
    //metodo para llenar el arraylist
    //pide como parametro la ubicacion del texto
    public void llenar(String ubicacion){
        ArrayList<String> array= new ArrayList<String>();
        ArrayList<Association<String,String> >emparejamientos= new ArrayList<Association<String,String>>();
        //Código de internet
        try {
           //Lectura de archivo, se guardará en dirección. Cambiar la dirección donde este reside.
           direccion = new File (ubicacion);
           fr = new FileReader (direccion);
           br = new BufferedReader(fr);

           // Lectura del fichero
           String palabras;
           int ind=0;
           while((palabras=br.readLine())!=null){
              array.add(palabras);
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
         
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        //termina código de internet
        
        
        for(int i=0; i<array.size()-1;i++){
               int posicion=array.get(i).indexOf(',');
               String Ingles=array.get(i).substring(0,posicion);
               String Espannol=array.get(i).substring(posicion+1,array.get(i).length());
               emparejamientos.add(new Association(Ingles, Espannol));
        }
        
        raiz.setValue(emparejamientos.get(0));
        for (int i=1; i<emparejamientos.size(); i++){
            NewNode(raiz, emparejamientos.get(i));
        }
     }
    
    public String traducirTexto(){
        
        String resultado="";
        for(int i=0; i<texto.size(); i++){
                resultado+=Traducido(raiz, texto.get(i).trim())+" ";
        }
        return resultado;
    }
    
    public String Traducido(BinaryTree<Association<String,String>> papa, String palabra)
    {
	String palabraFinal = "";
	Association<String,String> asociacion=papa.value();
       	String llavepapa=asociacion.getKey();
      
	int num=llavepapa.compareToIgnoreCase(palabra);
	if(num==0){
		palabraFinal=papa.value().getValue();
	}
	if(num<0){
            if(papa.right()!=null){
                palabraFinal=Traducido(papa.right(),palabra);
            }else{
                return ("*"+palabra+"*");
            }
	}
	if(num>0){
            if(papa.left()!=null){
                    palabraFinal=Traducido(papa.left(),palabra);
            }else{
                    return ("*"+palabra+"*");
            }
		
	}

	return palabraFinal;
    }

}
