package com.mason.leetcode.array.easy;

/**
 * Created by mwu on 2019/12/2
 * <p>
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
 * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
 * 直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * <p>
 * 返回车能够在一次移动中捕获到的卒的数量。
 */
public class AvailableCapturesForRook999 {

  public static void main(String[] args) {
    char[][] board = {
        new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
        new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
        new char[]{'.', 'p', 'B', 'R', '.', '.', '.', 'p'},
        new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
        new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
        new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
        new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
        new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}
    };
    System.out.println(numRookCaptures(board));
  }

  private static int numRookCaptures(char[][] board) {
    int i = 0, j = 0;
    outer:
    for (; i < board.length; i++) {
      for (; j < board[i].length; j++) {
        if (board[i][j] == 'R') {
          break outer;
        }
      }
      j = 0;
    }
    int count = 0;
    // 遍历行
    int left = j, right = j;
    while (left >= 0) {
      if (board[i][left] == 'B') {
        break;
      }
      if (board[i][left] == 'p') {
        count++;
        break;
      }
      left--;
    }
    while (right < board[i].length) {
      if (board[i][right] == 'B') {
        break;
      }
      if (board[i][right] == 'p') {
        count++;
        break;
      }
      right++;
    }
    // 遍历列
    int up = i, down = i;
    while (up >= 0) {
      if (board[up][j] == 'B') {
        break;
      }
      if (board[up][j] == 'p') {
        count++;
        break;
      }
      up--;
    }
    while (down < board.length) {
      if (board[down][j] == 'B') {
        break;
      }
      if (board[down][j] == 'p') {
        count++;
        break;
      }
      down++;
    }
    return count;
  }
}
