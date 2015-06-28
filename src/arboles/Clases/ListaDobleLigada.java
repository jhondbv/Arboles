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
    
    public NodoDoble convierteNarioABinario(NodoLg r){ //En guía dice árbol como parámetro, ¿qué pongo?
        NodoDoble raiz, x, ultimo;
        NodoLg p, q;
        Stack pila;
        pila = new Stack();
        p = r;
        x = new NodoDoble(p.retornaDato());
        raiz = x;
        ultimo = x;
        p = p.retornaLiga();
        while (p.retornaSw() == 0){
            x = new NodoDoble(p.retornaDato());
        }
        
        
        
        return raiz;
    }

 /*11.		while  (p != null)  do	
12.			if  (p.retornaSw() == 0)  then
13.				x = new  nodoDoble(p.retornaDato())
14.			else
15.				q = (nodoLg)p.retornaDato()
16.				x = new   nodoDoble(q.retornaDato())
17.				pila.apilar(x)
18.				pila.apilar(q.retornaLiga())
19.			end(if)
20.			ultimo.asignaLi(x)
21.			ultimo = x
22.			p = p.retornaLiga()
23.			while  (p != null)  do
24.				if  (p.retornaSw() == 0)  then
25.					x = new   nodoDoble(p.retornaDato())
26.				else
27.					q = (nodoLg)p.retornaDato()
28.					x = new   nodoDoble(q.retornaDato())
29.					pila.apilar(x)
30.					pila.apilar(q.retornaLiga())
31.				end(if)
32.				ultimo.asignaLd(x)
33.				ultimo = x
34.				p = p.retornaLiga()
35.			end(while)
36.			if  (!pila.esVacia())  then
37.				p = (nodoLg)pila.desapilar()
38.				ultimo = (nodoDoble)pila.desapilar()
39.			end(if)
40.		end(while)		
45.	Fin(convierteLgABinario)*/

    
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




