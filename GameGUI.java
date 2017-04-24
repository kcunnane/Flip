package gui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import dataStructures.*;

public class GameGUI extends JFrame{
	
	// *****************************************************************
	// *  Fields
	// *****************************************************************
	
	private JPanel mainPanel = new JPanel();
	
	//North Panel of mainPanel
	private JPanel headerPanel = new JPanel();
	private JLabel headerLabel = new JLabel("Flipp!", JLabel.CENTER);
	
	//Center Panel of mainPanel
	private JPanel boardPanel = new JPanel();
	
	//East Panel of mainPanel
	private JPanel scorePanel = new JPanel();
	private JPanel playerPanel = new JPanel();	//grid layout
	private JButton playerOneName;
	private JButton playerTwoName;
	private JButton playerThreeName;
	private JButton playerFourName;
	private JButton playerOneScore;
	private JButton playerTwoScore;
	private JButton playerThreeScore;
	private JButton playerFourScore;
	
	//South Panel of mainPanel
	private JPanel confirmPanel = new JPanel();
	private JButton confirm;
	private JTextField whosup;
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int selected;
	
	private int currPlayer;
	
	private Board brd;
	
	private JButton[][] boardButton;
	private JButton score;
	
	private ArrayList<Player> players;
	
	private boolean forwards = true;
	
	
	// *****************************************************************
	// *  Constructor
	// *****************************************************************	
	
	public GameGUI(ArrayList<Player> players) {
		super("Flipp!");
		setSize(1250, 535 + (players.size() - 2) * 250);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		headerPanel.setBackground(Color.PINK);
		boardPanel.setBackground(Color.PINK);
		scorePanel.setBackground(Color.PINK);
		playerPanel.setBackground(Color.PINK);
		confirmPanel.setBackground(Color.PINK);
		
		this.players = players;
		
		brd = new Board(players.size());
		
		mainPanel.setLayout(new BorderLayout());
		
		//**create headerPanel
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		headerPanel.add(headerLabel);
		
		//**create boardPanel
		int rows = brd.getHeight();
		int cols = brd.getWidth();
		selected = 0;
		boardPanel.setLayout(new FlowLayout());
		
		//**creates player up Text Field
		whosup = new JTextField(players.get(currPlayer).getName());
		confirmPanel.add(whosup,BorderLayout.SOUTH);
		
		//Special Card Indicators
		confirm = new JButton("End Turn");
		confirm.setEnabled(false);
		confirm.addActionListener(e -> {
			selected = 0;
			System.out.println();
			System.out.println("player " + (currPlayer+1) + " just went");
			System.out.println();
			String r = brd.getRuleFromCards(x1, y1, x2, y2);
			if(x1 == x2 && y1 == y2){
				System.out.println("same card was selected");
			}
			else{
				if(r.contains("reverse")){
					forwards ^= true;
					
				}
				if(r.contains("skip")){
					incrementTurn();
				}
				if(r.contains("bonus")){
					players.get(currPlayer).addToScore(4);
				}
				
				if(r.contains("minus")){
					players.get(currPlayer).addToScore(-4);
				}
				if(r.contains("deathdeath")){
					players.get(currPlayer).setStillInGame();
				}
				players.get(currPlayer).addToScore(brd.select(x1, y1, x2, y2));
			}
			
			incrementTurn();
		
			updateBoardWithCorrectImages(x1, y1, x2, y2);
			updateScorePanel(currPlayer);
			
			if (brd.getNumPairs() <= 0) {
				new WinnerGUI(determineWinner());
			}
			
			//**UPDATE SCORE PANEL
			x1 = -1;
			y1 = -1;
			x2 = -1;
			y2 = -1;
			
		});
		
		confirmPanel.add(confirm);
		/*JButton endGame = new JButton("End Game");
		endGame.setEnabled(brd.getNumPairs() > 0);
		endGame.addActionListener(e -> {
			//OPEN END GAME WINDOW
		});*/
		
		//Initializes things on screen
		createBoardButtons();
		createScorePanel();
		Random r = new Random();
		currPlayer = 0; //r.nextInt(players.size());
		
		//**add panels to mainPanel
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		mainPanel.add(scorePanel, BorderLayout.EAST);
		mainPanel.add(confirmPanel, BorderLayout.SOUTH);

		//DO THE THINGS
		playerOneName.setBackground(new Color(180, 255, 255));
		
		
		add(mainPanel);
		setVisible(true);
		
	}
	
	/**Changes the currPlayer to next player
	 * 
	 */
	private void incrementTurn(){
		if(forwards){
			currPlayer++;
			currPlayer %= players.size();
		}else{
			currPlayer += players.size() - 1;
			currPlayer %= players.size();
		}
		if(!players.get(currPlayer).inGame()){
			//incrementTurn();
		}
		if (selected != 2) {
			confirm.setEnabled(false);
		} else {
			confirm.setEnabled(true);
		}
		whosup.setText(players.get(currPlayer).getName());
		playerup();
	}
	
