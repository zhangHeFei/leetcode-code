package com.leetcode.algorithm;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 *
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 *
 * 提示：
 *
 *
 * 	1 <= board.length <= 200
 * 	1 <= board[i].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法；深度优先搜索
 */
public class Exist {

    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0){
            return false;
        }

        // 1.将word转为target字符数组
        char[] target = word.toCharArray();

        // 2.遍历board，获取第一个字符的位置
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[i].length; j ++){
                if (recursionExist(board, i, j, target, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean recursionExist(char[][] board, int i, int j, char[] target, int targetIndex){
        // 范围判定
        if (i < 0 || i >= board.length){
            return false;
        }
        if (j < 0 || j >= board[i].length){
            return false;
        }

        // 命中判定
        if (board[i][j] != target[targetIndex]){
            return false;
        }

        // 当前节点已找到，如果不是最后目标字符，递归向下寻找
        if (targetIndex < target.length - 1){
            char temp = board[i][j];
            board[i][j] = '/';
            if (recursionExist(board, i -1, j, target, targetIndex + 1)
            || recursionExist(board, i, j -1, target, targetIndex + 1)
            || recursionExist(board, i + 1, j, target, targetIndex + 1)
            || recursionExist(board, i, j + 1, target, targetIndex + 1)){
                return true;
            }
            board[i][j] = temp;
            return false;
        }

        // 当前节点最后一个已找到，返回true
        return true;

    }
}
