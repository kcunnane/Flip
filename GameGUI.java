import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

import dataStructures.*;

public class GameGUI extends JFrame{
	
	// *****************************************************************
	// *  Fields
	// *****************************************************************
	
	private JPanel mainPanel = new JPanel();
	
	//North Panel of mainPanel
	private JPanel headerPanel = new JPanel();
	private JLabel headerLabel = new JLabel("flip", JLabel.CENTER);
	
	//Center Panel of mainPanel
	private JPanel boardPanel = new JPanel();
		//load images here
	private JPanel cardsPanel = new JPanel();	//grid layout
	
	//East Panel of mainPanel
	private JPanel scorePanel = new JPanel();
	private JPanel playerPanel = new JPanel();	//grid layout
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int selected;
	
	
	// *****************************************************************
	// *  Constructor
	// *****************************************************************	
	
	public GameGUI(ArrayList<Player> players) {
		super("Flip");
		
		setSize(1000,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Board brd = new Board(players.size());
		
		mainPanel.setLayout(new BorderLayout());
		
		//**create headerPanel
		headerPanel.add(headerLabel);
		
		//**create boardPanel
		int rows = brd.getHeight();
		int cols = brd.getWidth();
		selected = 0;
		boardPanel.setLayout(new GridLayout(rows, cols, 5, 5));
			//upload cards to cardsPanel
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					JButton btn = new JButton(brd.getImageFromCard(j, i));
					ImageIcon back = new ImageIcon("src/Cards/back.png");
					btn.setIcon(back);
					ImageIcon t = brd.displayCard(j, i);
					btn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn.setIcon(t);
							selected++;
							if (selected == 1) {
								System.out.println("x1: " + x1 + " y1: " + y1);
							} else if (selected == 2) {
								
								selected = 0;
							}
						}
					});
					boardPanel.add(btn);
				}
			}
		
		//**create scorePanel
		scorePanel.setLayout(new GridLayout(0, players.size()));
		playerPanel.setLayout(new BorderLayout());
		for (int j = 0; j < players.size(); j++) {
			for (int k = 0; k < players.size(); k++) {
				JButton playerbtn = new JButton("Player " + (k + 1));
				playerPanel.add(playerbtn, BorderLayout.NORTH);
				playerbtn.setEnabled(false);
			}
			scorePanel.add(playerPanel);
		}
		
		
		//**add panels to mainPanel
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		mainPanel.add(scorePanel, BorderLayout.EAST);
		
		add(mainPanel);
		setVisible(true);
	}
}