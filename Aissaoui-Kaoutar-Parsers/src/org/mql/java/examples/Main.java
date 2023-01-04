package org.mql.java.examples;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.mql.java.models.ClassSkeleton;
import org.mql.java.reflection.ClassExplorer;
import org.mql.java.ui.ClassSkeletonPanel;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {

	public Main() {
		init();
		config();
	}

	private void init() {
	
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setBackground(Color.pink);
		ClassExplorer classExplorer = new ClassExplorer("org.mql.java.models.Personne");
		ClassSkeleton classSkeleton = classExplorer.getSkeleton();
		ClassSkeletonPanel skeletonPanel = new ClassSkeletonPanel(classSkeleton);
		TextArea x = new TextArea(skeletonPanel .getSkeleton());
		x.setRows(28);
		x.setColumns(100);
		panel.add(x);

	}

	private void config() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
