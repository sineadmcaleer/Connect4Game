import java.util.Scanner;

public class Connect4Game {
	public static boolean playerOnesTurn = true;
	public static Scanner input = new Scanner(System.in);
	public static ConnectPlayer player = null;
	public static Connect4Grid2DArray grid = new Connect4Grid2DArray();
	public static int column;
	public static boolean winner = false;
	public static void main(String[] args) {
		player = selectPlayer();
		if (player != null)
		{
			grid.emptyGrid();
			System.out.println(grid.toString());
			while(!grid.isGridFull())
			{
				if(winner == false)
				{
					makeMove();
					grid.dropPiece(player, column);
					System.out.println(grid.toString());
					checkWinner();
					isItPlayerOnesTurn();
				}
				if(winner == false)
				{
					player.makeMove();
					grid.dropPiece(player, player.playerColumn());
					System.out.println(grid.toString());
					checkWinner();
					isItPlayerOnesTurn();
				}
			}
			if(grid.isGridFull())
			{
				System.out.println("There is no winner.");
			}
		}
	}

	public static int getPlayer(boolean playerOnesTurn)
	{
		int player = 1;
		if (!playerOnesTurn)
			player = 2;
		return player;
	}

	public static boolean isItPlayerOnesTurn(){
		if (playerOnesTurn == false)
			playerOnesTurn = true;
		else if (playerOnesTurn == true)
			playerOnesTurn = false;
		return playerOnesTurn;
	}

	public static ConnectPlayer selectPlayer(){

		System.out.println("Enter 1 to begin game against another player.");
		System.out.println("Enter 2 to begin game against the computer");
		if(input.hasNextInt())
		{
			int userInput = input.nextInt();
			if(userInput == 1)
				player = new C4HumanPlayer();
			else if(userInput == 2)
				player = new C4RandomAIPlayer();
			else
				System.out.println("Invalid entry.");
		}
		else
			System.out.println("Invalid entry.");
		return player;
	}

	public static void makeMove(){
		while(true)
		{
			System.out.println("Enter column (Player 1): ");
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

	public static void checkWinner(){				
		if (grid.didLastPieceConnect4())
		{
			System.out.println("Game has been won by Player " + getPlayer(playerOnesTurn) + ".");
			winner = true;
		}
	}
}
