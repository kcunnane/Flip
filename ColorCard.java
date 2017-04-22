package dataStructures;

import javax.swing.ImageIcon;

public class ColorCard extends Card{
	
	//A string name of a color. Let's put the entire front side of the card on an image and put the images in files based on color,
	// that way we can just use the String color to find the image, and just use the getImage() to display it.
	private String color;
	
	/**Empty Constructor--
	 * Do not use
	 * 
	 */
	public ColorCard(){
		super();
	}
	
	/**Constructor--
	 * Input: an Image for the front of the card, a String name to refer to it, and a String color to indicate what kind of card it is
	 * 
	 * @param front
	 * @param name
	 * @param color
	 */
	public ColorCard(ImageIcon front, String name, String color){
		super(front, name, 0);
		setColor(color.toLowerCase());
		if(this.color.equals("purple")){
			super.setScore(1);
		}else if(this.color.equals("green")){
			super.setScore(2);
		}else if(this.color.equals("yellow")){
			super.setScore(3);
		}else if(this.color.equals("blue")){
			super.setScore(4);
		}
	}
	
	/**Color assignment--
	 * Input: A string color in all lower case
	 * 
	 * @param color
	 */
	public void setColor(String color){
		this.color = color;
	}
	
	/**Color getter--
	 * Output: the all lower case version of the color of the card
	 * 
	 * @return
	 */
	public String getColor(){
		return color;
	}
}
