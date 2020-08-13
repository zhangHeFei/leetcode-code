package com.leetcode.algorithm;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：递归
 * 解析：（1）前序遍历得第一个数字一定是根节点，该数字在中序遍历中的位置是根的位置，在该位置得左侧是根得左子树，在该位置得右侧是根得右子树
 * （2）因此可以分别知道左子树总数n和右子树得总数m，在前序遍历中根节点后的n数字是左子树，左子树后边得m个数字是右子树
 * （3）当左子树（右子树）得总数量=0，则左子树为为空；=1，则只有一个节点；>1,则有多个节点，递归构建剩下得树
 */
public class BuildTree {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder){

        if (preorder == null || preorder.length == 0){
            return null;
        }

        // 使用map保存中序遍历中每个节点的下标
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i ++){
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(preorder, 1, inorderMap.get(preorder[0]), inorder, 0, inorderMap.get(preorder[0]) - 1, inorderMap);
        root.right = buildTree(preorder, inorderMap.get(preorder[0]) + 1, preorder.length - 1, inorder, inorderMap.get(preorder[0]) + 1, inorder.length - 1, inorderMap);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                               int[] inorder, int inorderStart, int inorderEnd,
                               Map<Integer, Integer> inorderMap){

        if (preorderStart > preorderEnd){
            return null;
        }else if (preorderStart == preorderEnd){
            return new TreeNode(preorder[preorderStart]);
        }else {
            TreeNode root = new TreeNode(preorder[preorderStart]);
            root.left = buildTree(preorder, preorderStart + 1, inorderMap.get(preorder[preorderStart]) - inorderStart + preorderStart, inorder, inorderStart, inorderMap.get(preorder[preorderStart]) - 1, inorderMap);
            root.right = buildTree(preorder, inorderMap.get(preorder[preorderStart]) - inorderStart + 1 + preorderStart, preorderEnd, inorder, inorderMap.get(preorder[preorderStart]) + 1, inorderEnd, inorderMap);
            return root;
        }

    }

    public static void main(String... args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = new BuildTree().buildTree(preorder, inorder);
    }
}
