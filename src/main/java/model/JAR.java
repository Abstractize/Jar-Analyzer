package model;

import adt.Graph;

public class JAR {
	private String Name;
	private Graph<JarClass> Diagram;
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
	
	
}
