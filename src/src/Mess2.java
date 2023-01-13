package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class Mess2 {




	public static void main(String[] args) {

		FileIO file = new FileIO();
		//									in.txt out.txt
		File inFile = new File("src/hw004/in.txt");

		ArrayList<Hexagon> list = file.readData(inFile);

		Board board = new Board();/////////////////////////
		for (int i = 0; i < 7; i ++) {
			board.positions.add(new Hexagon());///////////////////
		}

		ArrayList<Hexagon> leftOver = file.readData(inFile);


		File outFile = new File("src/pro.txt");



		try {
			PrintWriter pw = new PrintWriter(outFile);
			solve(board, list, leftOver, pw);/////////////////////////////////////////////////////////////////////

			pw.flush();
			pw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		//		Board board = new Board(list);

		//		System.out.println(board);

		//		if (allColorsMatch(board)) {
		//			System.out.println(board);
		//		}

		//		Board board = new Board(list.get(0));



		//		solve(board, list, outFile);/////////////////////////////////

		System.out.println("Solutions: " + board.solutionNumber);



	}



	public static void solve(Board board, ArrayList<Hexagon> list, ArrayList<Hexagon> leftOver, PrintWriter pw) {
		///////////////////////////////////////////////////////////////////////////////////// 1, 1)    ALSO timesMethodCAlled		
		solve(board, list, leftOver, 0, 0, pw);
		if (!allColorsMatch(board) && leftOver.size() == 0) {
			System.out.println("No Solution");
		}
	}






	public static void solve(Board board, ArrayList<Hexagon> list, ArrayList<Hexagon> leftOver, int boardPosition, int listPosition, PrintWriter pw) {


		//		System.out.println("METHOD_CALLED: " + (board.timesThisMethodWasCalled - 1));
		board.timesThisMethodWasCalled++;


		//Base Case
		if (allColorsMatch(board)) {
			/////////////////////////////////////////////////////////////////////////////////// Solution #...
			board.solutionNumber = board.solutionNumber.add(new BigInteger("1"));
			//			System.out.println("SOLVED~~~~~~~~~~\n~~~~~~~~~~~\n~~~~~~~~~~\n~~~~~~~\n~~" + board);

			//			if (board.solutionNumber == 1) {
			System.out.println("Solution #" + board.solutionNumber + ":");
			System.out.println(board);
			//			
		}























		//recursive case
		else {

			for (int i = listPosition; i < list.size(); i ++) {

				

				//==========================================================
//				pw.println("CURRENT i VALUE: " + i);
//				pw.println("v v v v  v v v v v  v v v v v v  BEFORE PLACING v v v v  "
//						+ "v v v v v v  v v v v v v v v");
//				pw.println("LISTTTTTTTTTTT: " + list.size());
//				for (int k = 0; k < list.size(); k++) {
//					pw.println("     " + list.get(k));
//				}
//				pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^ "
//						+ "^ ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
				//==========================================================


				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//switch out center tile with whatever is left over
				if (boardPosition == 0 && leftOver.size() > 0 
						//						&& leftOver.get(0).equals(list.get(i))
						) {

					board.positions.set(boardPosition, leftOver.get(0));
					board.positions.get(boardPosition).positionNumber = boardPosition;

					for (int j = 0; j < list.size(); j++) {
						if (list.get(j).equals(leftOver.get(0))) {
							list.remove(j);
						}
					}

					leftOver.remove(0);
					solve(board, list, leftOver, boardPosition + 1, listPosition, pw);
					//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////					

					//=========================================================
//					pw.println("v v v v  v v v v v  v v v v v v  AFTER PLACING v"
//							+ " v v v  v v v v v v  v v v v v v v v");
//					pw.println("LISTTTTTTTTTTT: " + list.size());
//					for (int k = 0; k < list.size(); k++) {
//						pw.println("     " + list.get(k));
//					}
//					pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^ ^"
//							+ " ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
					//========================================================


					//==========================================================
//					pw.println("=================================CURRENT BOARD 1=="
//							+ "===============================");
//					pw.println(board);
//					pw.println("================================================="
//							+ "================================================");
					//==========================================================
					//==========================================================
//					pw.println("v v v v  v v v v v  v v v v v v  LEFTOVERRR v v "
//							+ "v v  v v v v v v  v v v v v v v v");
//					pw.println("LISTTTTTTTTTTT: " + list.size());
//					for (int k = 0; k < leftOver.size(); k++) {
//						pw.println("     " + leftOver.get(k));
//					}
//					pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^"
//							+ " ^ ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
					//==========================================================

					//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
				}

				else {

					//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
//					for (int k = 0; k < board.spaces; k++) {
//						pw.print("     ");
//					}
//					pw.println("Check if (any colors match)");
					//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

					if (anyColorsMatch(board, list, i, boardPosition)) {
						

						boolean colorMatched = true;

						//add next tile to board at boardPosition
						board.positions.set(boardPosition, list.get(i));
						board.positions.get(boardPosition).positionNumber = boardPosition;

						//==========================================================
//						pw.println("=================================CURRENT BOARD 2=="
//								+ "===============================");
//						pw.println(board);
//						pw.println("================================================="
//								+ "================================================");
						//==========================================================

						//remove from list
						list.remove(i);

						//=========================================================
//						pw.println("v v v v  v v v v v  v v v v v v  AFTER REMOVING 2 v"
//								+ " v v v  v v v v v v  v v v v v v v v");
//						pw.println("LISTTTTTTTTTTT: " + list.size());
//						for (int k = 0; k < list.size(); k++) {
//							pw.println("     " + list.get(k));
//						}
//						pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^ ^"
//								+ " ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
						//========================================================

						//==========================================================
//						pw.println("=================================CURRENT BOARD 3 =="
//								+ "===============================");
//						pw.println(board);
//						pw.println("================================================="
//								+ "================================================");
						//==========================================================

						//rotate it j times to match
						rotateUntilColorsMatch(board, boardPosition);

						//==========================================================
//						pw.println("=================================CURRENT BOARD 4=="
//								+ "===============================");
//						pw.println(board);
//						pw.println("================================================="
//								+ "================================================");
						//==========================================================

						//recurse
						solve(board, list, leftOver, boardPosition + 1, 0, pw);	
					}

				}

				//if last tile tried all colors	
				if (i == list.size() - 1) {
					//backtrack
					
					list.add(0, board.positions.get(boardPosition - 1));
					if (list.get(0).getTileNum() == leftOver.get(0).getTileNum()) {
						leftOver.get(0).setColors(list.get(0).getColors());
					}
					board.positions.set(boardPosition - 1, new Hexagon());
					boardPosition--;

					//Sort list
					for (int a = 0; a < list.size() - 1; a++) {
						if (list.get(a).tileNum > list.get(a + 1).tileNum) {
							Hexagon temp = new Hexagon(list.get(a));
							list.set(a, list.get(a + 1));
							list.set(a + 1, temp);
						}
					}

					solve(board, list, leftOver, boardPosition, 1, pw);
					
				}
				
			}
		}
	}





private static void rotateUntilColorsMatch(Board board, int boardPosition) {

	if (boardPosition == 1){
		do {
			board.positions.get(boardPosition).rotate();
		} while ((board.positions.get(0).colors[0] != 
				board.positions.get(1).colors[3]));
	}

	if (boardPosition == 2) {
		do {
			board.positions.get(boardPosition).rotate();
		} while ((board.positions.get(0).colors[1] != 
				board.positions.get(2).colors[4]) && 
				(board.positions.get(1).colors[2] != 
				board.positions.get(2).colors[5])); 		
	}

	if (boardPosition == 3) {
		do {
			board.positions.get(boardPosition).rotate();
		} while ((board.positions.get(0).colors[2] == 
				board.positions.get(3).colors[5]) && 
				(board.positions.get(2).colors[3] == 
				board.positions.get(3).colors[0]));
	}

	if (boardPosition == 4) {
		do {
			board.positions.get(boardPosition).rotate();
		} while ((board.positions.get(0).colors[3] == 
				board.positions.get(4).colors[0]) &&
				board.positions.get(3).colors[4] ==
				board.positions.get(4).colors[1]);
	}

	if (boardPosition == 5) {
		do {
			board.positions.get(boardPosition).rotate();
		} while ((board.positions.get(0).colors[4] == 
				board.positions.get(5).colors[1]) &&
				board.positions.get(4).colors[5] ==
				board.positions.get(5).colors[2]);
	}

	if (boardPosition == 6) {
		do {
			board.positions.get(boardPosition).rotate();
		} while ((board.positions.get(0).colors[5] == board.positions.get(6).colors[2]) &&
				(board.positions.get(5).colors[0] == board.positions.get(6).colors[3]) && 
				(board.positions.get(6).colors[1] == board.positions.get(1).colors[4]));
	}



}





public static boolean allColorsMatch(Board board) {


	for (int i = 0; i < board.positions.size(); i++) {
		if (board.positions.get(i).getPositionNumber() == 0) {
			return false;
		}
	}

	//THIS IS TO CHECK THOSE ADJACENTTO CENTER TILE (INNER CIRCLE)

	int nextTileColor = 3;
	for (int i = 0, nextTile = 1; i < 6; i++, nextTile++) {

		//LOOP BACK THE NUMBER
		if (nextTileColor > 5) {
			nextTileColor = 0;
		}

		//CHECK IF TILE COLORS MATCH
		if (board.positions.get(0).colors[i] !=
				board.positions.get(nextTile).colors[nextTileColor]) {
			return false;
		}

		nextTileColor++;
	}


	//THIS IS TO CHECK THOSE ADJACENT IN THE OUTER TILES (OUTER CIRCLE)

	int firstOuterTile = 1; 		//1,2,3,4,5,6 -> 0,1,2,3
	int firstOuterTileColor = 2;    //3,4,5,6 -> 0,1,2,3,4,5
	int secondOuterTile = 2;        //3,4,5,6,7 -> 0,1,2,3,4
	int secondOuterTileColor = 5;   //6 -> 0,1,2,3,4,5,6 ->

	for (int i = 0; i < 6; i++) {
		//reset the cycle of numbers
		if (firstOuterTile > 6) {
			firstOuterTile = 0;
		}
		if (firstOuterTileColor > 5) {
			firstOuterTileColor = 0;
		}
		if (secondOuterTile > 5) {
			secondOuterTile = 0;
		}
		if (secondOuterTileColor > 5) {
			secondOuterTileColor = 0;
		}

		if (board.positions.get(firstOuterTile).colors[firstOuterTileColor] != 
				board.positions.get(secondOuterTile).colors[secondOuterTileColor]) {
			return false;
		}

		firstOuterTile++;
		firstOuterTileColor++;
		secondOuterTile++;
		secondOuterTileColor++;
	}

	if ( (board.positions.size() == 7) && 
			(board.positions.get(0).colors[5] != board.positions.get(6).colors[2]) &&
			(board.positions.get(5).colors[0] != board.positions.get(6).colors[3]) && 
			(board.positions.get(6).colors[1] != board.positions.get(1).colors[4])) {
		return false;
	}

	return true;
}

public static boolean anyColorsMatch(Board board, ArrayList<Hexagon> tiles, int i, int boardPosition) {

	for (int j = 0; j < tiles.get(i).colors.length - 1; j++) {

		if (j == tiles.get(i).colors.length - 1) {
			tiles.get(i).rotate();
		}

		if (boardPosition == 0) {
			return true;
		}

		//////////////////////////////////////////////////////////////////////////or boardPosition == 1??
		//if center and north match colors
		//		if ((board.positions.size() == 2) && 
		//				(board.positions.get(0).colors[i - 1] == 
		//				 board.positions.get(i).colors[i+2])) {
		//			
		//			return true;
		//		}
		if ((boardPosition == 1) && 
				(board.positions.get(0).colors[0] == tiles.get(i).colors[j])) {
			return true;
		}


		if ((boardPosition == 2) &&
				(board.positions.get(0).colors[1] == tiles.get(i).colors[j]) && 
				(board.positions.get(1).colors[2] == tiles.get(i).colors[j + 1])) {
			return true;
		}

		if ((boardPosition == 3) &&
				(board.positions.get(0).colors[2] == tiles.get(i).colors[j]) && 
				(board.positions.get(2).colors[3] == tiles.get(i).colors[j + 1])) {
			return true;
		}

		//
		//		if ((board.positions.size() == 4 || board.positions.size() == 5) &&
		//				(board.positions.get(0).colors[i - 1] == 
		//				 board.positions.get(i).colors[i - 3]) &&
		//				 board.positions.get(i - 1).colors[i + 1] ==
		//				 board.positions.get(i).colors[i - 2]) {
		//			return true;
		//		}
		if ((boardPosition == 4) &&
				(board.positions.get(0).colors[3] == tiles.get(i).colors[j]) &&
				board.positions.get(3).colors[4] ==	tiles.get(i).colors[j + 1]) {
			return true;
		}

		if ((boardPosition == 5) &&
				board.positions.get(0).colors[4] == tiles.get(i).colors[j] &&
				board.positions.get(4).colors[5] ==	tiles.get(i).colors[j + 1]) {
			return true;
		}

		//
		if ( (boardPosition == 6) && 
				(board.positions.get(0).colors[5] == tiles.get(i).colors[j]) &&
				(board.positions.get(5).colors[0] == tiles.get(i).colors[j + 1]) && 
				(tiles.get(i).colors[j - 1]) == board.positions.get(1).colors[4])  {
			return true;
		}
	}

	return false;
}

}
