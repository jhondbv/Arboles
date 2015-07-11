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
    public NodoDobleAvl ld;
    public NodoDobleAvl li;
    int fb;
    int x;
    int y ;
    
    public NodoDobleAvl(Object d){ //Constructor que crea un nodoAvl cuando se le entra el dato como parámetro
        dato = d;
        ld = null;
        li = null;
        fb = 0; //factor de balance
        x=0;
        y=0;
    }
 //métodos get y set para utilizar los nodos dobles avl
    
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
