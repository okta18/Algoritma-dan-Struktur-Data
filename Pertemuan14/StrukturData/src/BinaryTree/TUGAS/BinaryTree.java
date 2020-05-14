
package BinaryTree.TUGAS;

public class BinaryTree {
    Node root;
    
    public BinaryTree(){
        root = null;
    }
    boolean isEmpty(){
        return  root == null;
    }
    
    void add(int data){
        if (isEmpty()) {
            root = new Node(data);
        }
        else{
            Node current = root;
            while (true) {                
                if (data < current.data) {
                    if (current.left!=null) {
                        current = current.left;
                    }else{
                        current.left = new Node(data);
                        break;
                    }
                }else if(data > current.data){
                    if (current.right!=null) {
                        current = current.right;
                    }else{
                        current.right = new Node(data);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
    }
    
    boolean find(int data){
        boolean hasil = false;
        Node current = root;
        while (current!=null) {            
            if (current.data == data) {
                hasil = true;
                break;
            }else if(data < current.data){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return hasil;
    }
    
    void traversePreOrder(Node node){
        if (node != null) {
            System.out.println(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    
    void traversePostOrder(Node node){
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(" " + node.data);
        }
    }
    
    void traverseInOrder(Node node){
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(" " + node.data);
            traverseInOrder(node.right);
        }
    }
    
    Node getSuccessor(Node del){
        Node successor = del.right;
        Node successorParent = del;
        while (successor.left != null) {            
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }
    
    void delete(int data){
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current != null) {            
            if (current.data == data) {
                break;
            }else if(data < current.data){
                  parent = current;
                  current = current.left;
                  isLeftChild = true;
            }else if(data > current.data){
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
            //deletion
            if (current == null) {
                System.out.println("Couldn't find data!");
                return;
            }else{
                //if there is no child, simply delete it
                if (current.left == null && current.right == null) {
                    if (current == root) {
                        root = null;
                    }else{
                        if (isLeftChild) {
                            parent.left = null;
                        }else{
                            parent.right = null;
                        }
                    }
                }else if(current.left == null){// if there is a 1 child (right)
                    if (current == root) {
                        root = current.right;
                    }else{
                        if (isLeftChild) {
                            parent.left = current.right;
                        }else{
                            parent.right = current.right;
                        }
                    }
                }else if(current.right == null){// if there is a 1 child (left)
                    if (current == root) {
                        root = current.left;
                    }else{
                        if (isLeftChild) {
                            parent.left = current.left;
                        }else{
                            parent.right = current.left;
                        }
                    }
                }else{// if there are 2 childs
                    Node successor = getSuccessor(current);
                    if (current == root) {
                        root = successor;
                    }else{
                        if (isLeftChild) {
                            parent.left = successor;
                        }else{
                            parent.right = successor;
                        }
                    }
                    successor.left = current.left;
                }
            }
        }
    }
    
    //SOAL 1 
    Node addRecursive(Node current, int data){
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        }else if(data > current.data){
            current.right = addRecursive(current.right, data);
        }else{
            return current;
        }
        return current;
    }
    
    //SOAL 2 
    int getMin(){
        Node current = root;
        while (current.left != null) {            
            current = current.left;
        }
        return current.data;
    }
    
    int getMax(){
        Node current = root;
        while (current.right != null) {            
            current = current.right;
        }
        return current.data;
    }
    
    //SOAL 3
    void printLeaf(Node node){
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.println(" " + node.data);
                printLeaf(node.left);
                printLeaf(node.right);
            }
        }
    }
    
    //SOAL 4
    int countLeaf(){
        return countLeaf(root);
    }
    
    int countLeaf(Node node){
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        else{
            return countLeaf(node.left) + countLeaf(node.right);
        }
    }
    
}
