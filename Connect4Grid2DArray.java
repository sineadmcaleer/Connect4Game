
public class Connect4Grid2DArray implements Connect4Grid {
	public static final char BLANK = ' ';
	public static final char PLAYER1_PIECE = '+';
	public static final char PLAYER2_PIECE = 'O';
	public static final int BOARD_WIDTH = 7;
	public static final int BOARD_HEIGHT = 6;
	static char[][] board = new char[BOARD_HEIGHT][BOARD_WIDTH];

	public void emptyGrid() {
		for(int i = 0; i < BOARD_HEIGHT; i++)
		{
			for(int j = 0; j < BOARD_WIDTH; j++)
				board[i][j] = BLANK;
		}	
	}

	public String toString(){
		String s = "";
		if(board!=null)
		{
			for(int i = 0; i < BOARD_HEIGHT; i++)
			{
				for(int j = 0; j < BOARD_WIDTH; j++)
				{
					s = s + "|"+board[i][j];
					if (j == BOARD_WIDTH-1)
						s = s + "|";
				}
				s = s + "\n";
			}
			s = s + "---------------";
		}
		return s;
	}

	public boolean isValidColumn(int column) {
		if (!isColumnFull(column)&&(column >= 0 && column <= BOARD_WIDTH-1))
			return true;
		else
			return false;
	}

	public boolean isColumnFull(int column) {
		if((column >= 0 && column <= BOARD_WIDTH-1))
		{
			if(board[0][column] != BLANK)
				return true;
		}
		return false;
	}

	public boolean didLastPieceConnect4() {
		if(board!=null)
		{
			for(int j = 0; j < BOARD_WIDTH; j++)				//check by row
			{
				for(int i = 0; i < BOARD_HEIGHT-3; i++)
				{
					if(board[i][j] != BLANK && board[i][j] == board[i+1][j] && 
							board[i+1][j] == board[i+2][j] && board[i+2][j] == board[i+3][j])
						return true;
				}
			}

			for(int i = 0; i <= BOARD_HEIGHT-1 ; i++)			//check by column
			{
				for(int j = 0; j <= BOARD_WIDTH-3; j++)
				{
					if((board[i][j] != BLANK) && (board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2] 
							&& board[i][j+2] == board[i][j+3]))
						return true;
				}
			}

			for(int i = 0; i < BOARD_HEIGHT-3 ; i++)				//check diagonally down
			{
				for(int j = 0; j <BOARD_WIDTH - 3; j++)
				{
					if((board[i][j] != BLANK) && (board[i][j] == board[i+1][j+1] && board[i+1][j+1] == board[i+2][j+2] 
							&& board[i+2][j+2] == board[i+3][j+3]))
						return true;
				}
			}

			for(int i = BOARD_HEIGHT-1; i > 2 ; i--)				//check diagonally up	
			{
				for(int j = 0; j < BOARD_WIDTH - 3; j++)
				{
					if((board[i][j] != BLANK) && (board[i-1][j+1] == board[i][j] && board[i-1][j+1] == board[i-2][j+2] 
							&& board[i-2][j+2]  == board[i-3][j+3]))
						return true;
				}
			}
		}
		return false;
	}

	public boolean isGridFull() {
		boolean full = true;
		if(board!= null)
		{
			for(int i = 0; i < BOARD_HEIGHT; i++)
			{
				for(int j = 0; j < BOARD_WIDTH; j++)
					if(board[i][j] == BLANK)
						full = false;
			}
		}
		return full;
	}

	public void dropPiece(ConnectPlayer player, int column){
		if(board!=null)
		{
			if (isValidColumn(column) && !isGridFull())
			{
				for(int i = BOARD_HEIGHT-1; i >= 0; i--)
				{
					if(board[i][column] == BLANK)
					{
						if(Connect4Game.playerOnesTurn)
							board[i][column] = PLAYER1_PIECE;	
						if(!Connect4Game.playerOnesTurn)
							board[i][column] = PLAYER2_PIECE;	
						break;
					}
				}
			}		
		}
	}
}
