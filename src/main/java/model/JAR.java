package model;

import adt.Graph;

import java.util.jar.Manifest;

public class JAR {
	private String Name;
	private Graph<JarClass> Diagram;
	private Manifest manifest;
	public JAR(String name, Graph<JarClass> Graph,Manifest man){
		this.Name = name;
		this.Diagram = Graph;
		this.manifest = man;
	}
	public JAR(String name, Graph<JarClass> Graph){
		this.Name = name;
		this.Diagram = Graph;
	}
	//Getters and Setters
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Graph<JarClass> getDiagram() {
		return Diagram;
	}
	public void setDiagram(Graph<JarClass> diagram) {
		Diagram = diagram;
	}


	public Manifest getManifest() {
		return manifest;
	}

	public void setManifest(Manifest manifest) {
		this.manifest = manifest;
	}
}
