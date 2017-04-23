package dataStructures;

import javax.swing.ImageIcon;

public abstract class Card implements Comparable<Card>{
	
	//A three letter name indicating the card match
	private String name;
	
	//The images displayed on the card
	private ImageIcon front; //Picture
	private ImageIcon back;  //Generic back
	
	//True = card has been flipped, false = card is still available to select
	private boolean flipped;
	
	//The score added when the card is matched
	private int score;
	
	/**Empty constructor--
	 * Do not use
	 * 
	 */
	public Card(){
		setName("");
		setFrontImage(null);
		setBackImage();
		flipped = false;
		setScore(0);
	}
	
	/**Standard constructor--
	 * Input: an Image for the matching picture to be displayed when the card is selected,
	 *  A String to indicate the code for checking matches, and a score value for when the card is matched
	 * 
	 * @param front
	 * @param name
	 * @param score
	 */
	public Card(ImageIcon front, String name, int score){
		setName(name);
		setFrontImage(front);
		setBackImage();
		flipped = false;
		setScore(score);
	}
	
	/**Name assignment--
	 * Input: a String name that indicates the matching card by having the same name
	 * 
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**Name getter--
	 * Output: returns the name of the card
	 * 
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**Matching image assignment--
	 * Input: an Image that is the picture that the user will use to remeber matching cards
	 * 
	 * @param front
	 */
	public void setFrontImage(ImageIcon front){
		this.front = front;
	}
	
	/**Generic image assignment--
	 * Function: sets the background image to a specific "back of card," unchangable so all cards are identical when not flipped
	 * 
	 */
	public void setBackImage(){
		this.back = new ImageIcon("src/Cards/back.png");
	}
	
	/**Image getter--
	 * Ouput: If flipped, front image is visible, else back image
	 * 
	 * @return
	 */
	public ImageIcon getImage(){
		if(flipped){
			return front;
		}
		return back;
	}
	
	/**Score assignment--
	 * Input: an integer score that represents the number of points that the card is worth
	 * 
	 * @param score
	 */
	public void setScore(int score){
		this.score = score;
	}
	
	/**Score getter--
	 * Output: returns the score value of the card.
	 * 
	 * @return
	 */
	public int getScore(){
		return score;
	}
	
	/**Flips the card
	 * 
	 */
	public void flip(){
		flipped ^= true;
	}
	
	/**Flipped getter--
	 * Output: returns a boolean if the card is flipped or not
	 * 
	 * @return
	 */
	public boolean isFlipped(){
		return flipped;
	}
	
	/**Display method regardless of flip status--
	 * Output: the back Image of the card, regardless if the card is flipped or not
	 * 
	 * @return
	 */
	public ImageIcon display(){
		return front;
	}
	
	/**Comparison method, fulfils the Comparable interface--
	 * Input: Another card object
	 * Output: 0 if the cards are a match, -1 if they are not a match. Note: make sure the cards are initialized in pairs
	 * so they have the same values for all fields. If they only have the same matching name, they will return as a match
	 * even if different.
	 * 
	 */
	public int compareTo(Card other){
		if(this.getName().equals(other.getName())){
			return 0;
		}
		return -1;
	}
}