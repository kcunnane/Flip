package dataStructures;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Board {
	private Card[][] cardBoard;
	private int width;
	private int height;
	private ArrayList<Card> cardList;
	private int numPairs;
	
	/**Empty constructor--
	 * Do not use
	 * 
	 */
	public Board(){
		cardBoard = new Card[0][0];
	}
	
	/**Constructor--
	 * Input: integer for number of players.
	 * 
	 * @param numOfPlayers
	 */
	public Board(int numOfPlayers){
		height = 8;
		width = 2 * numOfPlayers - 1;
		cardBoard = new Card[width][height];
		createCards(numOfPlayers);
		if(numOfPlayers == 2){
			numPairs = 10;
		}else if(numOfPlayers == 3){
			numPairs = 14;
		}else if(numOfPlayers == 4){
			numPairs = 19;
		}
	}
	
	/**Fills an ArrayList with Cards according to player size and using a predefined array of cards--
	 * Input: the number of players
	 * 
	 * @param numOfPlayers
	 */
	private void createCards(int numOfPlayers){
		cardList = new ArrayList<Card>();
		if(numOfPlayers == 2){
			//4 pair purple
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple1.png"), "P1", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple1.png"), "P1", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple2.png"), "P2", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple2.png"), "P2", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple3.png"), "P3", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple3.png"), "P3", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple4.png"), "P4", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple4.png"), "P4", "purple"));
			//3 pair green
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green1.png"), "G1", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green1.png"), "G1", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green2.png"), "G2", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green2.png"), "G2", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green3.png"), "G3", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green3.png"), "G3", "green"));
			//2 pair yellow
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow1.png"), "Y1", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow1.png"), "Y1", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow2.png"), "Y2", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow2.png"), "Y2", "yellow"));
			//1 pair blue
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue1.png"), "B1", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue1.png"), "B1", "blue"));
			
			//1 skip
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/skip1.png"), "S1", "skip"));
			//1 reverse
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/reverse1.png"), "R1", "reverse"));
			//1 bonus
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/bonus1.png"), "E1", "bonus"));
			//1 minus
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/minus1.png"), "M1", "minus"));
			//0 death
		}else if(numOfPlayers == 3){
			//5 pair purple
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple1.png"), "P1", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple1.png"), "P1", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple2.png"), "P2", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple2.png"), "P2", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple3.png"), "P3", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple3.png"), "P3", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple4.png"), "P4", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple4.png"), "P4", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple5.png"), "P5", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple5.png"), "P5", "purple"));
			//4 pair 1 single green
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green1.png"), "G1", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green1.png"), "G1", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green2.png"), "G2", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green2.png"), "G2", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green3.png"), "G3", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green3.png"), "G3", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green4.png"), "G4", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green4.png"), "G4", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green5.png"), "G5", "green"));
			//3 pair 1 single yellow
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow1.png"), "Y1", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow1.png"), "Y1", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow2.png"), "Y2", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow2.png"), "Y2", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow3.png"), "Y3", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow3.png"), "Y3", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow4.png"), "Y4", "yellow"));
			//2 pair 2 single blue
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue1.png"), "B1", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue1.png"), "B1", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue2.png"), "B2", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue2.png"), "B2", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue3.png"), "B3", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue4.png"), "B4", "blue"));
			
			//1 skip
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/skip1.png"), "S1", "skip"));
			//1 reverse
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/reverse1.png"), "R1", "reverse"));
			//2 bonus
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/bonus1.png"), "E1", "bonus"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/bonus2.png"), "E2", "bonus"));
			//2 minus
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/minus1.png"), "M1", "minus"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/minus2.png"), "M2", "minus"));
			//2 death
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/death1.png"), "D1", "death"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/death1.png"), "D1", "death"));
		}else if(numOfPlayers == 4){
			//8 pair purple
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple1.png"), "P1", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple1.png"), "P1", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple2.png"), "P2", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple2.png"), "P2", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple3.png"), "P3", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple3.png"), "P3", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple4.png"), "P4", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple4.png"), "P4", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple5.png"), "P5", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple5.png"), "P5", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple6.png"), "P6", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple6.png"), "P6", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple7.png"), "P7", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple7.png"), "P7", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple8.png"), "P8", "purple"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Purple/purple8.png"), "P8", "purple"));
			//5 pair 1 single green
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green1.png"), "G1", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green1.png"), "G1", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green2.png"), "G2", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green2.png"), "G2", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green3.png"), "G3", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green3.png"), "G3", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green4.png"), "G4", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green4.png"), "G4", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green5.png"), "G5", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green5.png"), "G5", "green"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Green/green6.png"), "G6", "green"));
			//4 pair 2 single yellow
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow1.png"), "Y1", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow1.png"), "Y1", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow2.png"), "Y2", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow2.png"), "Y2", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow3.png"), "Y3", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow3.png"), "Y3", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow4.png"), "Y4", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow4.png"), "Y4", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow5.png"), "Y5", "yellow"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Yellow/yellow6.png"), "Y6", "yellow"));
			//2 pair 3 single blue
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue1.png"), "B1", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue1.png"), "B1", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue2.png"), "B2", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue2.png"), "B2", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue3.png"), "B3", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue4.png"), "B4", "blue"));
			cardList.add(new ColorCard(new ImageIcon("src/Cards/Blue/blue5.png"), "B5", "blue"));
			
			//2 skip
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/skip1.png"), "S1", "skip"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/skip1.png"), "S1", "skip"));
			//2 reverse
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/reverse1.png"), "R1", "reverse"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/reverse1.png"), "R1", "reverse"));
			//3 bonus
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/bonus1.png"), "E1", "bonus"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/bonus2.png"), "E2", "bonus"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/bonus3.png"), "E3", "bonus"));
			//3 minus
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/minus1.png"), "M1", "minus"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/minus2.png"), "M2", "minus"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/minus3.png"), "M3", "minus"));
			//2 death
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/death1.png"), "D1", "death"));
			cardList.add(new SpecialCard(new ImageIcon("src/Cards/Special/death1.png"), "D1", "death"));
		}
		fillBoard();
	}
	
	/**Fills the board with cards-- Moves cards from the list to the board. List is empty afterward.
	 * 
	 */
	private void fillBoard(){
		Random r = new Random();
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				int loc = r.nextInt(cardList.size());
				cardBoard[j][i] = cardList.get(loc);
				cardList.remove(loc);
			}
		}
	}
	
	/**Display a given Card--
	 * Input: 2D coordinates for a card on the board (0-based indexing)
	 * Output: the front Image of that card without modifying anything
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public ImageIcon displayCard(int x, int y){
		return cardBoard[x][y].display();
	}
	
	/**Gets the current display of the card--
	 * Input: 2D coordinates for a card on the board
	 * Output: the current display of that card (front if flipped, back if not)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public ImageIcon getImageFromCard(int x, int y){
		return cardBoard[x][y].getImage();
	}
	
	/**Modifies the board based on the player's selection and returns the score to add (0 if not a match)--
	 * Input: the 2D coordinates for two cards on the board
	 * Output: flips the two cards if they are a match, returns the score to add to the player
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public int select(int x1, int y1, int x2, int y2){
		if(cardBoard[x1][y1].isFlipped() || cardBoard[x2][y2].isFlipped()){
			//One of the cards has already been selected. This should never execute.
			return 0;
		}else if(cardBoard[x1][y1].getName().equals(cardBoard[x2][y2].getName())){
			//It's a match.
			cardBoard[x1][y1].flip();
			cardBoard[x2][y2].flip();
			if(cardBoard[x1][y1] instanceof ColorCard){
				numPairs--;
			}
			return cardBoard[x1][y1].getScore();
		}else{
			return 0;
		}
	}
	
	/**Number of pairs remaining getter--
	 * Output: the number of ColorCard pairs left in the game. When this equals 0 the game should end
	 * 
	 * @return
	 */
	public int getNumPairs(){
		return numPairs;
	}
	
	/**Returns the rule from the cards selected--
	 * Input: two 2D coordiantes of the cards looked at
	 * Output: a String for the rule of the cards. "" if ColorCard with no special rule.
	 * "bonus" if bonus card. "reverse" for reverse card. "skip" for skip card. "minus" 
	 * for minus card. "death" for a death card ("CHECK FOR "deathdeath" before loss). If both cards are SpecialCards, then the rules will be concatinated
	 * into a single String (ex. "reverseskip").
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public String getRuleFromCards(int x1, int y1, int x2, int y2){
		String special = "";
		if(cardBoard[x1][y1] instanceof SpecialCard){
			SpecialCard temp = (SpecialCard) cardBoard[x1][y1];
			special += temp.getRule();
			if(!cardBoard[x1][y1].isFlipped() && !temp.getRule().equals("death")){
				cardBoard[x1][y1].flip();
			}
		}
		if(cardBoard[x2][y2] instanceof SpecialCard){
			SpecialCard temp = (SpecialCard) cardBoard[x2][y2];
			special += temp.getRule();
			if(!cardBoard[x2][y2].isFlipped() && !temp.getRule().equals("death")){
				cardBoard[x2][y2].flip();
			}
		}
		return special;
	}
	
	/**Bonus or Minus score getter--
	 * Input: the x, y coordinates of a card selected (to be used only if the card is "bonus" or "minus")
	 * Output: the score associated with the card in question
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int getScoreFromCard(int x, int y){
		return cardBoard[x][y].getScore();
	}
	
	/**Width getter--
	 * Output: int of width of board
	 * 
	 * @return
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * Height getter--
	 * Output: height of board
	 * @return
	 */
	public int getHeight(){
		return height;
	}
	
	/**Returns if a particular card is flipped--
	 * Input: an x and y location for the card
	 * Output: the boolean if it is flipped or not
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isFlipped(int x, int y){
		return cardBoard[x][y].isFlipped();
	}
}
