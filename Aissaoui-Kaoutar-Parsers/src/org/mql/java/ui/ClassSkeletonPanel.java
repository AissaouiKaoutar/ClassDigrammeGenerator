package org.mql.java.ui;

import javax.swing.JPanel;

import org.mql.java.models.ClassSkeleton;
import org.mql.java.models.Constructors;
import org.mql.java.models.Methods;
import org.mql.java.models.Property;

public class ClassSkeletonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private ClassSkeleton skeleton;

	public ClassSkeletonPanel(ClassSkeleton skeleton) {
		this.skeleton = skeleton;
	}

	public String getSkeleton() {
		String stringSkeleton = "public class " + skeleton.getClassName() + " {\n\n";
		for (Property p : skeleton.getProperties()) {
			stringSkeleton += "\t" + p.getModifier() + " " + p.getType().getSimpleName() + " " + p.getName() + ";\n\n";
		}

		for (Constructors c : skeleton.getConstructors()) {
			stringSkeleton += "\t " + c.getModifier() + " " + c.getName() + "(";
			for (Property p : skeleton.getProperties()) {
				stringSkeleton += p.getType().getSimpleName() + " " + p.getName() ;
			}
			stringSkeleton += "){\n\t}\n\n";
		}
		for (Methods m : skeleton.getMethods()) {

			stringSkeleton += "\t " + m.getModifier() + " " + m.getReturnType().getSimpleName() + " " + m.getName() + "(";
	
			for (Property p : skeleton.getProperties()) {
				stringSkeleton += p.getType().getSimpleName() + " " + p.getName()+"," ;
				
			}
			stringSkeleton += "){\n\t}\n\n";
		}
		

		return stringSkeleton + " \n\n}";
	}
}
