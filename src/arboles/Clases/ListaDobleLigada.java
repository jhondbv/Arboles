/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Clases;

import java.util.Stack;

/**
 *
 * @author vero
 */
public class ListaDobleLigada {
    public NodoDoble raiz;
     
    public NodoDoble convierteNarioABinario(NodoLg r){
       NodoDoble x, ultimo;
        NodoLg p, q;
        Stack pila;
        pila = new Stack();
        p = r;
        x = new NodoDoble(p.retornaDato());
        raiz = x;
        ultimo = x;
        p = p.retornaLiga();
        while (p != null){
            if(p.retornaSw() == 0){
                 x = new NodoDoble(p.retornaDato());
            }else{
                q = (NodoLg)p.retornaDato();
                x = new NodoDoble(q.retornaDato());
                pila.push(x);
                pila.push(q.retornaLiga());
            }
            ultimo.asignaLi(x);
            ultimo = x;
            p = p.retornaLiga();
            while (p != null){
                if(p.retornaSw() == 0){
                 x = new NodoDoble(p.retornaDato());
            }else{
                q = (NodoLg)p.retornaDato();
                x = new NodoDoble(q.retornaDato());
                pila.push(x);
                pila.push(q.retornaLiga());
            }
            ultimo.asignaLd(x);
            ultimo = x;
            p = p.retornaLiga();   
            }
            if (!pila.empty()){
                p = (NodoLg)pila.pop();
                ultimo = (NodoDoble)pila.pop();
            }
        }

        return raiz;
    }

    
    public int altura(NodoDoble raiz){ //Se ingresa ya el árbol convertido de n-ario a binario
        NodoDoble r = raiz;
        int alturaIzq = 0;
        int alturaDer = 0;
        int altura = 0;
        if(r==null){
            return 0;
        }
        if (r.retornaLi() !=null){
            alturaIzq = altura(r.retornaLi());
        }
        if (r.retornaLd() !=null){
            alturaDer = altura(r.retornaLd());
        }
        if(alturaIzq>=alturaDer){
            altura = alturaIzq;
        }
        else
            altura = alturaDer;
        return (altura+1);
    
    }
    //Se ingresa ya el árbol convertido de n-ario a binario
    int grado(NodoDoble raiz){ //¿Cómo saber el grado del n-ario si el máximo en binario es 2?
        NodoDoble r = raiz;
        int grado = 0;
        if(r != null){
            if(r.retornaLi() != null && r.retornaLd() != null){
                grado=2;
            }
            else{
                if(r.retornaLi() != null || r.retornaLd() != null){
                    grado = 1;
                }
            }
            if(grado == 2){
                return grado;
            }
            grado = grado(r.retornaLi());
            
            if(grado == 2){
                return grado;
            }
            grado = grado(r.retornaLd());
            
        }
        return grado;
    
    }
    
    //Falta Determinar y mostrar el grado de un dato entrado por pantalla.
    
    int hojas(NodoDoble raiz){ //Se ingresa ya el árbol convertido de n-ario a binario
        NodoDoble r = raiz;
        int hojas = 0;
        if(r != null){
            if (r.retornaLi() == null && r.retornaLd() == null){
                hojas++;
            }
            else{
                hojas = hojas + hojas(r.retornaLi())+ hojas(r.retornaLd()); //¿Sí se puede hacer esto?
            }
        }
        return hojas;
    }
    
    int padre(NodoDoble raiz, int dato){ //Se ingresa ya el árbol convertido de n-ario a binario
        NodoDoble r = raiz;
        NodoDoble p;
        int d = dato;
        int datum;
        int padre = 0;
        
        if (r != null){
            if(r.retornaLi() != null){
                p = r.retornaLi();
                datum = (Integer)p.retornaDato();
                if(datum == dato){
                    padre = (Integer)r.retornaDato();
                }
            }
            if(padre == 0){
                if(r.retornaLd() != null){
                p = r.retornaLd();
                datum = (Integer)p.retornaDato();
                if(datum == dato){
                    padre = (Integer)r.retornaDato();
                }
                }
            }
            if(padre == 0){
                padre = padre(r.retornaLi(),d);
            }
            if(padre == 0){
                padre = padre(r.retornaLd(),d);
            }
        }
    return padre;
    }
    
    void ancestros(NodoDoble raiz,int dato){ //Se ingresa ya el árbol convertido de n-ario a binario
        NodoDoble r = raiz;
        int d=dato;
        Stack pila = new Stack();
        int anterior;
        anterior = padre(r,d);
        while(anterior != 0){
            pila.push(anterior); //Apilar
            anterior = padre(r,anterior);
            
        }
        while (!pila.empty()){ //Es vacía
            anterior = (Integer)pila.pop(); //Desapilar
            System.out.println(anterior); //Recordar que esto se tiene que mostrar en entorno gráfico
        }
    }
    
     //Falta mostrar tíos
    
    //Falta mostrar primos
}




