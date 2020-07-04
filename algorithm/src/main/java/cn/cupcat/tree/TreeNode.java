package cn.cupcat.tree;

import java.util.*;

/**
 * 二叉树结构
 * <p>
 * value ： 保存节点数据
 * left ： 表示左子树
 * right ： 表示右子树
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode parent;

    public TreeNode(int value) {
        this.value = value;
    }

    /**
     * 获得根节点
     *
     * @return
     */
    public TreeNode root() {
        TreeNode p = this;
        while (p.parent != null) {
            p = p.parent;
        }
        return p;
    }

    /**
     * 插入节点
     *
     * @param value
     * @return
     */
    public TreeNode insert(int value) {
        TreeNode newTreeNode = new TreeNode(value);
        TreeNode p = this;

        while (p != null) {
            if (p.value > value) {
                if (p.left == null) {
                    p.left = newTreeNode;
                    newTreeNode.parent = p;
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = newTreeNode;
                    newTreeNode.parent = p;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
        return newTreeNode;

    }

    /**
     * 删除节点：
     * 情况一：删除节点在叶子节点上
     * 1、清空父节点对叶子节点指向(currentNode.parent.left/right = null)
     * 2、删除叶子节点（清空父节点引用）(currentNode.parent = null)
     * <p>
     * 情况二：删除节点有一个孩子（可以是左孩子、也可以是有孩子）
     * 1、将父节点对当前节点的引用指向当前节点对子节点的引用（ currentNode.parent.left/right = currentNode.left/right）
     * 2、将当前节点的孩子节点的父节点引用指向当前节点的父节点 (currentNode.left/right.parent = currentNode.parent)
     * 3、当前节点的父节点引用指向空   （currentNode.parent = null）
     * 4、当前节点的孩子节点引用指向空 (currentNode.left/right = null)
     * <p>
     * 情况三：删除节点有两个孩子节点
     * <p>
     * 处理方法1： 找到当前节点右子树中的最小值替代当前节点(该节点一定没有左子树)
     * <p>
     * 处理方法2： 找到当前节点左子树中最大值替换当前节点（该节点一定没有有右子树）
     *
     * @param value
     * @return
     */
    public TreeNode delete(int value) {

        TreeNode deleteNode = find(value);
        // 要删除的值不存在，返回null
        if (deleteNode == null) {
            return null;
        }

        int parentValue = deleteNode.parent.value;

        // 左右子树都存在
        if (deleteNode.left != null && deleteNode.right != null) {
            // 找右子树最小值
            TreeNode rightMin = deleteNode.right.findMin();
            // 右子树最小值有右子树，将最小值的右子树放到最小值的位置上
            if (rightMin.right != null) {
                // 只存在右子树
                rightMin.parent.left = rightMin.right;
                rightMin.right.parent = rightMin.parent;
            }
            if (parentValue > deleteNode.value) {
                deleteNode.parent.left = rightMin;
            } else {
                deleteNode.parent.right = rightMin;
            }
            rightMin.left = deleteNode.left;
            rightMin.right = deleteNode.right;
            rightMin.parent = deleteNode.parent;

            deleteNode.parent = null;
            deleteNode.right = null;
            deleteNode.left = null;
        } else if (deleteNode.left != null && deleteNode.right == null) {
            // 只存在左子树
            if (parentValue > deleteNode.value) {
                deleteNode.parent.left = deleteNode.left;
            } else {
                deleteNode.parent.right = deleteNode.left;
            }
            deleteNode.left.parent = deleteNode.parent;
            deleteNode.parent = null;
            deleteNode.left = null;
        } else if (deleteNode.right != null && deleteNode.left == null) {
            // 只存在右子树
            if (parentValue > deleteNode.value) {
                deleteNode.parent.left = deleteNode.right;
            } else {
                deleteNode.parent.right = deleteNode.right;
            }
            deleteNode.right.parent = deleteNode.parent;
            deleteNode.parent = null;
            deleteNode.right = null;
        } else {
            // 左右子树都不存在（叶子节点）
            // 左节点
            if (parentValue > deleteNode.value) {
                // 断开父节点对删除节点指针
                deleteNode.parent.left = null;
            } else {
                // 右节点
                // 断开父节点对删除节点指针
                deleteNode.parent.right = null;
            }
            // 断开删除节点对父节点指针
            deleteNode.parent = null;
        }


        return deleteNode;
    }

    /**
     * 前序遍历二叉树
     *
     * @return
     */
    public List<TreeNode> preOrderTraverse() {
        List<TreeNode> list = new ArrayList<>();

        TreeNode p = this;
        if (p == null) {
            return list;
        }
        // 1、创建堆栈
        Stack<TreeNode> stack = new Stack<>();

        // 2、当前元素不为空或者堆栈内元素不为空时，继续循环
        while (p != null || !stack.isEmpty()) {
            // 3、如果p不为空，则一直想左子树遍历，直到出现节点左子树为空为止
            while (p != null) {
                list.add(p);
                stack.push(p);
                // 4、一直想左节点移动
                p = p.left;
            }
            // 4、出现左子树为空并且堆栈内元素不为空，循环出栈
            while (p == null && !stack.isEmpty()) {
                TreeNode right = stack.pop().right;
                // 如果出栈元素没有右子树，则继续出栈
                if (right == null) {
                    continue;
                } else {
                    // 出栈元素有右子树，继续想该元素右子树的左子树遍历
                    p = right;
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 中序遍历
     *
     * @return
     */
    public List<TreeNode> midOrderTraverse() {
        List<TreeNode> list = new ArrayList<>();
        TreeNode p = this;
        // 空树
        if (p == null) {
            return list;
        }

        // 1、创建堆栈
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.isEmpty()) {
            // 向左遍历，一直遇到最左边的叶子节点
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 出栈操作
            while (p == null && !stack.isEmpty()) {
                TreeNode pop = stack.pop();
                // 出栈，将节点收集到list中
                list.add(pop);
                TreeNode right = pop.right;
                // 出栈元素右节点为空，继续出栈
                if (right == null) {
                    continue;
                } else {
                    // 右节点不为空，则继续向右节点的左节点遍历
                    p = right;
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 后续遍历
     *
     * @return
     */
    public List<TreeNode> rearOrderTraverse() {
        List<TreeNode> list = new ArrayList<>();
        TreeNode p = this;
        if (p == null) {
            return list;
        }
        // 1、创建堆栈
        Stack<TreeNode> stack = new Stack<>();
        // 0 表示未取出过 ， 1 表示取出过
        Stack<Integer> assistStack = new Stack<>();

        while (p != null || !stack.isEmpty()) {
            // 向左孩子一直遍历
            while (p != null) {
                stack.push(p);
                assistStack.push(0);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                TreeNode peek = stack.peek();
                Integer isRead = assistStack.pop();
                if (isRead == 0) {
                    assistStack.push(1);
                    p = peek.right;
                } else {
                    TreeNode pop = stack.pop();
                    list.add(pop);
                }
            }
        }

        return list;
    }

    /**
     * 二叉树层次遍历
     *
     * @return
     */
    public List<TreeNode> levelTraverse() {
        List<TreeNode> list = new ArrayList<>();
        TreeNode p = this;

        if (p == null) {
            return list;
        }
        // 1、创建队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 2、将根节点添加到队列中
        queue.add(p);

        // 3、如果队列中有元素，则一直遍历
        while (!queue.isEmpty()) {
            // 4、取出队列头部元素 ，收集起来
            p = queue.poll();
            list.add(p);
            // 5、如果取出元素有左孩子，则添加到队列中
            if (p.left != null) {
                queue.add(p.left);
            }
            // 5、如果取出元素有右孩子，则添加到队列中
            if (p.right != null) {
                queue.add(p.right);
            }
        }
        return list;
    }

    /**
     * 二叉搜索树查找
     *
     * @param value
     * @return
     */
    public TreeNode find(int value) {
        TreeNode p = this;
        while (p != null) {
            if (p.value > value) {
                p = p.left;
            } else if (p.value < value) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
//        if (p.value > value) {
//            return p.left != null ? p.left.find(value) : null;
//        } else if (p.value < value) {
//            return p.right != null ? p.right.find(value) : null;
//        } else {
//            return p;
//        }
    }

    /**
     * 二叉搜索树查找最大值
     *
     * @return
     */
    public TreeNode findMax() {
        TreeNode p = this;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 二叉搜索树查找最小值
     *
     * @return
     */
    public TreeNode findMin() {
        TreeNode p = this;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }


}