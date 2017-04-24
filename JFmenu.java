package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

import dataStructures.Player;

import java.util.ArrayList;

public class JFmenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	RulesGUI rule;
	JLabel lblPlayer;
	JLabel lblNameOfPlayer;
	JLabel lblNameOfPlayer_1;
	JLabel lblNameOfPlayer_2;
	JRadioButton rdbtnPlayers;
	JRadioButton rdbtnPlayers_1;
	JRadioButton rdbtnPlayers_2;
	
	String Player_1 = "Player 1";
	String Player_2 = "Player 2";
	String Player_3 = "Player 3";
	String Player_4 = "Player 4";
	
	ArrayList<Player> playerList = new ArrayList<Player>();
	
	int numofPlayer = 2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFmenu frame = new JFmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1900, 1000); //1000
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.setBackground(Color.PINK);
		
		ButtonGroup btg1 = new ButtonGroup();
		btg1.add(rdbtnPlayers_1);
		btg1.add(rdbtnPlayers);
		btg1.add(rdbtnPlayers_2);
		
		JLabel lblFlipp = new JLabel("FLIPP!");
		lblFlipp.setFont(new Font("Georgia", Font.PLAIN, 75));
		lblFlipp.setBounds(749, 29, 245, 120);
		contentPane.add(lblFlipp);
		
		JLabel lblMenulablename = new JLabel("How many players?");
		lblMenulablename.setFont(new Font("Georgia", Font.PLAIN, 36));
		lblMenulablename.setBounds(478, 189, 386, 75);
		contentPane.add(lblMenulablename);
		
		JLabel lblPlayer = new JLabel("Name of Player 1");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPlayer.setBounds(533, 309, 200, 50);
		lblPlayer.setVisible(false);
		contentPane.add(lblPlayer);
		
		JLabel lblNameOfPlayer = new JLabel("Name of Player 2");
		lblNameOfPlayer.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNameOfPlayer.setBounds(533, 363, 200, 50);
		lblNameOfPlayer.setVisible(false);
		contentPane.add(lblNameOfPlayer);
		
		JLabel lblNameOfPlayer_1 = new JLabel("Name of Player 3");
		lblNameOfPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNameOfPlayer_1.setBounds(533, 414, 200, 50);
		lblNameOfPlayer_1.setVisible(false);
		contentPane.add(lblNameOfPlayer_1);
		
		JLabel lblNameOfPlayer_2 = new JLabel("Name of Player 4");
		lblNameOfPlayer_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNameOfPlayer_2.setBounds(533, 465, 200, 50);
		lblNameOfPlayer_2.setVisible(false);
		contentPane.add(lblNameOfPlayer_2);
		
		textField = new JTextField(10);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setDocument(new JTextFieldCharLimit(10));
		textField.setVisible(false);
		textField.setBounds(821, 321, 252, 36);
		contentPane.add(textField);
		
		textField_1 = new JTextField(10);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setDocument(new JTextFieldCharLimit(10));
		textField_1.setVisible(false);
		textField_1.setBounds(821, 375, 252, 36);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField(10);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setDocument(new JTextFieldCharLimit(10));
		textField_2.setVisible(false);
		textField_2.setBounds(821, 426, 252, 36);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField(10);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setDocument(new JTextFieldCharLimit(10));
		textField_3.setVisible(false);
		textField_3.setBounds(822, 477, 252, 36);
		contentPane.add(textField_3);
		
		JRadioButton rdbtnPlayers = new JRadioButton("2 Players");
		rdbtnPlayers.setBackground(Color.pink);
		rdbtnPlayers.setSelected(true);
		btg1.add(rdbtnPlayers);
		lblPlayer.setVisible(true);
		lblNameOfPlayer.setVisible(true);
		textField.setVisible(true);
		textField_1.setVisible(true);
		rdbtnPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPlayer.setVisible(true);
				lblNameOfPlayer.setVisible(true);
				lblNameOfPlayer_1.setVisible(false);
				lblNameOfPlayer_2.setVisible(false);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(false);
				textField_3.setVisible(false);
				numofPlayer = 2;
			}
		});
		rdbtnPlayers.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnPlayers.setBounds(837, 212, 115, 39);
		contentPane.add(rdbtnPlayers);
		
		
		JRadioButton rdbtnPlayers_1 = new JRadioButton("3 Players");
		rdbtnPlayers_1.setBackground(Color.pink);
		rdbtnPlayers_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPlayer.setVisible(true);
				lblNameOfPlayer.setVisible(true);
				lblNameOfPlayer_1.setVisible(true);
				lblNameOfPlayer_2.setVisible(false);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(false);
				numofPlayer = 3;
			}
		});
		btg1.add(rdbtnPlayers_1);
		rdbtnPlayers_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnPlayers_1.setBounds(959, 219, 115, 25);
		contentPane.add(rdbtnPlayers_1);
		
		JRadioButton rdbtnPlayers_2 = new JRadioButton("4 Players");
		rdbtnPlayers_2.setBackground(Color.pink);
		rdbtnPlayers_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPlayer.setVisible(true);
				lblNameOfPlayer.setVisible(true);
				lblNameOfPlayer_1.setVisible(true);
				lblNameOfPlayer_2.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				numofPlayer = 4;
			}
		});
		btg1.add(rdbtnPlayers_2);
		rdbtnPlayers_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnPlayers_2.setBounds(1078, 219, 129, 25);
		contentPane.add(rdbtnPlayers_2);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() != 0){
					Player_1 = textField.getText();
				}
				if(textField_1.getText().length() != 0){
					Player_2 = textField_1.getText();
				}
				if(textField_2.getText().length() != 0){
					Player_3 = textField_2.getText();
				}
				if(textField_3.getText().length() != 0){
					Player_4 = textField_3.getText();
				}
				createPlayers(numofPlayer);
				//new WinnerGUI("yo mama");
				setVisible(false);
				new GameGUI(playerList);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(911, 580, 200, 63);
		contentPane.add(btnNewButton);
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rule = new RulesGUI();
				rule.setAlwaysOnTop(true);
			}
		});
		btnRules.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRules.setBounds(664, 580, 200, 63);
		contentPane.add(btnRules);
	}
	public void createPlayers(int k){
		playerList.clear();
		
		int filler;
		String spaces = "";
		if (Player_1.length() < 10) {
			filler = 10 - Player_1.length();
			for (int i = 0; i < filler; i++) {
				spaces += " ";
			}
			Player_1 += spaces;
		}
		spaces = "";
		if (Player_2.length() < 10) {
			filler = 10 - Player_2.length();
			for (int i = 0; i < filler; i++) {
				spaces += " ";
			}
			Player_2 += spaces;
		}
		spaces = "";
		if (Player_3.length() < 10) {
			filler = 10 - Player_3.length();
			for (int i = 0; i < filler; i++) {
				spaces += " ";
			}
			Player_3 += spaces;
		}
		spaces = "";
		if (Player_4.length() < 10) {
			filler = 10 - Player_4.length();
			for (int i = 0; i < filler; i++) {
				spaces += " ";
			}
			Player_4 += spaces;
		}
		spaces = "";
		
		Player P1 = new Player(Player_1, 1);
		Player P2 = new Player(Player_2, 2);
		Player P3 = new Player(Player_3, 3);
		Player P4 = new Player(Player_4, 4);
		
		playerList.add(P1);
		playerList.add(P2);
		if(k >= 3){
			playerList.add(P3);
		}if(k == 4){
			playerList.add(P4);
		}
	}
}