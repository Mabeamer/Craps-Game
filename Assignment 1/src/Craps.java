import java.util.ArrayList;

public class Craps {
	public static void main (String [] args) {
		//creating our vars for use here
		int wins = 0;
		int losses = 0;
		int point = 0;
		boolean sRolls = false;
		int roundCounter = 0;
		int rollCounter = 0;
		ArrayList<String> msg = new ArrayList<String>();
		//create loop to play game here
		//comeout roll
		//
		for(int j = 0; j < 100000; j++) {
			roundCounter++;
			for(int i = 0; i < 1; i++) {
				rollCounter++;
				int die1 = (int)(Math.random() * 5) + 1;
				int die2 = (int)(Math.random() * 5) + 1;
				if(roundCounter <= 10) {
					msg.add("Round " + roundCounter + " Roll " + rollCounter + " -- Die 1: " + die1 + " , Die 2: " + die2 + " -- Total:" + (die1+die2));
					//msg.add("Point is: " + point);
				}
				if(die1+die2 == 7 || die1+die2 == 11) {
					wins++;
					if(roundCounter <= 10) {
						msg.add("WIN! ------ " + wins + " win(s)     " + losses + " loss(es)");
					}
					//System.out.println("WIN! ------ " + wins + " win(s)     " + losses + " loss(es)");
				}
				else if(die1+die2 == 2 || die1+die2 == 3 || die1+die2 == 12) {
					losses++;
					if(roundCounter <= 10) {
						msg.add("LOSE! ------ " + wins + " win(s)     " + losses + " loss(es)");
					}
				}
				else {
					point = die1+die2;
					//creating sRolls as a check to see if we need to move on to subsequent rolls
					sRolls = true;
					if(roundCounter <= 10 && sRolls == true) {
						msg.add("Point is: " + point);
					}
					
				}
			}
			//subsequent roll starts here
				//creating placeholder as a check and forcing it to start at zero like any for loop would.
			while(sRolls == true) {
				//System.out.println("in the sebsequent loop.");
					int die1 = (int)(Math.random() * 10) + 1;
					int die2 = (int)(Math.random() * 10) + 1;
					if(roundCounter <= 10) {
						msg.add("Round " + roundCounter + " Roll " + rollCounter + " -- Die 1: " + die1 + " , Die 2: " + die2 + " -- Total:" + (die1+die2));
					}
					if(die1+die2 == point) {
						wins++;
						if(roundCounter <= 10) {
							msg.add("WIN! ------ " + wins + " win(s)     " + losses + " loss(es)");
						}
						sRolls = false;
					}else if(die1+die2 == 7) {
						losses++;
						if(roundCounter <= 10) {
							msg.add("LOSE! ------ " + wins + " win(s)     " + losses + " loss(es)");
						}
						sRolls = false;
					}
			}
		
		}
		for(int x = 0; x < msg.size(); x++) {
			System.out.println(msg.get(x));
		}
		System.out.println("OVERALL:");
		System.out.println(wins + " win(s)     " + losses + " loss(es)");
	}
	
	
}
