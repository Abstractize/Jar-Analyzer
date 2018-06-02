package model;

import adt.List;

public class JarClass {
	private String Name;
	private List<Atribute> Atribute;
	private List<Method> Methods;
	
	//Getters and Setters
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<Atribute> getAtribute() {
		return Atribute;
	}
	public void setAtribute(List<Atribute> atribute) {
		Atribute = atribute;
	}
	public List<Method> getMethods() {
		return Methods;
	}
	public void setMethods(List<Method> methods) {
		Methods = methods;
	}
}
