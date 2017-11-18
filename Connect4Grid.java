
public interface Connect4Grid {
	abstract public void emptyGrid();
	abstract public String toString();
	abstract public boolean isValidColumn(int column);
	abstract public boolean isColumnFull(int column);
	abstract public void dropPiece(ConnectPlayer player, int column);
	abstract public boolean didLastPieceConnect4();
	abstract public boolean isGridFull();  
}

