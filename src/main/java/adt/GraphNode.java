//package main.java.adt;
package adt;

/*
 * Every instantiate represent a Node or Vertices
 * Every node is associated with a tag
 * This doesn't allow duplicated nodes
 * The list contains the edges associated with the Node
*/
public class GraphNode<T> {
    private List<Edge> edges;
    private String tag;
    private T value;
    /**
     * Create the Node
     * @param value: Object contained in the Node
     * @param tag: Name of the object to be identified easily
     */
    public GraphNode (T value,String tag)
    {
        this.value = value;
        this.tag = tag;
        this.edges = new List<Edge>();
    }
    /**
     * Add the edge to the list
     * @param edge: Object to add
     */
    public void addEdge(Edge edge)
    {
        if( !this.edges.contains(edge))
            this.edges.add(edge);
    }

    /**
     * If the edge is in the edge array
     * @param edge: Object to evaluate
     * @return true.If the object is in the array
     */
    public boolean contensEdge(Edge edge)
    {
        return this.edges.contains(edge);
    }

    /**
     * @param index: Position of the edge you need.
     * @return Edge. Edge to in the position specified
     */
    public Edge getEdge(int index)
    {
        return this.edges.getValue(index);
    }

    /**
     * Deletes an Edge
     * @param index: Position to delete
     * @return Edge. Edge deleted
     */
    public Edge deleteEdge(int index)
    {
        Edge get = this.edges.getValue(index);
        this.edges.delete(index);
        return get;
    }


    /**
     * Deletes an edge by refering the edge
     * @param edge: Edge to delete
     */
    public void deleteEdge(Edge edge)
    {
        this.edges.delete(edge);
    }

    /**
     * @return int. Returns the number of edges associated with the Node
     */
    public int getEdgesLength()
    {
        return this.edges.getLength();
    }

    /**
     * @return String. Returns the tag of the Node
     */
    public String getTag()
    {
        return this.tag;
    }

    /**
     * Verifies if the object vertice2 is a GraphNode, in case it isn't returns false
     * @return true. Efectivamente son el mismo objeto
     */
    public boolean equals(Object vertice2)
    {
        if( !(vertice2 instanceof GraphNode))
            return false;

        GraphNode<T> v = (GraphNode) vertice2;
        return this.tag.equals(v.tag);
    }

    /**
     * @return String. GraphNode in a String Value
     */
    public String toString()
    {
        return "Vertice: " + this.tag;
    }


    /**
     * @return int. Hash Code for the Node
     **/
    public int hashCode()
    {
        return this.getTag().hashCode();
    }

    /**
     * @return List<Edge>. return List of the edges
     */
    public List<Edge> getEdges()
    {
        return this.edges;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
