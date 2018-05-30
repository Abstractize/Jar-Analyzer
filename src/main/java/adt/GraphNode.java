package adt;

/*
 * Every instantiate represent a Node or Vertices
 * Every node is associated with a tag
 * This doesn't allow duplicated nodes
 * The list contains the edges associated with the Node
*/
public class GraphNode {
	private List<Edge> edges;
	private String tag;
	
	public GraphNode (String tag)
    {
		this.tag = tag;
		this.edges = new List<Edge>();
    }

    public void insertarVecino(Edge edge)
    {
    	if( !this.edges.contains(edge))
    		this.edges.add(edge);
    }

    /**
     * If the edge is in the edge array
     * @param edge. Object to evaluate
     * @return true.If the object is in the array
     */
    public boolean contensNeighboor(Edge edge)
    {
    	return this.edges.contains(edge);
    }

    /**
     * @param indice. Indica la posicion a extraer
     * @return Arista. La arista apuntada por el �ndice en el array de lista vecindad
     */
    public Edge getVecino(int index)
    {
	return this.edges.getValue(index);
    }

    /*/**
     * Se elimina una arista del array de lista vecindad mediante posici�n
     * @param indice. Indica la posicion a eliminar
     * @return Arista. La Arista que ha sido eliminada del array de lista vecindad
     
    public Edge eliminarVecino(int index)
    {
    	return this.edges.remove(index);
    }
    */

    /**
     * Se elimina el objeto Arista del array de lista vecindad mediante
     * el identificando la referencia del objeto Arista
     * @param arista. indice el objeto Arista a eliminar
     */
    public void eliminarVecino(Edge arista)
    {
	this.edges.delete(arista);
    }

    /**
     * @return int. Se devuelve el n�mero de aristas incidentes (o vecinos) 
     * tiene el v�rtice en el array de lista vecindad
     */
    public int getContarVecinos()
    {
	return this.edges.getLength();
    }

    /**
     * @return String. Devuelve el valor de la cadena etiqueta
     */
    public String getEtiqueta()
    {
    	return this.tag;
    }

    /**
     * Se comprueba si vertice2 es un objeto de tipo Vertice
     * En tal caso podemos convertirlo de Object a Vertice
     * Y por �ltimo evaluamos si contiene el mismo valor que el objeto vertice actual
     * Para ello las etiquetas deben coincidir(son �nicas para cada objeto Vertice) 
     * @param vertice2. Objeto que comparamos con el vertice para 
     * evaluar si son el mismo objeto
     * @return true. Efectivamente son el mismo objeto
     */
    public boolean equals(Object vertice2)
    {
    	if( !(vertice2 instanceof GraphNode))
    		return false;

    	GraphNode v = (GraphNode) vertice2;
    	return this.tag.equals(v.tag);
    }

    /**
     * @return String. Representaci�n del v�rtice en una cadena
     */
    public String toString()
    {
    	return "Vertice: " + this.tag;
    }


    /**
     * @return int. C�digo hash para este v�rtice
     **/
    public int hashCode()
    {
    	return this.getEtiqueta().hashCode();
    }
    
    /**
     * @return ArrayList<Arista>. Copia del array de lista vecindad
     */ 
    public List<Edge> getVecinos()
    {
    	return this.edges;
    }
}
