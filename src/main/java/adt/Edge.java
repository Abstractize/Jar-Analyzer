//package main.java.adt;
package adt;
/*
 * Un objeto Arista modela una arista no dirigida que representa la relaci�n de adyacencia
 * entre dos v�rtices. Por tanto una arista tiene dos v�rtices.
 * Si el peso de una arista no se especifica, su valor es 1. Esto permite representar grafos uniformes.
*/
public class Edge implements Comparable<Edge>{
	
	private GraphNode vertice1, vertice2;
    private int peso;

    /**
     * Constructor de un objeto Arista uniforme
     /* @param vertice1. Extremo o v�rtice de la arista
     /* @param vertice2. Segundo extremo o v�rtice para formar la arista
     **/
    public Edge(GraphNode vertice1, GraphNode vertice2)
    {
    	this(vertice1, vertice2, 1);
    }

    /**
     * Se detalla la construcci�n de la arista. El vertice lexicograficamente
     * menor se representa en la parte superior del grafo (vertice1)
     * y el vertice cuya etiqueta es lexicograficamente mayor en la inferior (vertice2)
     *
     /* @param vertice1. Extremo o v�rtice de la arista
     /* @param vertice2. Segundo v�rtice para formar la arista
     /* @param peso. Define el coste de ir desde el vertice1 al vertice2 y viceversa(arista no dirigida)
     **/
    public Edge(GraphNode vertice1, GraphNode vertice2, int peso)
    {
    	if(vertice1.getEtiqueta().compareTo(vertice2.getEtiqueta()) <= 0)
	    	{
    		this.vertice1 = vertice1;
    		this.vertice2 = vertice2;
	    }
    	else
	    	{
    		this.vertice1 = vertice2;
    		this.vertice2 = vertice1;
	    }
     	this.peso = peso;
		
    }


    /** 
     * Dado un V�rtice v�lido como par�mentro de entrada
     * se devuelve su adyecente. Estos se conectan mediante una arista
     *
     * @param actual
     * @return el vecino adyecente mediante este objeto Arista
     **/
    public GraphNode getVecinoDe(GraphNode actual)
    {
	if (actual.equals(this.vertice1))
	    return this.vertice2;
	else if( actual.equals(this.vertice2))
	    return this.vertice1;
	else
	    return null;
    }

    /**
     * @return el contenido del atributo vertice1 de tipo Vertice
     **/
    public GraphNode getVertice1()
    {
	return this.vertice1;
    }
    
    /**
     * @return el contenido del atributo vertice2 de tipo Vertice
     **/
    public GraphNode getVertice2()
    {
	return this.vertice2;
    }

    /**
     * @return el valor de tipo entero del atributo peso
     **/
    public int getPeso()
    {
	return this.peso;
    }

    /**
     * Modificador del atributo peso
     * 
     /* @param peso. Nuevo coste de la arista
     **/
    public void setPeso(int peso)
    {
	this.peso = peso;
    }

    /**
     * Comparamos el coste de esta arista con el coste
     * de otra arista como par�mentro de entrada llamada arista2
     * 
     /* @param arista2. Arista con la que comparamos nuestra arista actual
     * @return int. Se devuelve 0 en caso de que ambas tengan el mismo peso
     **/
	@Override
	public int compareTo(Edge arista2) {
		// TODO Auto-generated method stub
		return this.peso - arista2.peso;
	}


    /**
     * @return String. Representaci�n mediante una cadena de este objeto Arista
     **/
    public String toString()
    {
	return "({" + this.vertice1 + ", " + this.vertice2  + "}, "+ this.peso  +")";
    }


    /**
     * @return int. C�digo hash para esta arista
     **/
    public int hashCode()
    {
	return (vertice1.getEtiqueta() + vertice2.getEtiqueta()).hashCode();
    }
    
    /**
     * Se comparan el objeto Arista actual y otro que pasamos como par�metro de entrada
     * Queremos saber si son id�nticos. Para ello sus v�rtices definidos como atributos
     * han de de ser iguales. Por lo que en el �ltimo if la responsabilidad se delega a
     * al m�todo equals de la clase Vertice.
     *
     /* @param objeto. Se comprueba si es de tipo Arista. Y si lo es, se compara e identifica.
     * @return true. Si y solo si ambos objetos son id�nticos(extremos iguales).
     **/
    public boolean equals(Edge objeto)
    {
	if(!(objeto instanceof Edge))
	    return false;

	Edge arista2 = objeto;

	if(arista2.vertice1.equals(this.vertice1) && arista2.vertice2.equals(this.vertice2))
	    	return true;

		return false;
    }

   
}
