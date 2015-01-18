import java.util.*;

public class BattleShipGame {
	private GameHelper helper = new GameHelper();
	private ArrayList<BattleShip> battleShipsList = new ArrayList<BattleShip>();
	int numOfGuesses = 0;
	
	public void setUpGame() {
		BattleShip one = new BattleShip();
		one.setName("USS Enterprise");
		
		BattleShip two = new BattleShip();
		two.setName("Millennium Falcon");
		
		BattleShip three = new BattleShip();
		three.setName("Hyperion");
		
		battleShipsList.add(one);
		battleShipsList.add(two);
		battleShipsList.add(three);
		
		System.out.println("your goal is to sink three ships");
		System.out.println("USS Enterprise, Millennium Falcon, and Hyerion");
		System.out.println("try to sink all of them using fewest guesses");
		
		for (BattleShip shipToSet : battleShipsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			shipToSet.setLocationCells(newLocation);
		}
	}
	
	private void startPlaying() {
		while(!battleShipsList.isEmpty()) {
			String userGuess = helper.getUserInput("enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		
		for (BattleShip shipToTest : battleShipsList) {
			result = shipToTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if (result.equals("kill")) {
				battleShipsList.remove(shipToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("Well done! All ships are dead!");
	}
	
	public static void main(String[] args) {
		BattleShipGame game = new BattleShipGame();
		game.setUpGame();
		game.startPlaying();
	}
}
