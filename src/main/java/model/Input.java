package model;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import adt.Graph;
import adt.List;


public class Input extends JarFile{

	private String Name;
	private List<JarEntry> Entries;
	private Graph<JAR> Graph;
	
	public Input(String fileURL) throws IOException{
		this(new File(fileURL));
	}
	public Input(File file) throws IOException {
		super(file);
		setName(file.getName());
		//Probar
		for (Enumeration<JarEntry> e = this.entries(); e.hasMoreElements();){
			System.out.println(e.nextElement());
			Entries.add(e.nextElement());
		}   
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
	public List<JarEntry> getEntries() {
		return Entries;
	}
	public void setEntries(List<JarEntry> jarEntries) {
		Entries = jarEntries;
	}
	public Graph getGraph() {
		return Graph;
	}
	public void setGraph(Graph graph) {
		Graph = graph;
	}
	
}
