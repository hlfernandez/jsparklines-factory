package org.sing_group.jsparklines_factory.demo;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class DemoUtils {
	/**
	 * Shows a JFrame containing the specified <code>component</code>.
	 * 
	 * @param component JComponent to show
	 */
	public static final void showComponent(JComponent component) {
		showComponent(component, "Demo dialog");
	}
	
	/**
	 * Shows a JFrame containing the specified <code>component</code>.
	 * 
	 * @param component the {@code Component} to show
	 * @param title the title for the window
	 */
	public static final void showComponent(Component component, String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(component);
		frame.pack();
		frame.setVisible(true);
	}	
	
	/**
	 * Sets the Nimbus look and feel.
	 */
	public static final void setNimbusLookAndFeel() {
		UIManager.put("Nimbus.keepAlternateRowColor", Boolean.TRUE);
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}
}
