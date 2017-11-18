import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer{
	public int column;
	public void makeMove(){
		Scanner input = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter column (Player 2): ");
			if (input.hasNextInt())
			{
				column = input.nextInt() - 1;
				if(grid.isValidColumn(column))
					break;
				else
					System.out.println("Invalid entry. Try again.");
			}
			else if((!input.hasNextInt()))
			{
				System.out.println("Invalid entry. Try again.");
				input.next();
			}
		}
	}

	public int playerColumn(){
		return column;
	}
}
