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
	
	public WinnerGUI(String winner) {
		super("Flipp");
		setSize(600,450);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("winner is " + winner);
		
		mainPanel.setLayout(new BorderLayout());
		headerPanel.add(mainLabel);
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		
		champion = new JLabel(winner + " is the winner!");
		congratsPanel.setLayout(new FlowLayout());
		congratsPanel.add(champion);
		mainPanel.add(congratsPanel, BorderLayout.CENTER);
		
		
		add(mainPanel);
		setVisible(true);
	}
}
