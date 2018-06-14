package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import adt.Graph;
import adt.GraphNode;
import adt.List;


public class Input{

	private JAR main;
	//private String Name;
	//private List<JAR> Jars = new List<JAR>();
	private Graph<JAR> Jars = new Graph<JAR>();;
	//private Manifest Manifest;
	private JarEntry Classpath;

	public Input(String fileURL) throws IOException {
		Graph<JarClass> Classes = new Graph<JarClass>();
		//Obtenemos el primer JAR y lo colocamos en el Grafo
		main = createJAR(fileURL);
		this.Jars.insertarVertice(new GraphNode<JAR>(main,main.getName()),true);
		//Insertamos en el Grafo las dependecias y creamos una arista por cada dependecia
		relateJAR(main);



		// TODO Auto-generated constructor stub
	}
	public void relateJAR(JAR file){
		System.out.println("Dependencias de: "+ file.getName());
		System.out.println(file.getManifest().getEntries().size());
		Iterator it = file.getManifest().getEntries().keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			System.out.println("Clave: " + key + " -> Valor: " + file.getManifest().getEntries().get(key));
		}
		/*for (int i = file.getManifest().getEntries().size(); i > 0 ; i--){
			System.out.println(file.getManifest().getEntries()[i]);
		}*/
		System.out.println(file.getManifest().getEntries().values());
		/*for (Map man = file.getManifest().getEntries(); man.isEmpty();){
			System.out.println(man.values());
			man.clear();
		}*/
	}
	public void toGraph(){//Search about jar Entries
		
	}
	public JAR createJAR(String url) throws IOException{
		System.out.println("creando nuevo Jar...");
		JarFile file= new JarFile(new File(url));
		Graph<JarClass> Classes = new Graph<JarClass>();
		System.out.println("Clases de: "+ file.getName());
		for (Enumeration<JarEntry> e = file.entries(); e.hasMoreElements();){
			JarEntry evaluate = e.nextElement();
			if (evaluate.getName().endsWith(".class")){
				//Crea el grafo de Clases
				JarClass aux = new JarClass(evaluate.getName().replace(".class",""));
				//JarClass aux = new JarClass(evaluate.getName());
				System.out.println("clase: "+aux.getName());
				Classes.insertarVertice(new GraphNode<JarClass>(aux,aux.getName()),false);
				//Grafo sin aristas
			}
		}
		return new JAR(file.getName(),Classes,file.getManifest());
	}
	//Getters 
	public Graph getGraph() {
		return Jars;
	}
	public void setGraph(Graph graph) {
		Jars = graph;
	}

	/*public List<JAR> getJars() {
		return Jars;
	}

	public void setJars(List<JAR> jars) {
		Jars = jars;
	}*/
}
