/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Clases;

/**
 *
 * @author vero
 */
public class NodoLg {
    
    int sw;
    Object dato;
    NodoLg liga;
    int x ;
    int y ;
    
    NodoLg(Object d)
    {
        this.sw=0;
        this.dato=d;
        this.liga=null;
    }
    
    NodoLg()
    {
        this.sw=0;
        this.dato=null;
        this.liga=null;
    }
    
    public void asignaSw(int sw){
        this.sw=sw;
    }
    
    public void asignaDato(Object d){
        this.dato=d;
    }
    
    public void asignaLiga(NodoLg liga){
        this.liga=liga;
    }
    
    public int retornaSw(){
        return sw;
    }

    public Object retornaDato(){
        return dato;
    }

    public NodoLg retornaLiga(){
        return liga;
    }
  
}

