package SnakeAndLadders;
// importing packages
import java.util.Random;

// RollDice class 
public class RollDice {
	
    public int rollDice()
	{
		int n = 0;
		Random r = new Random();
		n=r.nextInt(7);
		return (n==0?1:n);
	}
}
