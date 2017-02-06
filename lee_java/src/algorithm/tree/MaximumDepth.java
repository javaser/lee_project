package algorithm.tree;

public class MaximumDepth {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 求二叉树的最大深度
     * @param root
     * @return
     */
    public static int maximumDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lDepth = maximumDepth(root.left);
        int rDepth = maximumDepth(root.right);
        return 1 + (lDepth > rDepth ? lDepth : rDepth);
    }
}
