package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class ClassSkeleton {
	private String className;
	private List<Property> properties;
	private List<Constructors> constructors;
	private List<Methods> methods;
	
	public ClassSkeleton() {
		this.properties = new Vector<Property>();
		this.methods = new Vector<Methods>();
		this.constructors = new Vector<Constructors>();
	}
	
	public ClassSkeleton(String className) {
		this();
		this.className = className;
	}

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	public void addProperty(Property property) {
		this.properties.add(property);
	}
	
	public List<Constructors> getConstructors() {
		return constructors;
	}

	public void setConstructors(List<Constructors> constructors) {
		this.constructors = constructors;
	}
	public void addConstructor(Constructors constructor) {
		this.constructors.add(constructor);
	}
	
	public List<Methods> getMethods() {
		return methods;
	}
	public void setMethods(List<Methods> methods) {
		this.methods = methods;
	}
	public void addMethod(Methods method) {
		this.methods.add(method);
	}

	@Override
	public String toString() {
		return "ClassSkeleton [className=" + className + ", properties=" + properties + ", constructors=" + constructors
				+ ", methods=" + methods + "]";
	}

	
	
	

}
