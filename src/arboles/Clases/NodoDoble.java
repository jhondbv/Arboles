/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Clases;

/**
 *
 * @author jhon
 */
public class NodoDoble {

    Object dato;
    NodoDoble ld;
    NodoDoble li;
    int x;
    int y;
    
public   NodoDoble(Object d)
    {
        this.dato=d;
        this.ld=null;
        this.li=null;
        this.x=0;
        this.y=0;
    }
    
public   NodoDoble()
    {
        this.dato=null;
        this.ld=null;
        this.li=null;
    }
    
    public void asignaDato(Object d){
        this.dato=d;
    }
    
    public void asignaLd(NodoDoble ligad){
        this.ld=ligad;
    }
    
    public void asignaLi(NodoDoble ligai){
        this.li=ligai;
    }
    
    public Object retornaDato(){
        return dato;
    }

    public NodoDoble retornaLd(){
        return ld;
    }
    
    public NodoDoble retornaLi(){
        return li;
    }

}
