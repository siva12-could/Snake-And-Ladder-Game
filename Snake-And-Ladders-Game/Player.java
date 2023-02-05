package SnakeAndLadders;
// importing packages
import java.util.*;

// Player class
public class Player {

	final static int WINPOINT = 100;

	Map<Integer, Integer> snake = new HashMap<Integer, Integer>();
	Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();

	public void insertSnake(int head, int tail) {
		snake.put(head, tail);
	}

	public void insertladder(int bottom, int top) {
		ladder.put(bottom, top);
	}

	public int calculatePlayerValue(int player, int diceValue) {
		player = player + diceValue;

		if (player > WINPOINT) {
			player = player - diceValue;
			return player;
		}

		if (null != snake.get(player)) {
			System.out.println("swallowed by snake");
			player = snake.get(player);
		}

		if (null != ladder.get(player)) {
			System.out.println("climb up the ladder");
			player = ladder.get(player);
		}
		return player;
	}

	public boolean isWin(int player) {
		return WINPOINT == player;
	}
}
