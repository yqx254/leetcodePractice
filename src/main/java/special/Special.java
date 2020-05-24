package special;

import java.lang.reflect.Array;
import java.util.*;

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
        //No.39
        int [] candidates;
        List<List<Integer>> result = new ArrayList<>();
        private void bTrack(int start, ArrayList<Integer> current, int[] candidates, int target){
            if(target== 0){
                result.add(new ArrayList<>(current));
                return;
            }
            for(int i = start; i < candidates.length; i ++){
                if(target >= candidates[i]){
                    current.add(candidates[i]);
                    bTrack(i, current, candidates, target - candidates[i]);
                    current.remove(current.size() - 1);
                }
            }
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            bTrack(0, new ArrayList<>(),candidates, target);
            return result;
        }

    private void bTrack2(int start, ArrayList<Integer> current, int[] candidates, int target){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i < candidates.length; i ++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            if(target >= candidates[i]){
                current.add(candidates[i]);
                bTrack2(i + 1,current,candidates, target - candidates[i]);
                current.remove(current.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        if(candidates == null){
            return result;
        }
        Arrays.sort(candidates);
        bTrack2(0, new ArrayList<>(),candidates, target);
        return result;
    }
}
