package adt;

import java.util.*;
/**

 * This graphs creates Lists to stock data.
 * @author Gabriel Abarca Aguilar
 */
public class Graph<T> {
    private HashMap<String, GraphNode<T>> vertices;
    private HashMap<Integer, Edge<T>> aristas;

    /**
     * Construcción de un grafo vacío
     **/
    public Graph()
    {
        this.vertices = new HashMap<String, GraphNode<T>>();
        this.aristas = new HashMap<Integer, Edge<T>>();
    }


    /**
     * Construcción de un grafo que acepta una lista
     * de vertices por parámetro de entrada
     *
     *@param vertices: Array de lista usado para llenar el grafo
     **/
    public Graph(List<GraphNode<T>> vertices)
    {
        this.vertices = new HashMap<String, GraphNode<T>>();
        this.aristas = new HashMap<Integer, Edge<T>>();

        for(int i = 0; i<vertices.getLength();i++)
        {
            GraphNode<T> v = vertices.getValue(i);
            this.vertices.put(v.getTag() , v);
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

        if(aristas.containsKey(arista.hashCode())) //arista ya está en el grafo?
            return false;
        else if( v1.contensEdge(arista) || v2.contensEdge(arista)) //arista ya une a v1 o v2?
            return false;

        aristas.put(arista.hashCode(), arista);
        v1.addEdge(arista);
        return true;
    }

    /**
     * @param arista: Arista que estamos buscando
     * @return true. Si y solo si el grafo contiene a la arista
     **/
    public boolean contieneLaArista(Edge<T> arista)
    {
        if(arista.getTail() == null || arista.getHead() == null)
            return false;
        return this.aristas.containsKey(arista.hashCode());
    }


    /**
     * Elimina una arista del grafo. Por tanto, los vertices que unían
     * pierden la adyacencia entre ellos
     *
     *@param arista: Arista que se quiere eliminar del grafo
     *@return Arista. Arista borrada del grafo
     */
    public Edge<T> eliminarArista(Edge<T> arista)
    {
        arista.getTail().deleteEdge(arista);
        return this.aristas.remove(arista.hashCode());
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
        return (this.vertices.get(vertice.getTag()) != null);
    }

    /**
     * @param etiqueta: Distintivo de cada vértice
     * @return Vertice. Devuelve el vértice asociado a la etiqueta
     **/
    public GraphNode<T> getVertice(String etiqueta)
    {
        return this.vertices.get(etiqueta);
    }

    /**
     * Inserta un nuevo vértice. Si el vértice existe previamente entonces
     * se consulta si puede ser sobreescrito. En tal caso se elimina las adyacencias
     * existentes.
     *
     * @param vertice: Vértice a insertar
     * @param sobreescribeVertice: Permiso para sobreescribir el vértice
     * @return boolean. Verdarero si el vértice se inserta con éxito
     **/
    public boolean insertarVertice(GraphNode<T> vertice, boolean sobreescribeVertice)
    {
        GraphNode<T> actual = this.vertices.get(vertice.getTag());
        if(actual != null) //existía previamente?
        {
            if(!sobreescribeVertice)
                return false;

            while(actual.getEdgesLength() >= 0)
                this.eliminarArista(actual.getEdge(0));

        }

        vertices.put(vertice.getTag(), vertice);
        return true;
    }

    /**
     * Elimina el vértice especificado mediante la etiqueta
     * distintiva por parámetro de entrada. Al eliminar el vértice
     * se elimina también todas las adyancencias que poseía este.
     *
     * @param etiqueta: Cadena distintiva de cada vértice
     * @return Vertice. Devuelve el vértice eliminado
     **/
    public GraphNode<T> eliminarVertice(String etiqueta)
    {
        GraphNode<T> vertice = vertices.remove(etiqueta);

        while(vertice.getEdgesLength() >= 0)
            this.eliminarArista(vertice.getEdge(0));

        return vertice;
    }

    /**
     * @return Set<String>. Devuelve las etiquetas, que son el distintivo
     * único de cada objeto Vertice en el Grafo
     **/
    public Set<String> verticeKeys()
    {
        return this.vertices.keySet();
    }

    /**
     * @return Set<Arista>. Devuelve todos los objetos Arista del Grafo
     **/
    public Set<Edge<T>> getAristas()
    {
        return new HashSet<Edge<T>>(this.aristas.values());
    }
}
