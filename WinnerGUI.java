package gui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import dataStructures.*;

public class WinnerGUI extends JFrame {
	
	JPanel mainPanel = new JPanel();
	JPanel headerPanel = new JPanel();
	JLabel mainLabel = new JLabel("Congrats!");
	JPanel congratsPanel = new JPanel();
	JLabel champion;
	JPanel fireworksPanel = new JPanel();
	ImageIcon fireworks = new ImageIcon("src/Cards/fireworks.png");
	JLabel firework = new JLabel("", fireworks, JLabel.CENTER);
	
	public WinnerGUI(String winner) {
		super("Flipp");
		setSize(600,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("winner is " + winner);
		
		mainPanel.setLayout(new BorderLayout());
		mainLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		headerPanel.add(mainLabel);
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		
		champion = new JLabel(winner + " is the winner!");
		champion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		congratsPanel.setLayout(new FlowLayout());
		congratsPanel.add(champion);
		mainPanel.add(congratsPanel, BorderLayout.CENTER);
		
		fireworksPanel.add(firework);
		
		mainPanel.add(fireworksPanel, BorderLayout.SOUTH);
		add(mainPanel);
		setVisible(true);
	}
}