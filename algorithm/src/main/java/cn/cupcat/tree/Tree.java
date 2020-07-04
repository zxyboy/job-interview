package cn.cupcat.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1、 二叉树遍历：
 * 前序
 * 中序
 * 后序
 * 都是用两种方式
 * 递归
 * 非递归 ： 始终栈数据结构存储遍历节点
 * <p>
 * 思想：
 * DFS（深度优先算法- Depth-First Search ）： 一般能使用递归和栈来实现
 * <p>
 * <p>
 * 2、层次遍历
 * 思想： BFS（深度优先算法-Breadth First Search） ： 先搜索邻居，搜完邻居再搜邻居的邻居。
 * 一般使用队列实现，广度优先是先将未访问的邻居压入队列，再将未访问邻居的未访问过的邻居压入队列再依次访问
 * <p>
 * 其中俩个实现思想：
 * 1.双端队列不为空则循环
 * <p>
 * 2.将未访问的邻接点压入双端链表后面，然后从前面取出并访问（这样就做到了广度优先）
 * https://blog.csdn.net/coder__666/article/details/80349039?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 */
public class Tree {

    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        // 产生10个二叉树节点
        TreeNode[] treeNodes = generateTreeNode(7);
        // root节点
        TreeNode root = treeNodes[0];


        System.out.println("--------递归遍历二叉树---------");

        preTraverseTree(root);
        System.out.println("前序遍历：" +
                String.join(",", list.stream().map(String::valueOf).collect(Collectors.toList())));

        list.clear();

        midTraverseTree(root);
        System.out.println("中序遍历：" +
                String.join(",", list.stream().map(String::valueOf).collect(Collectors.toList())));

        list.clear();

        behindTraverseTree(root);
        System.out.println("后序遍历：" +
                String.join(",", list.stream().map(String::valueOf).collect(Collectors.toList())));
        list.clear();

        System.out.println("--------非递归遍历二叉树---------");


        preTraverseTree1(root);
        System.out.println("前序遍历：" +
                String.join(",", list.stream().map(String::valueOf).collect(Collectors.toList())));

        list.clear();

        midTraverseTree1(root);
        System.out.println("中序遍历：" +
                String.join(",", list.stream().map(String::valueOf).collect(Collectors.toList())));

        list.clear();

        behindTraverseTree1(root);
        System.out.println("后序遍历：" +
                String.join(",", list.stream().map(String::valueOf).collect(Collectors.toList())));
        list.clear();


