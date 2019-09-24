package topInterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*	Determine if a 9x9 Sudoku board is valid. 

 *	Only the filled cells need to be validated according to the following rules:
		Each row must contain the digits 1-9 without repetition.
		Each column must contain the digits 1-9 without repetition.
		Each of the 9 3x3 sub-boxes of the grid must 
			contain the digits 1-9 without repetition.

 *	The Sudoku board could be partially filled, 
		where empty cells are filled with the character '.'.

 *	Example 1:

		Input:
		[
		  ['5','3','.','.','7','.','.','.','.'],
		  ['6','.','.','1','9','5','.','.','.'],
		  ['.','9','8','.','.','.','.','6','.'],
		  ['8','.','.','.','6','.','.','.','3'],
		  ['4','.','.','8','.','3','.','.','1'],
		  ['7','.','.','.','2','.','.','.','6'],
		  ['.','6','.','.','.','.','2','8','.'],
		  ['.','.','.','4','1','9','.','.','5'],
		  ['.','.','.','.','8','.','.','7','9']
		]
		Output: true			

 * 	Example 2:

	Input:
	[
	  ['8','3','.','.','7','.','.','.','.'],
	  ['6','.','.','1','9','5','.','.','.'],
	  ['.','9','8','.','.','.','.','6','.'],
	  ['8','.','.','.','6','.','.','.','3'],
	  ['4','.','.','8','.','3','.','.','1'],
	  ['7','.','.','.','2','.','.','.','6'],
	  ['.','6','.','.','.','.','2','8','.'],
	  ['.','.','.','4','1','9','.','.','5'],
	  ['.','.','.','.','8','.','.','7','9']
	]
	Output: false

	Explanation: Same as Example 1, except with the 5 in the top left corner being 
    				modified to 8. Since there are two 8's in the top left 3x3 sub-box, 
    				it is invalid.

 *	Note:
		A Sudoku board (partially filled) could be valid but is not necessarily solvable.
		Only the filled cells need to be validated according to the mentioned rules.
		The given board contain only digits 1-9 and the character '.'.
		The given board size is always 9x9.
 *
 *i	_|0		1	2		3	4	5		6	7	8
 *
 *j 0|00   01  02  		03  04  05  	06  07  08
 *  1|10   11  12  		13  14  15  	16  17  18
 *  2|20   21  22  		23  24  25  	26  27  28
 *  
 *  3|30   31  32  		33  34  35  	36  37  38
 *  4|40   41  42  		43  44  45  	46  47  48
 *  5|50   51  52  		53  54  55		56  57  58
 *  
 *  6|60   61  62	  	63  64  65		66  67  68
 *  7|70   71  72  		73  74  75  	76  77  78
 *  8|80   81  82	  	83  84  85	  	86  87  88
 *		
 */

public class Arr09_ValidSudoku {

	public static void main(String[] args) {
		char[][] board = {	{'.','.','4','.','.','.','6','3','.'},
							{'.','.','.','.','.','.','.','.','.'},
							{'5','.','.','.','.','.','.','9','.'},
							{'.','.','.','5','6','.','.','.','.'},
							{'4','.','3','.','.','.','.','.','1'},
							{'.','.','.','7','.','.','.','.','.'},
							{'.','.','.','5','.','.','.','.','.'},
							{'.','.','.','.','.','.','.','.','.'},
							{'.','.','.','.','.','.','.','.','.'}};

		System.out.println(isValidSoduku2(board));


	}

	public static boolean isValidSoduku2(char[][] board) {
		boolean[][] cols = new boolean[9][9];
		boolean[][] g3x3 = new boolean[9][9];
		
		for (int i = 0; i < 9; i++)
		{
			boolean[] row = new boolean[9];
			
			for (int j = 0; j < 9; j++) 
			{
				if (board[i][j] != '.')
				{
					if (row[board[i][j] - '1'])
						return false;
					else
						row[board[i][j] - '1'] = true;
					
					if (cols[j][board[i][j] - '1'])
						return false;
					else
						cols[j][board[i][j] - '1'] = true;
					
					if (g3x3[3 * (int)(i/3) + j/3][board[i][j] - '1'])
						return false;
					else
						g3x3[3 * (int)(i/3) + j/3][board[i][j] - '1'] = true;
				}
			}
		}
	
		return true;
	}
	
	public static boolean isValidSudoku(char[][] board) {
		Map<Integer, ArrayList<Character>> rows =  new HashMap<>();
		Map<Integer, ArrayList<Character>> cols =  new HashMap<>();
		Map<String, ArrayList<Character>> g3x3 =  new HashMap<>();

		for (int i = 0; i < 9; i++) {
			rows.put(i, new ArrayList<>());
			cols.put(i, new ArrayList<>());

			for (int j = 0; j < 9; j++) {
				if ( (board[i][j] != '.'))
					System.out.println((int)(board[i][j] - '1'));
				
				if ( (board[i][j] != '.') && rows.get(i).contains(board[i][j]))
					return false;
				else
					rows.get(i).add(board[i][j]);

				if ((board[j][i] != '.') && cols.get(i).contains(board[j][i]))
					return false;
				else
					cols.get(i).add(board[j][i]);

				if (i % 3 == 0 && j % 3 == 0)
				{
					String name = String.valueOf(i) + String.valueOf(j);
					g3x3.put(name, new ArrayList<>());
				}


				if (i < 3 && j < 3)
				{
					if ( (board[i][j] != '.') && g3x3.get("00").contains(board[i][j]))
						return false;
					else
						g3x3.get("00").add(board[i][j]);
				}
				else if (i < 3 && j >= 3 && j < 6)
				{	
					if ( (board[i][j] != '.') && g3x3.get("03").contains(board[i][j]))
						return false;
					else
						g3x3.get("03").add(board[i][j]);
				}
				else if (i < 3 && j >= 6)
				{
					if ( (board[i][j] != '.') && g3x3.get("06").contains(board[i][j]))
        				return false;
        			else
						g3x3.get("06").add(board[i][j]);
				}
				else if (i >= 3 && i < 6 && j < 3)
				{
					if ( (board[i][j] != '.') && g3x3.get("30").contains(board[i][j]))
        				return false;
        			else
						g3x3.get("30").add(board[i][j]);
				}
				else if (i >= 3 && i < 6 && j >= 3 && j < 6)
				{
					if ( (board[i][j] != '.') && g3x3.get("33").contains(board[i][j]))
        				return false;
        			else
						g3x3.get("33").add(board[i][j]);
				}
				else if (i >= 3 && i < 6 && j >= 6)
				{
					if ( (board[i][j] != '.') && g3x3.get("36").contains(board[i][j]))
        				return false;
        			else
						g3x3.get("36").add(board[i][j]);
				}
				else if (i >= 6 && j < 3)
				{
					if ( (board[i][j] != '.') && g3x3.get("60").contains(board[i][j]))
        				return false;
        			else
        				g3x3.get("60").add(board[i][j]);
				}
				else if (i >= 6 && j >= 3 && j < 6)
				{
					if ( (board[i][j] != '.') && g3x3.get("63").contains(board[i][j]))
        				return false;
        			else
						g3x3.get("63").add(board[i][j]);
				}
				else if (i >= 6 && j >= 6)
				{
					if ( (board[i][j] != '.') && g3x3.get("66").contains(board[i][j]))
        				return false;
        			else
						g3x3.get("66").add(board[i][j]);
				}
			}
		}



		return true;
	}

}
