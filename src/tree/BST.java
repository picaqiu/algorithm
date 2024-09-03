package tree;

//Binary Search Tree
public class BST {
    private TreeNode root;

    public BST() {
    }


    public TreeNode search(int target) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.value == target) {
                return cur;
            } else if (cur.value < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        return cur;
    }


    public void insert(int num) {
        if (root == null) {
            root = new TreeNode(num);
            return;
        }
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.value < num) {
                pre = cur;
                cur = cur.right;
            } else if (cur.value > num) {
                pre = cur;
                cur = cur.left;
            } else {
                return;
            }
        }
        TreeNode node = new TreeNode(num);
        if (pre.value > num) {
            pre.left = node;
        } else {
            pre.right = node;
        }
    }


    public void delete(int target) {
        TreeNode cur = root, pre = null;

        while (cur != null) {
            if (cur.value < target) {
                pre = cur;
                cur = cur.right;
            } else if (cur.value > target) {
                pre = cur;
                cur = cur.left;
            } else {
                //删除节点度为0或节点度为1的节点
                if (cur.left == null || cur.right == null) {
                    TreeNode child = cur.left != null ? cur.left : cur.right;
                    if (cur == root) {
                        root = null;
                        return;
                    } else {
                        if (pre.left == cur) {
                            pre.left = child;
                        } else {
                            pre.right = child;
                        }
                    }
                }
                //删除节点度为2
                //将删除的节点替换成左子树最大的节点或者右子树最小的节点（这里使用右子树最小节点）
                else {
                    TreeNode tmp = cur.right;
                    while (tmp.left != null) {
                        tmp = tmp.left;
                    }
                    //递归删除
                    delete(tmp.value);
                    cur.value = tmp.value;
                }
            }
        }

    }
}
