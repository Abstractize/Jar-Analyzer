//package main.java.adt;
package adt;
/*
 * Un objeto Arista modela una arista no dirigida que representa la relaci�n de adyacencia
 * entre dos v�rtices. Por tanto una arista tiene dos v�rtices.
 * Si el peso de una arista no se especifica, su valor es 1. Esto permite representar grafos uniformes.
*/
public class Edge<T> implements Comparable<Edge<T>>{

    private GraphNode<T> Tail , Head;
    private int weight;

    /**
     * Constructor de un objeto Arista uniforme
     /* @param vertice1. Extremo o vï¿½rtice de la arista
     /* @param vertice2. Segundo extremo o vï¿½rtice para formar la arista
     **/
    public Edge(GraphNode<T> Tail, GraphNode<T> Head)
    {
        this(Tail, Head, 1);
    }

    /**
     * Se detalla la construcciï¿½n de la arista. El vertice lexicograficamente
     * menor se representa en la parte superior del grafo (vertice1)
     * y el vertice cuya etiqueta es lexicograficamente mayor en la inferior (vertice2)
     *
     /* @param vertice1. Extremo o vï¿½rtice de la arista
     /* @param vertice2. Segundo vï¿½rtice para formar la arista
     /* @param peso. Define el coste de ir desde el vertice1 al vertice2 y viceversa(arista no dirigida)
     **/
    public Edge(GraphNode<T> vertice1, GraphNode<T> vertice2, int peso) {
        this.Tail = vertice1;
        this.Head = vertice2;
        this.weight = peso;
    }


    /**
     * Dado un Vï¿½rtice vï¿½lido como parï¿½mentro de entrada
     * se devuelve su adyecente. Estos se conectan mediante una arista
     *
     * @param actual
     * @return el vecino adyecente mediante este objeto Arista
     **/
    public GraphNode<T> getVecinoDe(GraphNode<T> actual)
    {
        if (actual.equals(this.Tail))
            return this.Head;
        else if( actual.equals(this.Head))
            return this.Tail;
        else
            return null;
    }

    /**
     * @return el contenido del atributo vertice1 de tipo Vertice
     **/
    public GraphNode<T> getTail()
    {
        return this.Tail;
    }

    /**
     * @return el contenido del atributo vertice2 de tipo Vertice
     **/
    public GraphNode<T> getHead()
    {
        return this.Head;
    }

    /**
     * @return el valor de tipo entero del atributo peso
     **/
    public int getWeight()
    {
        return this.weight;
    }

    /**
     * Modificador del atributo peso
     *
     /* @param peso. Nuevo coste de la arista
     **/
    public void setWeight(int peso)
    {
        this.weight = peso;
    }

    /**
     * Comparamos el coste de esta arista con el coste
     * de otra arista como parï¿½mentro de entrada llamada arista2
     *
     /* @param arista2. Arista con la que comparamos nuestra arista actual
     * @return int. Se devuelve 0 en caso de que ambas tengan el mismo peso
     **/
    @Override
    public int compareTo(Edge<T> arista2) {
        return this.weight - arista2.getWeight();
    }


    /**
     * @return String. Representaciï¿½n mediante una cadena de este objeto Arista
     **/
    public String toString()
    {
        return "({" + this.Tail + ", " + this.Head  + "}, "+ this.weight  +")";
    }


    /**
     * @return int. Cï¿½digo hash para esta arista
     **/
    public int hashCode()
    {
        return (Tail.getTag() + Head.getTag()).hashCode();
    }

    /**
     * Se comparan el objeto Arista actual y otro que pasamos como parï¿½metro de entrada
     * Queremos saber si son idï¿½nticos. Para ello sus vï¿½rtices definidos como atributos
     * han de de ser iguales. Por lo que en el ï¿½ltimo if la responsabilidad se delega a
     * al mï¿½todo equals de la clase Vertice.
     *
     /* @param objeto. Se comprueba si es de tipo Arista. Y si lo es, se compara e identifica.
     * @return true. Si y solo si ambos objetos son idï¿½nticos(extremos iguales).
     **/
    public boolean equals(Edge<T> objeto)
    {
        if(!(objeto instanceof Edge))
            return false;

        Edge<T> arista2 = objeto;

        if(arista2.Tail.equals(this.Tail) && arista2.Head.equals(this.Head))
            return true;

        return false;
    }
}

   

