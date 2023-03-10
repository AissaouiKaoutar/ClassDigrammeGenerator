package org.mql.java.models;

import java.util.List;
import java.util.Vector;

public class Methods {
	private String modifier;
	private Class<?> returnType;
	private String name;
	private List<Property> parameters;
	
	public Methods() {
		this.parameters= new Vector<Property>();
	}
	
	public Methods(String modifier, String name) {
		this();
		this.modifier= modifier;
		this.name = name;
	} 
	
	public Methods(String modifier, Class<?> returnType, String name) {
		this(modifier, name); 
		this.returnType = returnType;
	}
	
	


	public Methods(String modifier, Class<?> returnType, String name, List<Property> parameters) {
		this(modifier,returnType, name);
		this.parameters = parameters;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Class<?> getReturnType() {
		return returnType;
	}

	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Property> getParameters() {
		return parameters;
	}

	public void setParameters(List<Property> parameters) {
		this.parameters = parameters;
	}
	public void addParameter(Property parameter) {
		this.parameters.add(parameter);
	}

	@Override
	public String toString() {
		return "Methods [modifier=" + modifier + ", returnType=" + returnType + ", name=" + name + ", parameters="
				+ parameters + "]";
	}
	
	

}
