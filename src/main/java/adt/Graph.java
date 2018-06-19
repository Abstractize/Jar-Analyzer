package adt;

import java.util.*;
/**

 * This graphs creates Lists to stock data.
 * @author Gabriel Abarca Aguilar
 */
public class Graph<T> {
    private List<GraphNode<T>> vertices;
    private List<Edge<T>> aristas;

    public List<Edge<T>> getAristas() {
        return aristas;
    }

    public void setAristas(List<Edge<T>> aristas) {
        this.aristas = aristas;
    }

    private List<List<String>> stringList = new List<List<String>>();

    /**
     * Construcción de un grafo vacío
     **/
    public Graph()
    {
        this.vertices = new List<GraphNode<T>>();
        this.aristas = new List<Edge<T>>();
    }


    /**
     * Construcción de un grafo que acepta una lista
     * de vertices por parámetro de entrada
     *
     *@param vertices: Array de lista usado para llenar el grafo
     **/
    public Graph(List<GraphNode<T>> vertices)
    {
        this.vertices = new List<GraphNode<T>>();
        this.aristas = new List<Edge<T>>();

        for(int i = 0; i<vertices.getLength();i++)
        {
            GraphNode<T> v = vertices.getValue(i);
            this.vertices.add(v);
        }

    }


    /**
     * Inserta una arista unitaria entre los vertices v1 y v2
     * si y solo si no exista ya una arista que los una
     *
     * @param v1: Un extremo de la arista
     * @param v2: Otro extremo de la arista
     * @return true. Si y solo si la arista no existe previamente
     **/
    public boolean insertarArista(GraphNode<T> v1, GraphNode<T> v2)
    {
        return insertarArista(v1, v2, 1);
    }


    /**
     *NO INSERTA A LAS 2 , SOLO UNA DEBIDO A QUE ES DIRIGIDO
     * Inserta una arista entre los vertices v1 y v2
     * y un coste o peso especificado por parámetro de entrada.
     * La arista se insertará con éxito siempre que sea única y además
     * no haya otra uniendo actualmente v1 y v2. Finalmente v1 y v2 no
     * deben ser el mismo vértice (v1 != v2)
     *
     * @param v1: Un extremo de la arista
     * @param v2: Otro extremo de la arista
     * @param peso: Coste para llegar de v1 a v2 o viceversa
     * @return true. Si y solo si la arista no existe previamente
     **/
    public boolean insertarArista(GraphNode<T> v1, GraphNode<T> v2, int peso)
    {
        if(v1.equals(v2)) //vertices identicos?
            return false;

        Edge<T> arista = new Edge<T>(v1, v2, peso);
        if( v1.contensEdge(arista) || v2.contensEdge(arista)) //arista ya une a v1 o v2?
            return false;
        for (int i = 0; i<this.aristas.getLength(); i++){
            System.out.println("Verficando arista repetida");
            if (this.aristas.getValue(i).getHead()==v1 && this.aristas.getValue(i).getTail()==v2){
                System.out.println("Arista repetida");
                return false;
            }
        }

        aristas.add(arista);
        v1.addEdge(arista);
        stringList.add(
                    new List<String>(v1.getTag(),v2.getTag())
        );
        return true;
    }

    public List<List<String>> getStringList() {
        return stringList;
    }
    public void setStringList(List<List<String>> newList) {
        stringList = newList;
    }

    /**
     * @param arista: Arista que estamos buscando
     * @return true. Si y solo si el grafo contiene a la arista
     **/
    public boolean contieneLaArista(Edge<T> arista)
    {
        if(arista.getTail() == null || arista.getHead() == null)
            return false;
        return this.aristas.contains(arista);
    }


    /**
     * Elimina una arista del grafo. Por tanto, los vertices que unían
     * pierden la adyacencia entre ellos
     *
     *@param arista: Arista que se quiere eliminar del grafo
     *@return Arista. Arista borrada del grafo
     */
    public void eliminarArista(Edge<T> arista)
    {
        arista.getTail().deleteEdge(arista);
        this.aristas.delete(arista);
    }

    /**
     * Nos devuelve true si encuentra el vértice que se pasa
     * como parámetro de entrada
     *
     * @param vertice: Vértice que buscamos
     * @return boolean. True si el vertice se encuentra.
     **/
    public boolean contieneElVertice(GraphNode<T> vertice)
    {
        return (this.vertices.contains(vertice));
    }
    /**
     * Nos devuelve true si encuentra el vértice que se pasa
     * como parámetro de entrada
     *
     * @param reference: Nombre del vértice que buscamos
     * @return boolean. True si el vertice se encuentra.
     **/
    public boolean contieneElVertice(String reference)
    {
        for (int i = 0; i < vertices.getLength(); i++){
            if (reference == vertices.getValue(i).getTag()){
                return true;
            }
        }
        return false;
    }
    public GraphNode<T> getVertice (String str) {
        ListNode<adt.GraphNode<T>> aux = vertices.getHead();
        GraphNode<T> flag= null;
        while (aux != null && flag == null){
            if (str == aux.getValue().getTag()){
                flag = aux.getValue();
            }
            else{
                aux = aux.getNext();
            }
        }
        return flag;
    }
    /**
     * Inserta un nuevo vértice. Si el vértice existe previamente entonces
     * se consulta si puede ser sobreescrito. En tal caso se elimina las adyacencias
     * existentes.
     *
     * @param vertice: Vértice a insertar
     * @return boolean. Verdarero si el vértice se inserta con éxito
     **/
    public boolean insertarVertice(GraphNode<T> vertice)
    {
        vertices.add(vertice);
        return true;
    }
    public List<GraphNode<T>> getVertices(){
        return this.vertices;
    }

}
