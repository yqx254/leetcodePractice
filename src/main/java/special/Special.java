package special;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来写一些不太容易用一两个方法写完的算法
 * 各方法的字段可能会混在一起
 * @author fstar
 */
public class Special {
        //No.38
        int n = 3;
        int N = n * n;

        int [][] rows = new int[N][N + 1];
        int [][] columns = new int[N][N + 1];
        int [][] boxes = new int [N][N + 1];

        char [][] board;

        boolean isSolved = false;

        private boolean placeCheck(int num, int row, int col){
            int boxIdx = (row / 3 ) * 3 + col / 3;
            return columns[col][num] + rows[row][num] + boxes[boxIdx][num] == 0;
        }

        private void placeNum(int num, int row, int col){
            int boxIdx = (row / 3) * 3 + col / 3;
            rows[row][num] ++;
            columns[col][num] ++;
            boxes[boxIdx][num] ++ ;
            board[row][col] = (char)(num + '0');
        }

        private void removeNum(int num, int row, int col){
            int boxIdx = (row / 3) * 3 + col / 3;
            rows[row][num] --;
            columns[col][num] --;
            boxes[boxIdx][num] -- ;
            board[row][col] = '.';
        }

        private void placeNextNumbers(int row, int col){
            if((col == N - 1) && (row == N - 1)){
                isSolved = true;
            }
            else{
                if( col == N - 1){
                    backtrack(row + 1 , 0);
                }
                else{
                    backtrack(row, col + 1);
                }
            }
        }
        private void backtrack(int row, int col){
            if(board[row][col] == '.'){
                for(int num = 1; num < 10; num ++){
                    if(placeCheck(num, row, col)){
                        placeNum(num, row, col);
                        placeNextNumbers(row, col);
                        if(!isSolved){
                            removeNum(num, row, col);
                        }
                    }
                }
            }
            else{
                placeNextNumbers(row, col);
            }
        }
        public void solveSudoku(char [][] board){
            this.board = board;
            for(int i = 0; i < N ; i ++){
                for(int j = 0; j < N; j ++){
                    char num = board[i][j];
                    if(num != '.'){
                        int d = num  - '0';
                        placeNum(d, i, j);
                    }
                }
            }
            backtrack(0, 0);
        }
        int [] candidates;
        int min = 0;
        List<List<Integer>> result = new ArrayList<>();
        //No.39
        private void backtrack(ArrayList<Integer> current, int[] candidates, int target){
            boolean flag;
            int temp = 0;
            for (int candidate : candidates) {
                if(candidate == temp){
                    continue;
                }
                temp = candidate;
                if (target - candidate == 0) {
                    flag = true;
                    current.add(candidate);
                } else if (target - candidate < min) {
                    flag = false;
                } else {
                    current.add(candidate);
                    flag = false;
                    backtrack(current, candidates, target - candidate);
                }
                if (flag) {
                    result.add(current);
                    break;
                }
            }
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            for (int candidate : candidates) {
                if (candidate < min) {
                    min = candidate;
                }
            }
            backtrack(new ArrayList<>(),candidates, target);
            return result;
        }
}
