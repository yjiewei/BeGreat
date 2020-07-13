/*
 * @author yangjiewei
 * @date 2020/7/13 9:47 
 */
package ShangGuiGu.avl;

// https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
// AVL是个名字 Adelson-Velsky-Landis Tree 发明这种自平衡树的人的名字 自平衡二叉查找树
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] a = {10,7,8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < a.length; i++) {
            avlTree.add(new Node(a[i]));
        }
        avlTree.infixOrder();
        System.out.println("平衡树的高度");
        System.out.println(avlTree.getRoot().height());

        System.out.println("平衡左子树树的高度");
        System.out.println(avlTree.getRoot().leftHeight());

        System.out.println("平衡右子树树的高度");
        System.out.println(avlTree.getRoot().rightHeight());

        System.out.println("根节点是："+ avlTree.getRoot().value);
    }
}

// 创建AVL树
class AVLTree{
    private Node root;

    public Node getRoot(){
        return root;
    }

    public void add(Node node){
        if (root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else{
            System.out.println("空树");
        }
    }

    // 查找要删除节点
    public Node search(int value){
        if (root == null){
            return null;
        }else{
            return root.search(value);
        }
    }
    // 查找父节点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }

    /**
     * 个人理解是 因为有左右子树，左右子树可能还有左右子树，删除这个节点，
     *           你得找一个放在这里，还得从右子树找到一个最小的放在这里
     * 1.返回的以node为根节点的二叉排序树的最小节点的值
     * 2.删除以node为根节点的二叉排序树的最小节点
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        //target = target.right;
        // 循环的查找左节点，就会找到最小值
        while(target.left != null){
            target = target.left;
        }
        //
        delNode(target.value);
        return target.value;
    }

    // 删除节点
    public void delNode(int value){
        if (root == null){
            return;
        }else{
            // 1.先去找要删除的节点
            Node targetValue = search(value);
            if (targetValue == null){
                return;
            }
            // 如果这棵树只有一个节点，即根节点（这里只有一个根节点，而且这个要找的点存在）
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            // 去找到目标节点的父节点
            Node parent = searchParent(value);
            // 1.如果要删除的节点是叶子节点
            if (targetValue.left == null && targetValue.right == null){
                // 判断targetValue是父节点的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value){
                    parent.left = null;
                }else if (parent.right != null && parent.right.value == value){
                    parent.right = null;
                }
                // 2.要删除的是具有两个节点的
            }else if (targetValue.left != null && targetValue.right != null){
                int min = delRightTreeMin(targetValue.right);
                targetValue.value = min;
            }else{ // 3.要删除的是只有一个子树的节点  先判断是左呢还是右子树 直接删除那个节点即可
                // 是左节点
                if (targetValue.left != null){
                    if (parent != null){
                        // 改变指向
                        if (parent.left.value == value){ // 这里可能有空指针异常，此时如果删除的根节点
                            parent.left = targetValue.left;
                        }else{
                            parent.right = targetValue.left;
                        }
                    }else{
                        root = targetValue.left;
                    }
                }else{ // 是右节点
                    if (parent != null){
                        if (parent.left.value == value){
                            parent.left = targetValue.right;
                        }else{
                            parent.right = targetValue.right;
                        }
                    }else{
                        root = targetValue.right;
                    }

                }

            }

        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 添加节点 BST 添加
    public void add(Node node){
        if (node == null){
            return;
        }
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else{
                // 这里有递归
                this.left.add(node);
            }
        }else{ // 大于等于当前节点
            if (this.right == null){
                this.right = node;
            }else{
                // 这里有递归
                this.right.add(node);
            }
        }
        // 添加完要判断平衡与否 差值为1
        // 要判断子树里面的情况先，如果也不平衡那得先调整
        // 左旋 + 双旋转
        if (rightHeight() - leftHeight() > 1){
            // 左旋之前要先判断  右子树的右节点是否为比较小的一边
            if (right != null && right.leftHeight() > right.rightHeight()){
                // 如果右子树的子树们不平衡，对右子树进行旋转
                right.rightRotate();
            }
            leftRotate();
            return;
        }
        // 右旋 + 双旋转
        if (leftHeight() - rightHeight() > 1){
            // 右旋之前要判断 左节点的右高度是否大于左节点的左高度 不然直接旋转会没效果
            if (left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
            }
            rightRotate();
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    // 删除节点
    // 查找要删除的节点
    public Node search(int value){
        if (value == this.value){
            return this;
        }else if (value < this.value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else{
            // 大于
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    // 查找要删除节点的父节点
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            return this;
        }else{
            // 如果查找的值小于当前节点的值，并且当前节点的左子节点
            if (value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if(value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }

    // 返回左子树的高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }

    // 返回右子树的高度
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }

    // 返回当前节点的高度，以该节点为根节点的树的高度、
    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height()) + 1;
    }

    // 左旋转
    public void leftRotate(){
        // 创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        // 新节点的左还是原来的，右边的变成当前的右边的左边，think
        newNode.left = left;
        newNode.right = right.left;
        // 把当前节点的值替换成右子节点的值
        value = right.value;

        right = right.right;

        left = newNode;

    }

    // 右旋转
    public void rightRotate(){
        // 创建新的节点，以当前根节点的值
        Node newNode = new Node(value);

        newNode.right = right;
        newNode.left = left.right;

        value = left.value;

        left = left.left;

        right = newNode;

    }

}
