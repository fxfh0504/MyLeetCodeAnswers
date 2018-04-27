package com.sygan.learning.leetcode.questions.subpack2.q36;

/**
 * @Description:
 * @author: ganshiyu
 * @Date: 2018-04-19
 * @Time: 17:09
 */

import java.util.HashSet;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 A partially filled sudoku which is valid.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Example 1:

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
 Example 2:

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
 modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 The given board contain only digits 1-9 and the character '.'.
 The given board size is always 9x9.
 */
public class ValidSudoku {
    public static void main(String...args){
        char[][] input=new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(input));
    }
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] lines = new HashSet[9];
        HashSet<Character>[][] boxes=new HashSet[3][3];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]=='.'){
                    continue;
                }
                if (rows[i]==null){
                    rows[i]=new HashSet<Character>();
                }
                if (lines[j]==null){
                    lines[j]=new HashSet<Character>();
                }
                if (boxes[i / 3][j / 3]==null){
                    boxes[i / 3][j / 3]=new HashSet<Character>();
                }
                char charactor = board[i][j];
                boolean a = rows[i].add(charactor);
                boolean b = lines[j].add(charactor);
                boolean c = boxes[i / 3][j / 3].add(charactor);
                if(!(a&&b&&c)){
                    return false;
                }
            }
        }
        return true;
    }
}
