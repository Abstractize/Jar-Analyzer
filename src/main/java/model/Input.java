package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
//import com.jcabi.manifests.Manifests;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import adt.Edge;
import adt.Graph;
import adt.GraphNode;
import adt.List;
import com.sun.nio.zipfs.JarFileSystemProvider;
import sun.tools.jar.Manifest;


public class Input{

	private GraphNode<JAR> main;
	//private String Name;
	//private List<JAR> Jars = new List<JAR>();
	private Graph<JAR> Jars = new Graph<JAR>();
	//private Manifest Manifest;
	private JarEntry Classpath;

	public Input(String fileURL) throws IOException {
		Graph<JarClass> Classes = new Graph<JarClass>();
		//Obtenemos el primer JAR y lo colocamos en el Grafo
		main = new GraphNode<JAR>(createJAR(fileURL), "Main");
		this.Jars.insertarVertice(main);
		//Insertamos en el Grafo las dependecias y creamos una arista por cada dependecia
		//relateJAR(main);




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
	}
	public void toGraph(){//Search about jar Entries
		
	}
	public JAR createJAR(String url) throws IOException{

		System.out.println("creando nuevo Jar...");
		JarFile file= new JarFile(new File(url));

		Graph<JarClass> Classes = new Graph<JarClass>();
		System.out.println("Clases de: "+ file.getName());
		//GraphNode<JAR> mainNode = new GraphNode<JAR>(main, main.getName());
		for (Enumeration<JarEntry> e = file.entries(); e.hasMoreElements();){
			JarEntry evaluate = e.nextElement();
			if (evaluate.getName().endsWith(".class")){
				if(isDependencie(evaluate.getName())){
					JarClass aux = new JarClass(evaluate.getName().replace(".class",""));
					String[] container = evaluate.getName().split("/");
					String name = container[2];
					System.out.println(name);
					System.out.println(Jars.contieneElVertice(name));
					if (Jars.contieneElVertice(name)){
						GraphNode<JAR> vertice = Jars.getVertice(name);
						vertice.getValue().getDiagram().insertarVertice(new GraphNode<JarClass>(aux,aux.getName()));
					}else{
						Graph<JarClass> dClasses = new Graph<JarClass>();
						dClasses.insertarVertice(new GraphNode<JarClass>(aux,aux.getName()));
						JAR dependencie = new JAR(name,dClasses);
						GraphNode<JAR> newNode= new GraphNode<JAR>(dependencie,dependencie.getName());
						Jars.insertarVertice(newNode);
						//Jars.insertarArista(mainNode, newNode);

						System.out.println("Insertada dependencia "+Jars.getVertice(dependencie.getName()).getTag());
						System.out.println(Jars.getVertices().getLength());


					}
				}else{
					//Crea el grafo de Clases
					JarClass aux = new JarClass(evaluate.getName().replace(".class",""));
					//JarClass aux = new JarClass(evaluate.getName());
					System.out.println("clase: "+aux.getName());
					Classes.insertarVertice(new GraphNode<JarClass>(aux,aux.getName()));
					//Grafo sin aristas
				}
			}
		}
		JAR jar = new JAR(file.getName(),Classes);
		String[] name = jar.getName().split("");
		main = new GraphNode<JAR>(jar, "Main");//name[name.length-1]);

		for(int i = 0; i < Jars.getVertices().getLength(); i++) {//Recorre los vertices para ser insertados
			boolean bool = false;
			for (int j = 0; j< Jars.getAristas().getLength();j++ ){
				System.out.println("Verficando arista repetida");
				Edge<JAR> aux = Jars.getAristas().getValue(j);
				if (aux.getHead() == Jars.getVertices().getValue(i)){
					System.out.println("Arista repetida");
					aux.setNum(aux.getNum()+1);
					bool = true;
					break;
				}
			}
			if (!bool){
				Jars.insertarArista(main, Jars.getVertices().getValue(i));
			}



		}
		//this.setEdges();

		return new JAR(file.getName(),Classes);
	}

	public void ranking() {

	}

	public void setEdges() {
		List<List<String>> newStringList = new List<List<String>>();
		newStringList.add(Jars.getStringList().getValue(0));
		for(int i = 1; i < Jars.getStringList().getLength(); i++) {
			for(int j = 0; j < newStringList.getLength(); j++) {
				if(Jars.getStringList().getValue(i).getValue(0) == newStringList.getValue(j).getValue(0) && Jars.getStringList().getValue(i).getValue(1) == newStringList.getValue(j).getValue(1)) {
					break;
				} else if(j == newStringList.getLength()-1) {

					newStringList.add(Jars.getStringList().getValue(i));
				}
			}
		}
		Jars.setStringList(newStringList);
	}

	public boolean isDependencie(String url){
		String[] container = url.split("/");
		System.out.println(container.length);
		if (container.length > 2 ){
			return true;
		}else{
			return false;
		}
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

	public void printEdges(){

		List<List<String>> stringMatrix = Jars.getStringList();

		for (int i = 0; i<stringMatrix.getLength(); i++){
			for(int j = 0; j<stringMatrix.getValue(i).getLength()-1;j++){

				System.out.println(stringMatrix.getValue(i).getValue(j)+" -> "+stringMatrix.getValue(i).getValue(j+1)+";");
			}
		}

	}
}
