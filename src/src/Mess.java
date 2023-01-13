package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class Mess {




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
			for (int i = 0; i < list.size(); i++) { 	//for every tile i 
				
				
				if (list.size() > 10) {
					System.exit(1);
				}


				//==========================================================
				pw.println("CURRENT i VALUE: " + i);
				pw.println("v v v v  v v v v v  v v v v v v  BEFORE PLACING v v v v  "
						+ "v v v v v v  v v v v v v v v");
				pw.println("LISTTTTTTTTTTT: " + list.size());
				for (int k = 0; k < list.size(); k++) {
					pw.println("     " + list.get(k));
				}
				pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^ "
						+ "^ ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
				//==========================================================

				//	  add current tile i to center


				//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
				for (int j = 0; j < board.spaces; j++) {
					if (boardPosition == 0) {

					}
					else {
						pw.print("     ");	
					}
				}
				pw.println("Put list(" + list.get(i).tileNum + ") at B(" + 
						boardPosition + ") ||| M_CALL: " + (board.timesThisMethodWasCalled - 1) );
				//				pw.println(board);
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				//				board.positions.set(boardPosition, list.get(i));
				//				board.positions.get(boardPosition).positionNumber = boardPosition;
				
				//switch out center tile with whatever is left over
				if (boardPosition == 0 && leftOver.size() > 0 && leftOver.get(0).equals(list.get(i))) {
					
					board.positions.set(boardPosition, leftOver.get(0));
					board.positions.get(boardPosition).positionNumber = boardPosition;
					leftOver.remove((Hexagon)list.get(i));

				}
				//otherwise, continue adding non-center tiles
				else if (boardPosition > 0){
					board.positions.set(boardPosition, list.get(i));
					board.positions.get(boardPosition).positionNumber = boardPosition;
				}
				else if (list.size() > 12) {
					System.exit(0);
				}
				list.remove(i);
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


				//=========================================================
				pw.println("v v v v  v v v v v  v v v v v v  AFTER PLACING v"
						+ " v v v  v v v v v v  v v v v v v v v");
				pw.println("LISTTTTTTTTTTT: " + list.size());
				for (int k = 0; k < list.size(); k++) {
					pw.println("     " + list.get(k));
				}
				pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^ ^"
						+ " ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
				//========================================================



				//==========================================================
				pw.println("v v v v  v v v v v  v v v v v v  LEFTOVERRR v v "
						+ "v v  v v v v v v  v v v v v v v v");
				pw.println("LISTTTTTTTTTTT: " + list.size());
				for (int k = 0; k < leftOver.size(); k++) {
					pw.println("     " + leftOver.get(k));
				}
				pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^"
						+ " ^ ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
				//==========================================================



				//==========================================================
				pw.println("=================================CURRENT BOARD=="
						+ "===============================");
				pw.println(board);
				pw.println("================================================="
						+ "================================================");
				//==========================================================


				//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
				//				System.out.println("^^^^^^^^" + board.positions.size());
				//				for (int k = 0; k < board.positions.size(); k++) {
				//					System.out.println("::::::::::::" + board.positions.get(k).toString());
				//					System.out.println("^^^^^^^^" + board.positions.size());
				//				}
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^



				//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
				//				board.spaces++;
				//				for (int j = 0; j < board.spaces; j++) {
				//					if (boardPosition == 0) {
				//						
				//					}
				//					else {
				//						pw.print("     ");	
				//					}
				//				}
				//				pw.println("Conflict");
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
				
				
				
				
				//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
				for (int l = 0; l < boardPosition + 1; l++) {
					if (l == 0) {

					}
					else {
						pw.print("               ");	
					}
				}
				for (int k = 0; k < board.spaces; k++) {
					//System.out.print("     ");
				}
				//System.out.println(board.positions.get(boardPosition).colors);

				for (int k = 0; k < board.spaces; k++) {
					pw.print("     ");
				}
				pw.println("Check if (No Conflict[1])");
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if (noConflicts(board, boardPosition)) {			
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
					board.spaces++;
					for (int k = 0; k < board.spaces; k++) {
						pw.print("     ");
					}
					pw.println("No Conflict");
					for (int k = 0; k < board.spaces; k++) {
						pw.print("     ");
					}
					pw.println("m(B, l, i+1");
					board.spaces++;
					//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					solve(board, list, leftOver, boardPosition + 1, listPosition, pw);									//          if match, recurse ///////////
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				}

				//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
				for (int k = 0; k < board.spaces; k++) {
					if (boardPosition == 0) {

					}
					else {
						pw.print("     ");	
					}
				}
				pw.println("   CONFLICTTTTTT");
				//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^



				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 
				//COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS COLORS 





				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				for (int j = 0; j < board.positions.get(boardPosition).colors.length; j++) {	//for every color j
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	



					//					if (board.positions.indexOf(board.positions.get(boardPosition)) != 0 ) {
					//						//only rotate non center tiles???
					//						board.positions.get(boardPosition).rotate();
					//					}

					//					for (int b = 0; b < leftOver.size(); b++) {

					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//					//if all tiles tried, switch out the tile with the next one
//					if (!((leftOver.contains(board.positions.get(boardPosition)))) && 
//							board.positions.get(boardPosition).getPositionNumber() == 0 &&
//							leftOver.size() > 0 && boardPosition == 0 && list.size() > 0)  {
//
////
////						list.add(0, board.positions.get(boardPosition));
////						board.positions.set(boardPosition, leftOver.get(0));
////						list.remove((Hexagon) leftOver.get(0));
//
////						for (int c = 0; c < list.size(); c++) {
////							if (list.get(c).equals((Hexagon)leftOver.get(0))) {
////								list.remove(c);
////							}
////						}
//
//						//Sort list
//						for (int a = 0; a < list.size() - 1; a++) {
//							if (list.get(a).tileNum > list.get(a + 1).tileNum) {
//								Hexagon temp = list.get(a);
//								list.set(a, list.get(a + 1));
//								list.set(a + 1, temp);
//							}
//						}
////						leftOver.remove(0);
//					}
//					else {
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
//					FIXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
					
					


						///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						for (int k = j + 1; k < board.positions.get(boardPosition).colors.length; k++) {
							if (anyColorsAheadMatch(board, boardPosition, k, j)) {

								for (int r = 0; r < j; r++) {

									//VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
									for (int l = 0; l < board.spaces; l++) {
										pw.print("     ");
									}
									pw.println("B[" + boardPosition + "].ROTATE");
									//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

									board.positions.get(boardPosition).rotate();//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
								}


							}
							else {
								//								


							}
						}


						//						save the current tile as is rotated and place next tile

						
						///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






//					}
					
					

					
					
					///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					//					if (!(leftOver.get(b).equals((Hexagon)board.positions.get(boardPosition)))) {
					//						list.add(0, board.positions.get(boardPosition));
					//						board.positions.set(boardPosition, leftOver.get(0));
					//						leftOver.remove(0);
					//						list.remove(i);
					//					}
					//				}



				}
//				list.add(0, board.positions.get(boardPosition));
//				board.positions.set(boardPosition, list.get(i + 1));
//				board.positions.get(boardPosition).positionNumber = boardPosition;
//
//				//Sort list
//				for (int a = 0; a < list.size() - 1; a++) {
//					if (list.get(a).tileNum > list.get(a + 1).tileNum) {
//						Hexagon temp = list.get(a);
//						list.set(a, list.get(a + 1));
//						list.set(a + 1, temp);
//					}
//				}


				//=================================================================================================
				//				System.out.println("CURRENT i VALUE: " + i);
				pw.println("v v v v  v v v v v  v v v v v v  BEFORE PLACING v v v v  v v v v v v  v v v v v v v v");
				pw.println("LISTTTTTTTTTTT: " + list.size());
				for (int k = 0; k < list.size(); k++) {
					pw.println("     " + list.get(k));
				}
				pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^ ^ ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
				//=================================================================================================


				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//backtrack

				list.add(0, board.positions.get(boardPosition));

				//Sort list
				for (int a = 0; a < list.size() - 1; a++) {
					if (list.get(a).tileNum > list.get(a + 1).tileNum) {
						Hexagon temp = list.get(a);
						list.set(a, list.get(a + 1));
						list.set(a + 1, temp);
					}
				}

				//				board.positions.remove(board.positions.get(boardPosition));
				board.positions.set(boardPosition, new Hexagon());
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////[[[


				//=================================================================================================
				pw.println("v v v v  v v v v v  v v v v v v  AFTER PLACING v v v v  v v v v v v  v v v v v v v v");
				pw.println("LISTTTTTTTTTTT: " + list.size());
				for (int k = 0; k < list.size(); k++) {
					pw.println("     " + list.get(k));
				}
				pw.println("^^^ ^ ^ ^ ^ ^  ^^ ^ ^ ^  ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^^ ^ ^  ^ ^ ^ ^ ^  ^ ^ ^^ ^ ^ ^ ^ ^");
				//=================================================================================================



			}
		}



	}



















	public static boolean allColorsMatch(Board board) {


		for (int i = 0; i < board.positions.size(); i++) {
			if (board.positions.get(i).getTileNum() == 0) {
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

	public static boolean noConflicts(Board board, int boardPosition) {

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
				(board.positions.get(0).colors[0] == 
				board.positions.get(1).colors[3])) {

			return true;
		}


		if ((boardPosition == 2) &&
				(board.positions.get(0).colors[1] == 
				board.positions.get(2).colors[4]) && 
				(board.positions.get(1).colors[2] == 
				board.positions.get(2).colors[5])) {
			return true;
		}

		if ((boardPosition == 3) &&
				(board.positions.get(0).colors[2] == 
				board.positions.get(3).colors[5]) && 
				(board.positions.get(2).colors[3] == 
				board.positions.get(3).colors[0])) {
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
				(board.positions.get(0).colors[3] == 
				board.positions.get(4).colors[0]) &&
				board.positions.get(3).colors[4] ==
				board.positions.get(4).colors[1]) {
			return true;
		}

		if ((boardPosition == 5) &&
				(board.positions.get(0).colors[4] == 
				board.positions.get(5).colors[1]) &&
				board.positions.get(4).colors[5] ==
				board.positions.get(5).colors[2]) {
			return true;
		}

		//
		if ( (boardPosition == 6) && 
				(board.positions.get(0).colors[5] == board.positions.get(6).colors[2]) &&
				(board.positions.get(5).colors[0] == board.positions.get(6).colors[3]) && 
				(board.positions.get(6).colors[1] == board.positions.get(1).colors[4])) {
			return true;
		}





		return false;
	}

	public static boolean anyColorsAheadMatch(Board board, int boardPosition, int colorPosition, int rotations) {

		if (boardPosition == 0) {
			return true;
		}

		//		if ((boardPosition == 1) && 
		//				(board.positions.get(0).colors[0] == 
		//				board.positions.get(1).colors[3])) {
		//			
		//			return true;
		//		}

		if ((boardPosition == 1) && 
				(board.positions.get(0).colors[0] == 
				board.positions.get(1).colors[colorPosition])) {
			


			return true;
		}


		if ((boardPosition == 2) &&
				(board.positions.get(0).colors[1] == 
				board.positions.get(2).colors[4]) && 
				(board.positions.get(1).colors[2] == 
				board.positions.get(2).colors[5])) {
			return true;
		}

		if ((boardPosition == 3) &&
				(board.positions.get(0).colors[2] == 
				board.positions.get(3).colors[5]) && 
				(board.positions.get(2).colors[3] == 
				board.positions.get(3).colors[0])) {
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
				(board.positions.get(0).colors[3] == 
				board.positions.get(4).colors[0]) &&
				board.positions.get(3).colors[4] ==
				board.positions.get(4).colors[1]) {
			return true;
		}

		if ((boardPosition == 5) &&
				(board.positions.get(0).colors[4] == 
				board.positions.get(5).colors[1]) &&
				board.positions.get(4).colors[5] ==
				board.positions.get(5).colors[2]) {
			return true;
		}

		//
		if ( (boardPosition == 6) && 
				(board.positions.get(0).colors[5] == board.positions.get(6).colors[2]) &&
				(board.positions.get(5).colors[0] == board.positions.get(6).colors[3]) && 
				(board.positions.get(6).colors[1] == board.positions.get(1).colors[4])) {
			return true;
		}

		return false;
	}


}
