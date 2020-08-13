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

        if (preorder.length == 0){
            return null;
        }

        // 使用map记录中序遍历中每个值的下标
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i ++){
            inorderMap.put(inorder[i], i);
        }

        // 前序遍历中的第一个元素必定是二叉树的根
        TreeNode node = new TreeNode(preorder[0]);

        // 获取二叉树的根在中序遍历中的位置，在跟左侧数量是所有左子树的节点数，在根右侧数量是所有右子树的节点数
        int nodeIndex = inorderMap.get(node.val);

        // 如果左子树总结点数为0，则左子树为null；为1，则只有一个节点；大于1，则递归左子树
        if (nodeIndex == 0){
            node.left = null;
        }else if (nodeIndex == 1){
            node.left = new TreeNode(preorder[1]);
        }else{
            int[] subPreorder = new int[nodeIndex];
            int[] subInorder = new int[nodeIndex];
            System.arraycopy(preorder, 1, subPreorder, 0, nodeIndex);
            System.arraycopy(inorder, 0, subInorder, 0, nodeIndex);
            node.left = buildTree(subPreorder, subInorder);
        }

        if (nodeIndex == inorder.length - 1){
            node.right = null;
        }else if (nodeIndex == inorder.length - 2){
            node.right = new TreeNode(preorder[preorder.length - 1]);
        }else {
            int[] subPreorder = new int[inorder.length - 1 - nodeIndex];
            int[] subInorder = new int[inorder.length - 1 - nodeIndex];
            System.arraycopy(preorder, nodeIndex + 1, subPreorder, 0, inorder.length - 1 - nodeIndex);
            System.arraycopy(inorder, nodeIndex  + 1, subInorder, 0, inorder.length - 1 - nodeIndex);
            node.right = buildTree(subPreorder, subInorder);
        }
        return node;
    }
}
