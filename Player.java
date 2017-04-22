public class Player{
	public String name;		//player's name
	public int score;		//player's score
	public int playerNum;   //player's number in game
	public boolean stillInGame; //true if player is still in the game (has't gotten a death card)
	
	//default constructor
	public Player(){
		score = 0;
		stillInGame = true;
		name = "";
		playerNum = 0;
	}
	
	//constructor
	public Player(String n, int playerNumber){
		score = 0;
		stillInGame= true;
		name = n;
		playerNum = playerNumber;
	}
	
	//set player's name
	public void setName(String n){
		name = n;
	}
	
	//return player's name
	public String getName(){
		return name;
	}
	
	//set player's score
	public void setScore(int num){
		score = num;
	}
	
	//get player's score
	public int getScore(){
		return score;
	}
	
	//add a value to the player's score
	public void addToScore(int n){
		score += n;
	}
	
	//set player number
	public void setPlayerNum(int n){
		playerNum = n;
	}
	
	//get player number
	public int getPlayerNum(){
		return playerNum;
	}
	
	//returns true if player has not gotten a death card
	public boolean inGame(){
		return stillInGame;
	}
	
	//changes still in game to false
	public void setStillInGame(){
		stillInGame = false;
	}
}