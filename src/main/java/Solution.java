import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) return values;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode lastVisited = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.peek();
            if (node.right != null && node.right != lastVisited) {
                root = node.right;
            } else {
                values.add(node.val);
                lastVisited = stack.pop();
            }
        }
        return values;
    }
}