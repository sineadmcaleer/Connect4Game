import java.util.ArrayList;
import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer{

	public void makeMove() {
		System.out.println("The computer has made a move.");
	}

	public int playerColumn() {
		ArrayList<Integer> columnList = new ArrayList<Integer>();
		for(int i = 1; i<7; i++)
			columnList.add(i);
		
		for(int i = 0; i<columnList.size(); i++)
			if(grid.isColumnFull(i))
				columnList.remove(i);						//make an ArrayList of all columns that are not full
		
		Random r = new Random();
		int column = columnList.get(r.nextInt(columnList.size()));
		return column;										//return a randomly selected column from the ArrayList
	}

}
