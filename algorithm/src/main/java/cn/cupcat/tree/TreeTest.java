package cn.cupcat.tree;

import static cn.cupcat.tree.Tree.generateTreeNode;

public class TreeTest {
    public static void main(String[] args) {
//        treeTraverse();
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);

        TreeNode findTree = binarySearchTree.find(4);

        System.out.println(findTree);
        System.out.println("find 4 = " + findTree.value);

        TreeNode treeMax = binarySearchTree.findMax();
        System.out.println("findMax = " + treeMax.value);
        TreeNode treeMin = binarySearchTree.findMin();
        System.out.println("findMin = " + treeMin.value);



        binarySearchTree.midOrderTraverse()
                .stream()
                .map(treeNode -> treeNode.value)
                .forEach(System.out::print);


    }

    private static void treeTraverse() {
        // 产生10个二叉树节点
        TreeNode[] treeNodes = generateTreeNode(7);
        // root节点
        TreeNode root = treeNodes[0];

        root.rearOrderTraverse()
                .stream()
                .map(treeNode -> treeNode.value)
                .forEach(System.out::print);
    }
}