	/**Updates the scorePanel on the board the names and scores and puts them on the scorePanel
	 * 
	 */
	private void createScorePanel(){
		scorePanel = new JPanel();
		playerPanel = new JPanel();
		scorePanel.setLayout(new GridLayout(players.size(), 0, -7, -7));
		playerPanel.setLayout(new BorderLayout());
		
		//**add player 1
		playerOneName = new JButton(players.get(0).getName());
		playerOneName.setFont(new Font("Courier", Font.PLAIN, 16));
		playerOneName.setEnabled(false);
		String score1 = Integer.toString(players.get(0).getScore()); 
		playerOneScore = new JButton(score1);
		playerOneScore.setEnabled(false);
		scorePanel.add(playerOneName);
		scorePanel.add(playerOneScore);
		//**add player 2
		playerTwoName = new JButton(players.get(1).getName());
		playerTwoName.setFont(new Font("Courier", Font.PLAIN, 16));
		playerTwoName.setEnabled(false);
		String score2 = Integer.toString(players.get(1).getScore()); 
		playerTwoScore = new JButton(score2);
		playerTwoScore.setEnabled(false);
		scorePanel.add(playerTwoName);
		scorePanel.add(playerTwoScore);
		
		//**add player 3 and 4
		if (players.size() >= 3) {
			playerThreeName = new JButton(players.get(2).getName());
			playerThreeName.setFont(new Font("Courier", Font.PLAIN, 16));
			playerThreeName.setEnabled(false);
			String score3 = Integer.toString(players.get(2).getScore()); 
			playerThreeScore = new JButton(score3);
			playerThreeScore.setEnabled(false);
			scorePanel.add(playerThreeName);
			scorePanel.add(playerThreeScore);
		} if (players.size() == 4) {
			playerFourName = new JButton(players.get(3).getName());
			playerFourName.setFont(new Font("Courier", Font.PLAIN, 16));
			playerFourName.setEnabled(false);
			String score4 = Integer.toString(players.get(3).getScore()); 
			playerFourScore = new JButton(score4);
			playerFourScore.setEnabled(false);
			scorePanel.add(playerFourName);
			scorePanel.add(playerFourScore);
		}
	}
	
	private void updateScorePanel(int currPlayer) {
		System.out.println((currPlayer + 1) + " got " + players.get(currPlayer).getScore() + " points.");
		String score1 = Integer.toString(players.get(0).getScore());
		playerOneScore.setText(score1);
		String score2 = Integer.toString(players.get(1).getScore());
		playerTwoScore.setText(score2);
		if (players.size() >= 3) {
			String score3 = Integer.toString(players.get(2).getScore());
			playerThreeScore.setText(score3);
		} else if (players.size() == 4) {
			String score4 = Integer.toString(players.get(3).getScore());
			playerFourScore.setText(score4);
		}
	}
	
	/**Creates the 2D board of JButtons and sets their images and actions
	 * 
	 */
	private void createBoardButtons(){
		int rows = brd.getHeight();
		int cols = brd.getWidth();
		boardButton = new JButton[rows][cols];
		selected = 0;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				int ci = i;
				int cj = j;
				boardButton[i][j] = new JButton();
				boardButton[i][j].setIcon(brd.getImageFromCard(j, i));
				boardButton[i][j].addActionListener(e -> {
					if(selected < 2){
						boardButton[ci][cj].setIcon(brd.displayCard(cj, ci));
					}
					selected++;
					if(selected == 1){
						x1 = cj;
						y1 = ci;
					}else if(selected == 2){
						confirm.setEnabled(true);
						x2 = cj;
						y2 = ci;
					}
				});
				boardPanel.add(boardButton[i][j]);
				confirm.setEnabled(false);
			}
		}
	}
	
	/**Updates the board of buttons with the correct images from each card
	 * 
	 */
	private void updateBoardWithCorrectImages(int x1, int y1, int x2, int y2){
		int rows = brd.getHeight();
		int cols = brd.getWidth();
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				boardButton[i][j].setIcon(brd.getImageFromCard(j, i));
				
			}
		}
	}
	
	public String determineWinner() {
		Player largest = players.get(0);
		if (largest.getScore() < players.get(1).getScore()) {
			largest = players.get(1);
			if (players.size() >= 3) {
				if (largest.getScore() < players.get(2).getScore()) {
					largest = players.get(2);
				}
			} else if (players.size() == 4) {
				if (largest.getScore() < players.get(3).getScore()) {
					largest = players.get(3);
				}
			}
		}
		return largest.getName();
	}
public void playerup(){
		
		if(players.size() == 2){
			if(currPlayer+1 == 1){
				playerOneName.setBackground(new Color(180, 255, 255));
				playerTwoName.setBackground(null);
				
			}
			if(currPlayer+1 == 2){
				playerOneName.setBackground(null);
				playerTwoName.setBackground(new Color(180, 255, 255));
			}
			
		}
		if(players.size() == 3){
			if(currPlayer+1 == 1){
				playerOneName.setBackground(new Color(180, 255, 255));
				playerTwoName.setBackground(null);
				playerThreeName.setBackground(null);
			}
			if(currPlayer+1 == 2){
				playerOneName.setBackground(null);
				playerTwoName.setBackground(new Color(180, 255, 255));
				playerThreeName.setBackground(null);
			}
			if(currPlayer+1 == 3){
				playerOneName.setBackground(null);
				playerTwoName.setBackground(null);
				playerThreeName.setBackground(new Color(180, 255, 255));
			}
			
		}
		if(players.size() == 4){
			if(currPlayer+1 == 1){
				playerOneName.setBackground(new Color(180, 255, 255));
				playerTwoName.setBackground(null);
				playerThreeName.setBackground(null);
				playerFourName.setBackground(null);
			}
			if(currPlayer+1 == 2){
				playerOneName.setBackground(null);
				playerTwoName.setBackground(new Color(180, 255, 255));
				playerThreeName.setBackground(null);
				playerFourName.setBackground(null);
			}
			if(currPlayer+1 == 3){
				playerOneName.setBackground(null);
				playerTwoName.setBackground(null);
				playerThreeName.setBackground(new Color(180, 255, 255));
				playerFourName.setBackground(null);
			}
			if(currPlayer+1 == 4){
				playerOneName.setBackground(null);
				playerTwoName.setBackground(null);
				playerThreeName.setBackground(null);
				playerFourName.setBackground(new Color(180, 255, 255));
			}
		}
	}
}