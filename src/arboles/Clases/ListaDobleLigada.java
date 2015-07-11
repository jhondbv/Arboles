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
    /*Método para convertir un árbol n-arios representado en una lista generalizada
     a un árbol binario representado en una lista ligada*/
    public NodoDoble convierteNarioABinario(NodoLg r) {
        if (r == null) { //árbol vacío
            raiz = null;
            return raiz;
        }
        NodoDoble x, ultimo;
        NodoLg p, q;
        Stack pila;
        pila = new Stack();
        p = r; //inicializo p en el valor de la raíz que se ingresa como parámetro y así recorrer con esta variable el árbol
        x = new NodoDoble(p.retornaDato());
        raiz = x;
        ultimo = x;
        p = p.retornaLiga();
        while (p != null) { //mientras no se llegue al final del árbol
            if (p.retornaSw() == 0) {
                x = new NodoDoble(p.retornaDato());
            } else {
                q = (NodoLg) p.retornaDato();
                x = new NodoDoble(q.retornaDato());
                pila.push(x); //apilar x
                pila.push(q.retornaLiga()); //apilar el nodo siguiente a q
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
            if (!pila.empty()) { //si la pila no está vacía
                p = (NodoLg) pila.pop(); //desapilo
                ultimo = (NodoDoble) pila.pop(); //desapilo
            }
        }
        return raiz;
    }
    
    // Retorna la altura de un árbol
    public int Altura(NodoDoble r) {
        int alt = 1; 
        int p = 1;
        if (r.li != null)//valida hijos
        {

            alt = Altura(r.li);// se llama recursivamente al método altura para que evalúe la altura del hijo
            alt++; // aumenta 1 la altura de los nodos hijos , por ser padre 
        }
        if (r.ld != null)//valida si tiene hermanos
        {
            p = Altura(r.ld);// se llama recursivamente al método altura para evaluar la altura de los hermanos
            if (p > alt)//se toma la maxima altura entre la del nodo actual o sus hermanos
            {
                alt = p;
            }
        }
        return alt;

    }
    
    //Determina el grado del árbol entrado como parámetro
    public int gradoArbol(NodoDoble r) {

        int g = 0;
        int c = 0;
        int grado = 0;
        NodoDoble p;
        if (r == null) {
            return 0;
        }
        if (r.li == null && r.ld == null) {
            return 1;
        }
        p = r;
        while (p != null) {
            c = c + 1;
            if (p.li != null) {
                g = gradoArbol(p.li);
                if (g > grado) {
                    grado = g;
                }
            }
            p = p.ld;
        }
        if (c > grado) {
            grado = c;
        }
        return grado;
    }
    
    //Retorna el grado de un dato 
    public int GradoDato(String d, NodoDoble raiz) {
        int grado = -1;
        NodoDoble dato = GetNodoDato(d, raiz);//retorna el Nodo Correspondiente al dato
        if (dato != null) {
            grado = CalcularGradoDato(dato);
        }
        return grado;

    }
    
    //Calcula recursivamente el grado de un dato segun sus hijos
    public int CalcularGradoDato(NodoDoble r) {
        int g = 0;
        if (r.li != null) {
            g++;// se aumenta en 1 el grado pues se comenzara con el primer hijo
            NodoDoble p = r.li;
            while (p != null)// mientras tenga hermanos siga el ciclo
            {
                if (p.ld != null)// si tiene un hermano mas se aumenta el grado en 1
                {
                    g++;

                }
                p = p.ld;
            }

        }
        return g;
    }
    
    //hojas: se miran los nodos que no tengan liga izquierda
    //Retorna el número de hojas del árbol
    public int hojas(NodoDoble raiz) {
        int hojas = 0; //inicializo la variable a retornar en 0
        if (raiz == null) { //Cuando el árbol está vacío
            return 0;
        }
        if (raiz.retornaLi() == null) { //Cuando el árbol tiene sólo un hijo
            return 1;
        }
        raiz = raiz.retornaLi();
        while (raiz != null) {
            if (raiz.retornaLi() != null) { //Cuando el nodo en el que estoy tiene hijos
                hojas = hojas + hojas(raiz); //sumo a la variable a retornar el numero de hojas del subárbol que llamo recursivamente
            } else {
                hojas++; //Incremento la variable a retornar en 1
            }
            raiz = raiz.retornaLd(); //Debo buscar también el número de hojas por la liga derecha de cada nodo que voy teniendo
        }
        return hojas;
    }
    
    //obtiene el padre del dato ingresado
    public NodoDoble GetPadre(String d, NodoDoble r) {

        Stack<NodoDoble> pila = new Stack<NodoDoble>();// se crea una pila para apilar los padres del árbol
        RecorrerPadre(d, r, pila);// se utiliza otro método que se llama a si mismo recursivamente para recorrer el árbol
        NodoDoble datoreturn = null;
        if (!pila.empty()) {
            datoreturn = pila.pop();
        }
        return datoreturn;//se retorna el ultimo padre , en caso de que el dato no exista , esta pila vendrá vacía y retornará null

    }
    
    //método recursivo que recorre el árbol en busca del padre del dato ingresado
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

    public List<NodoDoble> GetAncestros(String d, NodoDoble r) {
        List lista = new ArrayList();
        Stack<NodoDoble> pila = new Stack<NodoDoble>();// se crea una pila para apilar los padres del árbol
        RecorrerPadre(d, r, pila);// se utiliza otro método que se llama a si mismo recursivamente para recorrer el árbol
        while (!pila.empty()) { //mientras la pila no esté vacía
            lista.add(pila.pop());//desapilo y agrego a la lista
        }
        return lista;
    }
    
    //Método que trae los tíos de un dato 
    public List<NodoDoble> GetTios(String d, NodoDoble r) {
        NodoDoble padre = GetPadre(d, r); // se obtiene el padre del dato 
        List<NodoDoble> tios = null;
        if (padre != null) {
            NodoDoble abuelo = GetPadre(padre.retornaDato().toString(), r);//se obtiene el abuelo del dato
            if (abuelo != null) {
                tios = GetHijos(r, abuelo.retornaDato().toString());// se obtiene los hijos del abuelo
                tios.remove(padre);// se elimina el padre del dato de la lista de hijos del abuelo 
            }
        }
        return tios;
    }
    
    //Método para obtener los hijos de un árbol
    public List<NodoDoble> GetHijos(NodoDoble raiz, String dato) {
        NodoDoble p, q, x;
        List lista = new ArrayList() {
        };
        p = GetNodoDato(dato, raiz);

        if (p != null) {
            if (p.li != null) {
                q = p.li;
                while (q != null) {
                    lista.add(q);
                    q = q.ld;
                }
            }
        }
        return lista;
    }

    //Método que consulta los primos de un dato
    public List<NodoDoble> GetPrimos(String d, NodoDoble r) {
        List<NodoDoble> primos = null;
        List<NodoDoble> tios = GetTios(d, r);// se obtienen los tíos del dato actual
        if(tios!=null)
        {
        for (NodoDoble tio : tios) {
            List<NodoDoble> hijostios = GetHijos(r, tio.retornaDato().toString());//se consultan los hijos de cada tío
            if (hijostios != null) {
                if (hijostios.size() > 0) {
                    if (primos == null) {
                        primos = new ArrayList<NodoDoble>();
                    }
                    primos.addAll(hijostios); // se agregan los hijos de cada tio en la lista de primos
                }
            }
        }
        }
        return primos;
    }
    
    //Cuenta los nodos que hay en el árbol
    public int CountNodos(NodoDoble r) {
        int count = 1;
        if (r == null) {
            return 0;
        }
        if (r.ld != null) {
            count += CountNodos(r.ld);
        }
        if (r.li != null) {
            count += CountNodos(r.li);
        }
        return count;

    }

    //Retorna el nodo correspondiente al dato ingresado
    public NodoDoble GetNodoDato(String d, NodoDoble r) {
        NodoDoble p = null;
        if (r.retornaDato().toString().equals(d)) { //si el dato de la raíz es igual al dato ingresado entonces se retorna la raíz
            return r;
        }
        if (r.li != null) { //Se busca recursivamente si el dato está por la liga izquierda de la raíz
            p = GetNodoDato(d, r.li);
            if (p != null) {
                return p;
            }
        }
        if (r.ld != null) { //Se busca recursivamente si el dato está por la liga derecha de la raíz
            p = GetNodoDato(d, r.ld);
            if (p != null) {
                return p;
            }
        }
        return p;
    }
    
}