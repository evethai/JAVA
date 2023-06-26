
import java.io.PrintWriter;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class BST_Fish_tree {

    BST_Node root;

    //create an empty tree
    public BST_Fish_tree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BST_Node add_recur(BST_Node curref, AquariumFish fish) {
        if (curref == null) {
            curref = new BST_Node(fish);
        } else if (fish.compareTo(curref.fish) < 0) {
            curref.left = add_recur(curref.left, fish);
        } else {
            curref.right = add_recur(curref.right, fish);
        }
        return curref;
    }

    /*
    Add 6 to the root (node 5)
 6>5  Add 6 to the node root.right (node 8)
 6 < 8  Add 6 to (node 8 ).left
    add by pp Đệ Quy.(recursive)
     */
    public void add_recur(AquariumFish fish) {
        root = add_recur(root, fish);
    }

    public void add_recur(String... names) {
        for (String name : names) {
            add_recur(new AquariumFish(name));
        }
    }//tham số thay đổi

    // add new node to BST non-recursive(không đệ quy)
    public void add(AquariumFish fish) {
        BST_Node newNode = new BST_Node(fish);
        if (root == null) {
            root = newNode;
        } else {
            BST_Node pFather = null;
            BST_Node pBefore = root;
            //determin the father node
            while (pBefore != null) {
                pFather = pBefore;
                if (fish.compareTo(pBefore.fish) < 0) {
                    pBefore = pBefore.left;
                } else {
                    pBefore = pBefore.right;
                }
            }
            //Link pfather to the newnode
            if (fish.compareTo(pFather.fish) < 0) {
                pFather.left = newNode;
            } else {
                pFather.right = newNode;
            }
        }
    }

    public void add(String... names) {
        for (String name : names) {
            add(new AquariumFish(name));
        }
    }

    //Search_recur
    private BST_Node search_Recur(BST_Node curref, AquariumFish fish) {
        if (curref == null) {
            return null;
        } else {
            AquariumFish curFish = curref.fish;
            int d = fish.compareTo(curFish);
            if (d == 0) {
                return curref;
            } else if (d < 0) {
                return search_Recur(curref.left, fish);
            } else {
                return search_Recur(curref.right, fish);
            }
        }
    }

    public BST_Node search_Recur(AquariumFish fish) {
        return search_Recur(root, fish);
    }

    public BST_Node search(AquariumFish fish) {
        if (this.isEmpty()) {
            return null;
        }
        BST_Node t = root;
        AquariumFish curFish;
        while (t != null) {
            curFish = t.fish;
            int d = fish.compareTo(curFish);
            if (d == 0) {
                return t;
            } else if (d < 0) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        return null;
    }

    //left
    public BST_Node leftMost(BST_Node treeRoot) {
        BST_Node result = treeRoot;
        while (result.left != null) {
            result = result.left;
        }
        return result;
    }

    public BST_Node leftMost() {
        return leftMost(root);
    }

    //right
    public BST_Node rightMost(BST_Node treeRoot) {
        BST_Node result = treeRoot;
        while (result.right != null) {
            result = result.right;
        }
        return result;
    }

    public BST_Node rightMost() {
        return rightMost(root);
    }

    //visit
    public void visit(BST_Node node) {
        System.out.println(node.fish);
    }

    public void visitF(PrintWriter pw, BST_Node node) {
        try {
            pw.println(node.fish);//write a fish to the file in a line
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void BF_Treavese() {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
            return;
        }
        MyQueue queue = new MyQueue();
        queue.enqueue(root);
        BST_Node node ;
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            visit(node);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    public void BF_Traverse_F(String filename) throws Exception {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
            return;
        }
        PrintWriter pw = new PrintWriter(filename);
        MyQueue queue = new MyQueue();
        queue.enqueue(root);
        BST_Node node;
        while (!queue.isEmpty()) {
            node = queue.dequeue();
            visitF(pw, node);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
        pw.close();
    }

    private void NLR(BST_Node p) {
        if (p != null) {
            visit(p);
            NLR(p.left);
            NLR(p.right);
        }
    }

    public void NLR() {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            NLR(root);
        }
    }

    private void NLR_F(PrintWriter pw, BST_Node p) {
        if (p != null) {
            try {
                visitF(pw, p);//write fish to file
                NLR_F(pw, p.left);
                NLR_F(pw, p.right);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void NLR_F(String filename) throws Exception {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            PrintWriter pw = new PrintWriter(filename);
            NLR_F(pw, root);
            pw.close();
        }
    }

    private void LNR(BST_Node p) {
        if (p != null) {

            LNR(p.left);
            visit(p);
            LNR(p.right);
        }
    }

    public void LNR() {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            LNR(root);
        }
    }

    private void LNR_F(PrintWriter pw, BST_Node p) {
        if (p != null) {
            try {
                LNR_F(pw, p.left);
                visitF(pw, p);//write fish to file
                LNR_F(pw, p.right);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void LNR_F(String filename) throws Exception {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            PrintWriter pw = new PrintWriter(filename);
            LNR_F(pw, root);
            pw.close();
        }
    }

    private void RNL(BST_Node p) {
        if (p != null) {
            RNL(p.right);
            visit(p);
            RNL(p.left);
        }
    }

    public void RNL() {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            RNL(root);
        }
    }

    private void RNL_F(PrintWriter pw, BST_Node p) {
        if (p != null) {
            try {
                RNL_F(pw, p.right);
                visitF(pw, p);//write fish to file
                RNL_F(pw, p.left);
           
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void RNL_F(String filename) throws Exception {
        if (this.isEmpty()) {
            System.out.println("Empty tree!");
        } else {
            PrintWriter pw = new PrintWriter(filename);
            RNL_F(pw, root);
            pw.close();
        }
    }
    private int countchild(BST_Node node){
        int c1 = node.left!=null?1:0;
        int c2 = node.right!=null?1:0;
        return c1+c2;
    }
    private BST_Node deleteLeaf(BST_Node father, BST_Node deletedChild){
        if(deletedChild==root)root= null;
        else{
            if(father.left==deletedChild)father.left=null;
            else father.right=null;
        }return deletedChild;
    }
    private BST_Node deleteOneChildNode(BST_Node father, BST_Node deletedChild){
        if(deletedChild==root){
            root=root.left!=null?root.left:root.right;
        }
        else{
            BST_Node grandChild;
            if(deletedChild.left!=null)grandChild=deletedChild.left;
            else grandChild=deletedChild.right;
            if(father.left==deletedChild)father.left=grandChild;
            else father.right=grandChild;
        }
        return deletedChild;
    }
    private BST_Node deleteTwoChildrenNodebyCopy(BST_Node deleted){
        BST_Node father = deleted;
        BST_Node rightMost = deleted.left;
        while (rightMost.right!=null){
            father = rightMost;
            rightMost=rightMost.right;
        }
        deleted.fish=rightMost.fish;
        int count = countchild(rightMost);
        if(count==0)return deleteLeaf(father, rightMost);
        else return deleteOneChildNode(father, rightMost);
    }
    public BST_Node deleteFish (AquariumFish f){
        if(this.isEmpty()) return null;
        BST_Node deleted = root, father =null;
        while (deleted!=null){
            int d= f.compareTo(deleted.fish);
            if(d==0) break;
            else{
                father =deleted;
                if(d<0) deleted=deleted.left;
                else deleted =deleted.right;
            }
        }
        if(deleted==null)return null;
        int count = countchild(deleted);
        if(count==0)return deleteLeaf(father, deleted);
        if(count==1)return deleteOneChildNode(father, deleted);
        return deleteTwoChildrenNodebyCopy(deleted);
    }
    private class Node_Level{
        BST_Node node;
        int level;
        public Node_Level(BST_Node node, int level){
            this.node=node;
            this.level=level;
        }
    }
    public int height(){
        if (this.isEmpty())return 0;
        int level =1, maxlevel=1;
        LinkedList<Node_Level> queue = new LinkedList<>();
        queue.addLast(new Node_Level(root, level));
        while(!queue.isEmpty()){
            Node_Level nL = queue.removeFirst();
            level =nL.level;
            if(maxlevel<level)maxlevel=level;
            if(nL.node.left!=null)
                queue.addLast(new Node_Level(nL.node.left, level+1));
            if(nL.node.right!=null)
                queue.addLast(new Node_Level(nL.node.right, level+1));
        }
        return maxlevel;
    }
    
}
