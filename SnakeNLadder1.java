import SnakeAndLadders.RollDice;
import SnakeAndLadders.Player;
// importing packages
import java.util.Scanner;

public class SnakeNLadder1 {
    public static void main(String[] args) {
        SnakeNLadder s = new SnakeNLadder();
        s.startGame();
    }
}

class SnakeNLadder {
    RollDice rd = new RollDice();
    Player p = new Player();
    {
        // contain snakes heads and tails
        p.insertSnake(99, 54);
        p.insertSnake(70, 55);
        p.insertSnake(52, 42);
        p.insertSnake(25, 2);
        p.insertSnake(95, 72);
        
        // ladders
        p.insertladder(6, 25);
        p.insertladder(11, 40);
        p.insertladder(60, 85);
        p.insertladder(46, 90);
        p.insertladder(17, 69);
    }

    public void startGame() {
        int player1 = 0, player2 = 0;
        int currentPlayer = -1;
        Scanner s = new Scanner(System.in);
        String str;
        int diceValue = 0;
        do {
            System.out.println(currentPlayer == -1 ? "\n\nFIRST PLAYER TURN" : "\n\nSECOND PLAYER TURN");
            System.out.println("Press r to roll Dice");
            str = s.next();

            diceValue = rd.rollDice();

            if (currentPlayer == -1) {
                player1 = p.calculatePlayerValue(player1, diceValue);
                System.out.println("First Player :: " + player1);
                System.out.println("Second Player :: " + player2);
                System.out.println("------------------");
                if (p.isWin(player1)) {
                    System.out.println("congratulation! First player wins");
                    return;
                }
            } else {
                player2 = p.calculatePlayerValue(player2, diceValue);
                System.out.println("First Player :: " + player1);
                System.out.println("Second Player :: " + player2);
                System.out.println("------------------");
                if (p.isWin(player2)) {
                    System.out.println("congratulation! Second player wins");
                    return;
                }
            }
            currentPlayer = -currentPlayer;
        } while ("r".equals(str));
    }
}
