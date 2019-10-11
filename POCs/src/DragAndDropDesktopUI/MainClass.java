package DragAndDropDesktopUI;

import java.awt.BorderLayout;

import javax.swing.*;

public class MainClass {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Drag drop experiment");
		JPanel panel = new JPanel();
		
		JLabel label = new DragAndDropLabel("DragThis");
		panel.add(label);
		
		frame.add(panel,BorderLayout.EAST);
		int frameWidth = 300;
		int frameHeight = 300;
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
	}

}
