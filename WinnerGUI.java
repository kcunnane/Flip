package gui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import dataStructures.*;

public class WinnerGUI extends JFrame {
	
	JPanel mainPanel = new JPanel();
	JPanel headerPanel = new JPanel();
	JLabel mainLabel;
	JPanel fireworksPanel = new JPanel();
	ImageIcon fireworks = new ImageIcon("src/Cards/fireworks.png");
	JLabel firework = new JLabel("", fireworks, JLabel.CENTER);
	
	public WinnerGUI(String winner) {
		super("Flipp!");
		setSize(600,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel.setBackground(Color.BLACK);
		headerPanel.setBackground(Color.BLACK);
		fireworksPanel.setBackground(Color.BLACK);
		
		mainPanel.setLayout(new BorderLayout());
		mainLabel = new JLabel("Congrats, " + winner + " is the winner!");
		mainLabel.setForeground(Color.PINK);
		mainLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		headerPanel.add(mainLabel);
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		
		fireworksPanel.add(firework);
		
		mainPanel.add(fireworksPanel, BorderLayout.SOUTH);
		add(mainPanel);
		setVisible(true);
	}
}