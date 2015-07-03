/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles.Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author vero
 */
public class ListaDobleLigada {

    public NodoDoble raiz;

    public NodoDoble convierteNarioABinario(NodoLg r) {
        NodoDoble x, ultimo;
        NodoLg p, q;
        Stack pila;
        pila = new Stack();
        p = r;
        x = new NodoDoble(p.retornaDato());
        raiz = x;
        ultimo = x;
        p = p.retornaLiga();
        while (p != null) {
            if (p.retornaSw() == 0) {
                x = new NodoDoble(p.retornaDato());
            } else {
                q = (NodoLg) p.retornaDato();
                x = new NodoDoble(q.retornaDato());
                pila.push(x);
                pila.push(q.retornaLiga());
            }
            ultimo.asignaLi(x);
            ultimo = x;
            p = p.retornaLiga();
            while (p != null) {
                if (p.retornaSw() == 0) {
                    x = new NodoDoble(p.retornaDato());
                } else {
                    q = (NodoLg) p.retornaDato();
                    x = new NodoDoble(q.retornaDato());
                    pila.push(x);
                    pila.push(q.retornaLiga());
                }
                ultimo.asignaLd(x);
                ultimo = x;
                p = p.retornaLiga();
            }
            if (!pila.empty()) {
                p = (NodoLg) pila.pop();
                ultimo = (NodoDoble) pila.pop();
            }
        }

        return raiz;
    }

    
    public int CountNodos(NodoDoble r)
    {
        int count =1;
        if(r==null)
        {
            return 0;
        }
        if(r.ld!=null)
        {
            count += CountNodos(r.ld);
        }
        if(r.li!=null)
        {
            count +=CountNodos(r.li);
        }
        return count;
    
    }
    
    public int gradoArbol(NodoDoble raiz) {
        NodoDoble p;
        int g, grado;
        g = 0;
        grado = 0;
        p = raiz.retornaLi();
        while (p != null) {
            g++;
            if (p.retornaLi() != null) {
                grado = gradoArbol(p);
            }
            p = p.retornaLd();
        }
        if (g >= grado) {
            grado = g;
        }
        return grado;
    }
    //hojas: se miran los nodos que no tengan liga izquierda

    public List<String> hijos(NodoDoble raiz, char dato) {
        NodoDoble p, q, x;
        List lista = new ArrayList() {
        };
        p = raiz;
        x = p.retornaLi();
        while (x != null) {
            if (p.retornaDato().equals(dato)) {
                if (p.retornaLi() != null) {
                    q = p.retornaLi();
                    while (q != null) {
                        lista.add(q.retornaDato());
                        q = q.retornaLd();
                    }
                    x = null;
                } else {
                    return null; //no tiene hijos
                }
            } else {
                lista = hijos(x, dato);
                x = p.retornaLd();
                lista = hijos(x, dato);
            }
        }
        return lista;
    }

    //obtiene el padre del dato ingresado
    public NodoDoble GetPadre(String d, NodoDoble r) {

        Stack<NodoDoble> pila = new Stack<NodoDoble>();// se crea una pila para apilar los padres del arbol
        RecorrerPadre(d, r, pila);// se utiliza otro metodo que se llama a si mismo recursivamente para recorrer el arbol
        return pila.pop();//se retorna el ultimo padre , en caso de que el dato no exista , esta pila vendra vacia y retornara null

    }

    //metodo recursivo que recorre el arbol en busca del padre del dato ingresado
    public NodoDoble RecorrerPadre(String d, NodoDoble r, Stack<NodoDoble> pila) {
        NodoDoble p = null;
        if (r.retornaDato().toString().equals(d))// en caso de que el dato del nodo sea igual al que se busca, retorna el nodo
        {
            return r;
        }
        if (r.li != null)// se valida si el nodo tiene hijos
        {
            pila.push(r);// se apila el nodo en la pila de padres ya que si entro a este punto es por que tiene hijos
            p = RecorrerPadre(d, r.li, pila);// se llama recursivamente al hijo del nodo actual
            if (p == null)// si p es nulo , es por que no se encontro el dato en los hijos del nodo actual , entonces se desapila
            {
                pila.pop();

            } else {
                return p;
            }

        }
        if (r.ld != null)// se valida si el nodo tiene hermanos
        {
            p = RecorrerPadre(d, r.ld, pila);// se llama recursivamente al hermano del nodo actual
            return p;// se retorna p siendo nulo si no se encontro el dato en los hermanos 
        }
        return p;

    }
    
    // Retorna la altura de un arbol
    public int Altura(NodoDoble r)
    {
        int alt = 1;
        int p =1;
        if(r.li!=null)//valida hijos
        {
            
            alt = Altura(r.li);// se llama recursivamente al metodo altura para que evalue la altura del hijo
             alt++; // aumenta 1 la altura de los nodos hijos , por ser padre 
        }
        if(r.ld!=null)//valida si tiene hermanos
        {
            p = Altura(r.ld);// se llama recursivamente al metodo altura para evaluar la altura de los hermanos
            if(p>alt)//se toma la maxima altura entre la del nodo actual o sus hermanos
            alt = p; 
        }
        return alt ;
    
    }
    
    //Retorna el nodo correspondiente al dato ingresado
    public NodoDoble GetNodoDato(String d,NodoDoble r)
    {
        NodoDoble p=null ;
        if(r.retornaDato().toString().equals(d))
        {
            return r;
        }
        if(r.li!=null)
        {
            p= GetNodoDato(d, r.li);
            if(p!=null)
                return p;
        }
        if(r.ld!=null)
        {
            p=GetNodoDato(d, r.ld);
            if(p!=null)
                return p ;
        }
        return p ;
    }
    
    //Retorna el grado de un dato 
    public int GradoDato(String d)
    {
        int grado =0;
        NodoDoble dato = GetNodoDato(d, raiz);//retorna el Nodo Correspondiente al dato
        if(dato!=null)
        grado = CalcularGradoDato(dato);
        return grado;
    
    }
    
    //Calcula recursivamente el grado de un dato segun sus hijos
    public int CalcularGradoDato(NodoDoble r)
    {
        int g =0;
        if(r.li!=null)
        {
            g++;// se aumenta en 1 el grado pues se comenzara con el primer hijo
            NodoDoble p = r.li ;
            while(p!=null)// mientras tenga hermanos siga el ciclo
            {
                if(p.ld!=null)// si tiene un hermano mas se aumenta el grado en 1
                {
                    g++;
                    
                }
                p=p.ld;
            }
            
        }
        return g;
    }
}
