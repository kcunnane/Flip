package dataStructures;

import javax.swing.ImageIcon;

public class SpecialCard extends Card{
	
	//A String name for the rule that the special card applies to. The board class/whatever class keeps track of taking turns will check for the rules
	private String rule;
	
	/**Empty Constructor--
	 * Do not use
	 * 
	 */
	public SpecialCard(){
		super();
	}
	
	/**Constructor--
	 * Input: an Image for the front of the card, a String name to refer to it, and a String color to indicate what kind of card it is
	 * 
	 * @param front
	 * @param name
	 * @param color
	 */
	public SpecialCard(ImageIcon front, String name, String rule){
		super(front, name, 0);
		setRule(rule.toLowerCase());
		if(this.rule.equals("skip") || this.rule.equals("reverse")){
			super.setScore(3);
		}else if(this.rule.equals("bonus")){
			super.setScore(4);
		}else if(this.rule.equals("minus")){
			super.setScore(-4);
		}else{
			super.setScore(0);
		}
	}
	
	/**Rule assignment--
	 * Input: A string rule in all lower case
	 * 
	 * @param rule
	 */
	public void setRule(String rule){
		this.rule = rule;
	}
	
	/**Color getter--
	 * Output: the all lower case version of the rule of the card
	 * 
	 * @return
	 */
	public String getRule(){
		return rule;
	}
}
