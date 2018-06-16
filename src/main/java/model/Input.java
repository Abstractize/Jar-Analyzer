package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import com.jcabi.manifests.Manifests;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import adt.Graph;
import adt.GraphNode;
import adt.List;
import com.sun.nio.zipfs.JarFileSystemProvider;
import sun.tools.jar.Manifest;


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
		this.Jars.insertarVertice(new GraphNode<JAR>(main,main.getName()));
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
						Jars.insertarVertice(new GraphNode<JAR>(dependencie,dependencie.getName()));
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
		return new JAR(file.getName(),Classes);
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
}
