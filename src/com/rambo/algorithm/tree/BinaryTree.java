package com.rambo.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @description:二叉树遍历
 * @Date : 2019/11/20 11:05
 * @Author : zhang_jin
 */
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.print("队列实现广度优先遍历：");
        levelTraversal(root);
        System.out.println();

        System.out.print("栈实现前序遍历：");
        preorderTraversal(root);
        System.out.println();

        System.out.print("递归实现前序遍历：");
        preorderTraversalRec(root);
        System.out.println();

        System.out.print("递归实现中序遍历：");
        inorderTraversalRec(root);
        List<Integer> inorderTraversalRecStack = inorderTraversalRecStack(root);
        System.out.println(inorderTraversalRecStack);
        System.out.println();

        System.out.print("递归实现后续遍历：");
        postorderTraversalRec(root);
        List<Integer> postOrderTraversalRecStack = postOrderTraversalRecStack(root);
        System.out.println();
        System.out.println(postOrderTraversalRecStack);
        System.out.println();

        int nodeNum = getNodeNumRec(root);
        System.out.println("递归计算二叉树节点数：" + nodeNum);

        int nodeDepth = getNodeDepthRec(root);
        System.out.println("递归计算二叉树深度：" + nodeDepth);

        int k = 2;
        int nodeNumKthLevel = getNodeNumKthLevelRec(root, k);
        System.out.println("递归计算二叉树第" + k + "层节点数：" + nodeNumKthLevel);

        int leafNum = getNodeLeafNumRec(root);
        System.out.println("递归计算二叉树叶子节点数：" + leafNum);

        List<List<Integer>> levelOrder3 = levelOrder3(root);
        System.out.println("层序遍历二叉树3：" + levelOrder3);


        TreeNode root1 = new TreeNode(1);
        TreeNode node1L = new TreeNode(2);
        TreeNode node1R = new TreeNode(2);
        TreeNode node2LR = new TreeNode(3);
        TreeNode node2LL = new TreeNode(3);
        TreeNode node2RR = new TreeNode(3);

        root1.left = node1L;
        root1.right = node1R;

//        node1L.right = node2LR;
        node1L.left = node2LL;
        node1R.right = node2RR;
        System.out.println("对称二叉树：" + isSymmetric(root1));


        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode node = buildTreeNode(pre, in);
        System.out.println("根据前序遍历和中序遍历数组构造二叉树：" + node);
    }

    /**
     * @param root
     * @return void
     * @description 用队列实现二叉树的广度优先遍历，层序输出
     */
    public static List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> levelTemp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                levelTemp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(levelTemp);
        }
        //自底向上的层序遍历，只需要将结果集反转即可
//        Collections.reverse(result);
        return result;
    }

    /**
     * @param root
     * @return void
     * @description 用栈实现深度优先遍历的前序遍历（根左右）
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            // 前序遍历，需要右子树先进栈
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    /**
     * 前序遍历，中序遍历，后序遍历
     * 前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     */
    public static void preorderTraversalRec(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    /**
     * 前序遍历，中序遍历，后序遍历
     * 中序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public static void inorderTraversalRec(TreeNode root) {
        if (root == null)
            return;
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }

    /**
     * 中序遍历迭代法:关键点：节点的访问顺序与处理顺序不一致，树的访问必然是根节点开始的，中序遍历的却是需要从最左边的叶子节点开始。
     * 因此，一开始入栈的节点是一路向左，最左边的树枝全部入栈，之后开始按照中序遍历要求处理。
     */
    public static List<Integer> inorderTraversalRecStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null)
            return;
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 后序遍历:前序遍历的解法稍微改变下次序。根左右，把入栈顺序调换之后可以改为根右左，结果数组反转一下就是左右根。
     */
    public static List<Integer> postOrderTraversalRecStack(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * @param root
     * @return int
     * @description 递归获取二叉树节点数
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null)
            return 0;
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    /**
     * @param root
     * @return int
     * @description 递归获取二叉树深度
     */
    public static int getNodeDepthRec(TreeNode root) {
        if (root == null)
            return 0;
        int depthLeft = getNodeDepthRec(root.left);
        int depthRight = getNodeDepthRec(root.right);
        return (depthLeft > depthRight ? depthLeft : depthRight) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depthLeft = minDepth(root.left);
        int depthRight = minDepth(root.right);
        return min(depthLeft, depthRight) + 1;
    }

    public int min(int depthLeft,int depthRight) {
        if (depthLeft == 0 && depthRight != 0) {
            return depthRight;
        }
        if (depthLeft != 0 && depthRight == 0) {
            return depthLeft;
        }
        return depthLeft <= depthRight ? depthLeft : depthRight;
    }

    /**
     * @param root
     * @return int
     * @description 递归求二叉树中第K层的节点个数
     */
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1)
            return 0;
        if (k == 1)
            return 1;
        int numLeft = getNodeNumKthLevelRec(root.left, k - 1);
        int numRight = getNodeNumKthLevelRec(root.right, k - 1);
        return numLeft + numRight;
    }

    /**
     * @param root
     * @return int
     * @description 递归求二叉树叶子节点个数
     */
    public static int getNodeLeafNumRec(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getNodeLeafNumRec(root.left) + getNodeLeafNumRec(root.right);
    }

    public static boolean isSymmetric(TreeNode root) {
        return checkTwoTreeSymmetric(root, root);
    }

    public static boolean checkTwoTreeSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && checkTwoTreeSymmetric(root1.left, root2.right) && checkTwoTreeSymmetric(root1.right, root2.left);
    }

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @return
     */
    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftOrder = true;
        while (!queue.isEmpty()) {
            Deque<Integer> temp = new LinkedList<>();
            for (int j = queue.size(); j > 0; j--) {
                TreeNode node = queue.poll();
                if (leftOrder) {
                    temp.offerLast(node.val);
                } else {
                    temp.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(new LinkedList<>(temp));
            leftOrder = !leftOrder;
        }
        return res;
    }

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * 示例 1:
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     * 示例 2:
     * <p>
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static TreeNode buildTreeNodeReCur(Map<Integer, Integer> inOrderMap, int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        //根节点是前序遍历的首个
        TreeNode newTree = new TreeNode(preOrder[preStart]);
        //中序遍历中根节点的下标
        Integer rootIndex = inOrderMap.get(preOrder[preStart]);
        //左子树的size：
        int leftTreeSize = rootIndex - inStart;
        TreeNode leftTree = buildTreeNodeReCur(inOrderMap, preOrder, preStart + 1, preStart + 1 + leftTreeSize, inOrder, inStart, rootIndex);
        TreeNode rightTree = buildTreeNodeReCur(inOrderMap, preOrder, preStart + 1 + leftTreeSize, preEnd, inOrder, rootIndex + 1, inEnd);
        newTree.left = leftTree;
        newTree.right = rightTree;
        return newTree;
    }

    public static TreeNode buildTreeNode(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return buildTreeNodeReCur(inOrderMap, preOrder, 0, preOrder.length, inOrder, 0, inOrder.length);
    }


}

