package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import adt.Graph;
import adt.List;


public class Input extends JarFile{

	private String Name;
	private List<Atribute> Jars = new List<Atribute>();
	private List<JarEntry> Classes = new List<JarEntry>();
	private Graph<JAR> Graph;
	private Manifest Manifest;
	private JarEntry Classpath;
	
	public Input(String fileURL) throws IOException{
		this(new File(fileURL));
	}
	public Input(File file) throws IOException {
		super(file);
		System.out.println(file.getName());
		setName(file.getName());
		//Manifest
		Manifest = this.getManifest();
		System.out.println("Main attributes");
		System.out.println(Manifest.getMainAttributes().size());
		System.out.println(Manifest.getMainAttributes().values());
		//Classpath
		Classpath = this.getJarEntry(".classpath");
		System.out.println(Classpath.getName() +" founded");
		//Sets Classpath jars

		//Get classes
		for (Enumeration<JarEntry> e = this.entries(); e.hasMoreElements();){
			JarEntry evaluate = e.nextElement();
			if (evaluate.getName().contains(".class")){
				Classes.add(evaluate);
			}
		}
		Classes.print();
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
	public List<Atribute> getEntries() {
		return Jars;
	}
	public void setEntries(List<Atribute> jarEntries) {
		Jars = jarEntries;
	}
	public Graph getGraph() {
		return Graph;
	}
	public void setGraph(Graph graph) {
		Graph = graph;
	}
	
}
