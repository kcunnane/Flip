package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class RulesGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RulesGUI frame = new RulesGUI();
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
	public RulesGUI() {
		super("RULES OF FLIP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1047, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea txtrFlipDescriptionThe = new JTextArea();
		txtrFlipDescriptionThe.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrFlipDescriptionThe.setText("Flip\r\nDescription:\r\nThe game starts with a set number of cards\n"
				+ "all face down, each turn a player will select two cards to turn over,\n"
				+ "if they are pairs you keep them face up and add your score. If the cards were\n"
				+ "not a pair then the cards are flipped back to face down. \r\n"
				+ "\r\nObjective:\r\n"
				+ "The goal is to remember the location of pairs and turn them over to get points,\n"
				+ "to win one must end the game with the most amount of points.\r\n"
				+ "\r\nHow to play\r\n"
				+ "1.\tSelect the Size (based off given sizes), number of players that are playing \r\n"
				+ "2.\tDecide who goes first by a roll of the dice\r\n"
				+ "3.\tFirst person should select two cards\r\n"
				+ "\ta.\tIf it\u2019s a match then that person gets a point and the cards\n"
				+ "			are left face up and they go again\r\n"
				+ "\tb.\tIf it\u2019s not a match then the cards are flipped back over and\n "
				+ "		the game continues\r\n"
				+ "4.\tRepeat until every card is face up.\r\n"
				+ "5.\tIf a special card (i.e. Bonus, Reverse) is drawn check its ability and continue from there.\r\n"
				+ "\r\nTypes of Cards\r\n\u2022\tPurple: Worth 1 point\r\n"
				+ "\u2022\tGreen: Worth 2 points\r\n"
				+ "\u2022\tYellow: Worth 3 points\r\n"
				+ "\u2022\tBlue: Worth 4 points\r\n"
				+ "\u2022\tBonus point: +4 point to the player who flips it\r\n"
				+ "\u2022\tMinus: -4 points to the player who flips it\r\n"
				+ "\u2022\tGet skipped: the player who pulls this card their turn is over\r\n"
				+ "\u2022\tReverse: reverses the order\r\n"
				+ "\u2022\tDeath: if you match two death cards you automatically lose.\r\n"
				+ "\u2022\tDecoy: cards that have no pairs\r\n\r\n\r\n");
		contentPane.add(txtrFlipDescriptionThe, BorderLayout.CENTER);
		setVisible(true);
	}

}