        System.out.println("--------层次遍历二叉树（从上到下每一层遍历）---------");
        hierarchyTraverseTree(root);
        System.out.println("层次遍历：" +
                String.join(",", list.stream().map(String::valueOf).collect(Collectors.toList())));
        list.clear();
    }


    /**
     * 分层遍历二叉树
     *
     * @param treeNode
     */
    public static void hierarchyTraverseTree(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            // 创建队列
            LinkedList<TreeNode> queue = new LinkedList<>();

            // 将根节点进入队列
            queue.add(treeNode);

            while (!queue.isEmpty()) {

                // 出队列，
                TreeNode node = queue.poll();
                list.add(node.value);

                // 如果该节点的左右子树不为空，则加入队列
                if (Objects.nonNull(node.left)) {
                    queue.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.add(node.right);
                }
            }

        }
    }


    /**
     * 非递归后续遍历二叉树
     * push ： 入栈
     * peek： 返回栈顶元素，但是不会出栈
     * pop ： 返回栈顶元素，同时也会出栈
     * empty ： 栈是否为空
     *
     * @param root
     */
    public static void behindTraverseTree1(TreeNode root) {
        if (Objects.nonNull(root)) {
            // 辅助栈内表示左子树
            int left = 1;
            // 辅助栈内表示右子树
            int right = 2;
            Stack<TreeNode> stack = new Stack<>();
            // 辅助栈
            Stack<Integer> assistStack = new Stack<>();

            while (Objects.nonNull(root) || !stack.empty()) {

                while (Objects.nonNull(root)) {
                    stack.push(root);
                    assistStack.push(left);
                    root = root.left;
                }

                while (!stack.empty() && assistStack.peek() == right) {
                    // 如果从有子树返回父节点，就可以弹出两个栈的栈顶元素
                    assistStack.pop();
                    TreeNode pop = stack.pop();
                    list.add(pop.value);
                }


                if (!stack.empty() && assistStack.peek() == left) {
                    // 如果从左子树返回父节点，则将辅助栈标记修改为右子树
                    assistStack.pop();
                    assistStack.push(right);
                    root = stack.peek().right;
                }

            }
        }
    }


    /**
     * 非递归中序遍历二叉树
     *
     * @param root
     */
    public static void midTraverseTree1(TreeNode root) {
        if (Objects.nonNull(root)) {
            Stack<TreeNode> stack = new Stack<>();
            // 节点不null 或者 栈中没有元素 退出
            while (Objects.nonNull(root) || !stack.empty()) {

                while (Objects.nonNull(root)) {
                    stack.push(root);
                    root = root.left;
                }

                if (!stack.empty()) {
                    TreeNode pop = stack.pop();
                    list.add(pop.value);
                    root = pop.right;
                }

            }
        }

    }


    /**
     * 先序遍历 ： 使用非递归实现
     * 1、先遍历根节点
     * 2、在遍历左子树
     * 3、最后遍历有子树
     * <p>
     * 利用栈数据结构， 后进先出（LIFO）
     * 1、一直想二叉树左子树遍历，同时将遍历到的元素压入栈内，直到左子树为NULL
     * 2、出栈元素，将元素的右子树入栈，遍历该元素的左子树，直到左子树为NULL
     * 3、重复2
     * 4、当栈内没有元素为止
     *
     * @param root
     */
    public static void preTraverseTree1(TreeNode root) {
        if (Objects.nonNull(root)) {

            Stack<TreeNode> stack = new Stack<>();

            TreeNode treeNode = root;
            while (Objects.nonNull(treeNode) || !stack.empty()) {

                // 从节点向左子树遍历，一直到左子树没有左子树为止
                while (Objects.nonNull(treeNode)) {
                    list.add(treeNode.value);
                    stack.push(treeNode);

                    treeNode = treeNode.left;
                }
                // 处理右子树
                if (!stack.empty()) {
                    TreeNode pop = stack.pop();
                    treeNode = pop.right;
                }

            }

        }
    }


    /**
     * 先序遍历 ： 使用递归实现
     * 1、先遍历根节点
     * 2、在遍历左子树
     * 3、最后遍历有子树
     *
     * @param root
     */
    public static void preTraverseTree(TreeNode root) {


        if (Objects.nonNull(root)) {
            // 取根节点
            list.add(root.value);

            // 取左子树
            if (Objects.nonNull(root.left)) {
                preTraverseTree(root.left);
            }
            // 取右子树
            if (Objects.nonNull(root.right)) {
                preTraverseTree(root.right);
            }
        }

    }

    /**
     * 中序遍历 ： 使用递归实现
     * 1、遍历左子树
     * 2、根节点
     * 3、遍历有子树
     *
     * @param root
     */
    public static void midTraverseTree(TreeNode root) {


        if (Objects.nonNull(root)) {

            // 取左子树
            if (Objects.nonNull(root.left)) {
                midTraverseTree(root.left);
            }
            // 取根节点
            list.add(root.value);

            // 取右子树
            if (Objects.nonNull(root.right)) {
                midTraverseTree(root.right);
            }

        }

    }

    /**
     * 后序遍历 ： 使用递归实现
     * 1、遍历左子树
     * 2、遍历有子树
     * 3、根节点
     *
     * @param root
     */
    public static void behindTraverseTree(TreeNode root) {


        if (Objects.nonNull(root)) {

            // 取左子树
            if (Objects.nonNull(root.left)) {
                behindTraverseTree(root.left);
            }
            // 取右子树
            if (Objects.nonNull(root.right)) {
                behindTraverseTree(root.right);
            }
            // 取根节点
            list.add(root.value);

        }

    }


    /**
     * 产生二叉树
     *
     * @param num
     * @return
     */
    public static TreeNode[] generateTreeNode(int num) {
        TreeNode[] node = new TreeNode[num];
        // 保存数据
        for (int i = 0; i < num; i++) {
            node[i] = new TreeNode(i);
        }

        // 保存
        for (int i = 0; i < num; i++) {
            if (i * 2 + 1 < num) {
                node[i].left = node[i * 2 + 1];
            }
            if (i * 2 + 2 < num) {
                node[i].right = node[i * 2 + 2];
            }
        }
        return node;
    }
}
