package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import adt.Graph;
import adt.GraphNode;
import adt.List;


public class Input{

	private JarFile main;
	private String Name;
	private List<JAR> Jars = new List<JAR>();
	private Graph<JAR> Graph;
	private Manifest Manifest;
	private JarEntry Classpath;
	
	public Input(String fileURL) throws IOException{
		this(new File(fileURL));
	}
	public Input(File file) throws IOException {
		main = new JarFile(file);
		Graph<JarClass> Classes = new Graph<JarClass>();
		System.out.println(file.getName());
		setName(file.getName());
		//Manifest
		Manifest = main.getManifest();
		//Get classes
		for (Enumeration<JarEntry> e = main.entries(); e.hasMoreElements();){
			JarEntry evaluate = e.nextElement();
			if (evaluate.getName().endsWith(".class")){
				JarClass aux = new JarClass(evaluate.getName().replace(".class",""));
				System.out.println(aux.getName());
				Classes.insertarVertice(new GraphNode<JarClass>(aux,aux.getName()),false);
				//Grafo sin aristas
			}
		}
		this.Jars.add(new JAR(main.getName(),Classes));
		/*
		System.out.println(Manifest.getEntries());
		System.out.println("Main attributes");
		System.out.println(Manifest.getMainAttributes().size());
		System.out.println(Manifest.getMainAttributes().values());*/
		//Classpath
		//Classpath = this.getJarEntry(".classpath");
		//System.out.println(Classpath.getName() +" founded");
		//Sets Classpath jars

		//Get classes


		// TODO Auto-generated constructor stub
	}
	public void toGraph(){//Search about jar Entries
		
	}
	//Getters 
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public Graph getGraph() {
		return Graph;
	}
	public void setGraph(Graph graph) {
		Graph = graph;
	}

	public List<JAR> getJars() {
		return Jars;
	}

	public void setJars(List<JAR> jars) {
		Jars = jars;
	}
}
