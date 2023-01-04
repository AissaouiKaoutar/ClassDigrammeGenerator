package org.mql.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import org.mql.java.models.ClassSkeleton;
import org.mql.java.models.Constructors;
import org.mql.java.models.Methods;
import org.mql.java.models.Property;

public class ClassExplorer {

	private ClassSkeleton skeleton;
	private Class<?> cls;

	public ClassExplorer() {

	}

	public ClassExplorer(String qualifiedName) {

		try {
			cls = Class.forName(qualifiedName);
			skeleton = new ClassSkeleton(cls.getSimpleName());

			fillProperties();
			fillConstructor();
			fillMethodes();

		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

	public void fillProperties() {
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			Property p = new Property(field.getName(), field.getType(), getModifier(field.getModifiers()));
			skeleton.addProperty(p);
		}
	}

	public void fillConstructor() {
		Constructor<?> constructors[] = cls.getDeclaredConstructors();

		for (Constructor<?> constructor : constructors) {
			String name = cls.getSimpleName();
			String modifier = getModifier(constructor.getModifiers());
			Constructors c = new Constructors(modifier, name);
			Parameter[] params = constructor.getParameters();
			for (Parameter p : params) {
				c.addParameter(new Property(p.getName(), p.getType()));
			}
			skeleton.addConstructor(c);
		}
	}

	public void fillMethodes() {
		Method[] methodes = cls.getDeclaredMethods();
		for (Method method : methodes) {
			String name = method.getName();
			Class<?> type = method.getReturnType();
			String modifier = getModifier(method.getModifiers());
			Methods m = new Methods(modifier, type, name);
			Parameter[] params = method.getParameters();
			for (Parameter p : params) {
				m.addParameter(new Property(p.getName(), p.getType()));
			}
			skeleton.addMethod(m);
		}
	}

	public String getModifier(int m) {
		return Modifier.toString(m);
	}

	public ClassSkeleton getSkeleton() {
		return skeleton;
	}

	public void setSkeleton(ClassSkeleton skeleton) {
		this.skeleton = skeleton;
	}

}
