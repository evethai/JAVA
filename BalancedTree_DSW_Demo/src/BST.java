/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class BST {

    BST_Node root;
    int noOfNodes = 0;

    public BST() {
        root = null;
    }

    public BST_Node add_Recur(BST_Node curref, Comparable data) {
        if (curref == null) {
            curref = new BST_Node(data);
            noOfNodes++;
        } else if (data.compareTo(curref.data) < 0) {
            curref.left = add_Recur(curref.left, data);
        } else {
            curref.right = add_Recur(curref.right, data);
        }
        return curref;
    }

    public void add_recur(Comparable data) {
        root = add_Recur(root, data);
    }

    public void add_recur(Comparable... group) {
        for (Comparable data : group) {
            add_recur(data);
        }
    }

    public void add_Array(Comparable[] group) {
        for (Comparable data : group) {
            add_recur(data);
        }
    }

    private void printAligned(BST_Node p, int nSpace) {
        if (p != null) {
            for (int i = 0; i < nSpace; i++) {
                System.out.print(" ");
            }
            System.out.println(p.data);
            printAligned(p.left, nSpace+3);
            printAligned(p.right, nSpace+3);
        }
    }

    public void printAligned() {
        if (root == null) {
            System.out.println("Empty Tree!");
        } else {
            printAligned(root, 0);
        }
    }

    public void rotateRight(BST_Node Gr, BST_Node Par, BST_Node Ch) {
        if (Par == root) {
            root = Ch;
        } else {
            Gr.right = Ch;
        }
        Par.left = Ch.right;
        Ch.right = Par;
    }

    void createBackBone() {
        BST_Node Gr = null, Par = root, leftChild;
        while (Par != null) {
            while (Par.left != null) {
                leftChild = Par.left;
                rotateRight(Gr, Par, leftChild);
                Par = leftChild;
            }
            Gr = (Gr == null) ? root : Gr.right;
            Par = Par.right;
        }
    }

    private double log2(double x) {
        return Math.log(x) / Math.log(2);
    }

    private int heighPerfectbalnceTree(int noOfNodes) {
        return (int) log2(noOfNodes + 1);
    }

    private int sizeofPerfectBalanceTree(int H) {
        return (int) (Math.pow(2, H) - 1);
    }

    public void rotateleft(BST_Node Gr, BST_Node Par, BST_Node Ch) {
        if (Par == root) {
            root = Ch;
        } else {
            Gr.right = Ch;
        }
        Par.right = Ch.left;
        Ch.left = Par;
    }

    void createBalancedTree() {
        int H = heighPerfectbalnceTree(noOfNodes);

        int Psize = sizeofPerfectBalanceTree(H);

        int extraNodes = noOfNodes - Psize;

        BST_Node Gr = null, Par = root, rightChild = Par.right;
        for (int i = 0; i < extraNodes; i++) {
            rotateleft(Gr, Par, rightChild);
            Gr = rightChild;
            Par = Gr.right;
            if (Par != null) {
                rightChild = Par.right;
            } else {
                rightChild = null;
            }
        }
        Gr = root;
        while (Psize > 1) {
            Psize /= 2;
            Gr = null;
            Par = root;
            rightChild = Par.right;
            for (int i = 0; i < Psize; i++) {
                if (rightChild != null) {
                    rotateleft(Gr, Par, rightChild);
                    Gr = rightChild;
                    Par = Gr.right;
                    if (Par != null) {
                        rightChild = Par.right;
                    } else {
                        rightChild = null;
                    }
                }
            }
        }
    }

    //Use DSW algrithirm 
    public void DSW_Balance() {
        if (root != null) {
            createBackBone();
            createBalancedTree();
        }
    }

}
