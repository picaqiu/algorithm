package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
* */
public class EightQueen {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            //初始化棋盘
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0);

        return res;

    }

    private void backtrack(char[][] board, int level) {
        if (level == board.length) {
            res.add(charToList(board));
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, level, i)){
                board[level][i] = 'Q';
                backtrack(board, level+1);
                board[level][i] = '.';
            }
        }
    }

    private List<String> charToList(char[][] ch) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            String str = new String(ch[i]);
            result.add(str);
        }

        return result;
    }

    private boolean isValid(char[][] board, int row, int col) {
        if (row < -1 || col < -1 || row >= board.length || col >= board.length) {
            return true;
        }
        int len = board.length;

        //向左检查
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        //向上检查
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //向左上检查
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //向右上检查
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
