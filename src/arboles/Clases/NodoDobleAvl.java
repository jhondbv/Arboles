/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Clases;

/**
 *
 * @author vero
 */
public class NodoDobleAvl {
     Object dato;
    NodoDobleAvl ld;
    NodoDobleAvl li;
    int fb;
    public NodoDobleAvl(Object d){
        dato = d;
        ld = null;
        li = null;
        fb = 0; //factor de balance
    }
    
    public void asignaDato(Object d){
        dato = d;
    }
    public void asignaLd(NodoDobleAvl ligad){
        ld = ligad;
    }
    public void asignaLi(NodoDobleAvl ligai){
        li = ligai;
    }
    public void asignaFb(int factorb){
        fb = factorb;
    }
    public Object retornaDato(){
        return dato;
    }
    public NodoDobleAvl retornaLd(){
        return ld;
    }
    public NodoDobleAvl retornaLi(){
        return li;
    }
    public int retornaFb(){
        return fb;
    }
    
    
}
