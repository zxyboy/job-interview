package cn.cupcat.tree;

import java.util.List;
import java.util.Objects;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {

    /**
     * root节点
     */
    private TreeNode root;


    public TreeNode find(int val) {
        if (root == null) {
            return null;
        }
        return root.find(val);
    }


    public TreeNode findMin() {
        return root == null ? null : root.findMin();
    }


    public TreeNode findMax() {
        return root == null ? null : root.findMax();

    }


    /**
     * 添加节点
     *
     * @param val
     */
    public TreeNode insert(int val) {
        if (Objects.isNull(root)) {
            root = new TreeNode(val);
            return root;
        } else {
            return root.insert(val);
        }
    }

    public TreeNode delete(int val) {
        return root == null ? null : root.delete(val);
    }


    public List<TreeNode> preOrderTraverse() {
        return root == null ? null : root.preOrderTraverse();
    }

    public List<TreeNode> midOrderTraverse() {
        return root == null ? null : root.midOrderTraverse();
    }

    public List<TreeNode> rearOrderTraverse() {
        return root == null ? null : root.rearOrderTraverse();
    }

    public List<TreeNode> levelTraverse() {
        return root == null ? null : root.levelTraverse();
    }


    //
//    private TreeNode findVal(int val, TreeNode treeNode) {
//        if (treeNode == null) {
//            return null;
//        }
//        // 大于根节点，从右子树查找
//        if (val > treeNode.value) {
//            return findVal(val, treeNode.right);
//        } else if (val < treeNode.value) {
//            return findVal(val, treeNode.left);
//        } else {
//            return treeNode;
//        }
//    }
//
//    private TreeNode findVal2(int val, TreeNode treeNode) {
//
//        while (treeNode != null) {
//            // 大于根节点，从右子树查找
//            if (val > treeNode.value) {
//                treeNode = treeNode.right;
//            } else if (val < treeNode.value) {
//                treeNode = treeNode.left;
//            } else {
//                return treeNode;
//            }
//        }
//        return null;
//    }


}
