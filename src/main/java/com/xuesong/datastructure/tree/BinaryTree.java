package com.xuesong.datastructure.tree;

/**
 * 二叉树
 *
 */
public class BinaryTree<E> {

    private TreeNode head;
    public BinaryTree () {
    }

    public static class TreeNode <E> {
        public TreeNode (E value) {
            this.value = value;
        }
        private E value;
        private TreeNode left;
        private TreeNode right;
        public E getValue() {
            return value;
        }
        public void setValue(E value) {
            this.value = value;
        }
        public TreeNode getLeft() {
            return left;
        }
        public void setLeft(TreeNode left) {
            this.left = left;
        }
        public TreeNode getRight() {
            return right;
        }
        public void setRight(TreeNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * 前序输出，先根节点，再左节点，最后右节点
     */
    public void prePrint(TreeNode node) {
        if(node==null){
            return;
        }
        System.out.print(node.value+"-");
        prePrint(node.left);
        prePrint(node.right);
    }

    /**
     * 中序输出，先左，后根，最后右
     */
    public void midPrint(TreeNode node) {
        if(node==null){
            return;
        }
        midPrint(node.left);
        System.out.print(node.value+"-");
        midPrint(node.right);
    }

    /**
     * 后序输出，先左后右最后根
     */
    public void lastPrint(TreeNode node) {
        if(node==null){
            return;
        }
        lastPrint(node.left);
        lastPrint(node.right);
        System.out.print(node.value+"-");
    }

    /**           1
     *          /   \
     *        2      3
     *      /       /  \
     *    4         5    6
     *   / \       /
     * 7    8     9
     * 树的结构
     */
    public static void main(String[] args) {
        TreeNode<String> node1 = new TreeNode<String>("1");
        TreeNode<String> node2 = new TreeNode<String>("2");
        TreeNode<String> node3 = new TreeNode<String>("3");
        TreeNode<String> node4 = new TreeNode<String>("4");
        TreeNode<String> node5 = new TreeNode<String>("5");
        TreeNode<String> node6 = new TreeNode<String>("6");
        TreeNode<String> node7 = new TreeNode<String>("7");
        TreeNode<String> node8 = new TreeNode<String>("8");
        TreeNode<String> node9 = new TreeNode<String>("9");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node3.setLeft(node5);
        node3.setRight(node6);
        node4.setLeft(node7);
        node4.setRight(node8);
        node5.setLeft(node9);
        BinaryTree binaryTree = new BinaryTree();
        //前序
        System.out.println("前序");
        binaryTree.prePrint(node1);
        //中序
        System.out.println("");
        System.out.println("中序");
        binaryTree.midPrint(node1);
        //后续
        System.out.println("");
        System.out.println("后序");
        binaryTree.lastPrint(node1);
    }
}
