/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class AquaFishTester {
    public static void main(String[] args) throws Exception {
        String BF_fname ="BFT.txt";
        String NLR_fname="NLR.txt";
        String LNR_fname="LNR.txt";
        String RNL_fname="RNL.txt";
        BST_Fish_tree fTree = new BST_Fish_tree();
        fTree.add_recur("31","11","57","06","18","40","80",
                "02","16","22","35","50","70","90");
        fTree.add("01","05","15","17","34","37","45","85","03");
        System.out.println("Bread First traversal: ");
        fTree.BF_Treavese();
        System.out.println("NLR traversal: ");
        fTree.NLR();
        System.out.println("LNR traversal: ");
        fTree.LNR();
        System.out.println("RNL traversal: ");
        fTree.RNL();
        System.out.println("Traverse the tree to file: ");
        fTree.BF_Traverse_F(BF_fname);
        fTree.NLR_F(NLR_fname);
        fTree.LNR_F(LNR_fname);
        fTree.RNL_F(RNL_fname);
        System.out.println("Done.");
        System.out.println("Recursive Search Operation: ");
        AquariumFish fish1 = new AquariumFish("99");
        AquariumFish fish2 = new AquariumFish("50");
        BST_Node node = fTree.search_Recur(fish1);
        if(node==null) System.out.println("Fish : "+fish1+" Not found");
        else System.out.println("Fish found: "+node.fish);
        node = fTree.search_Recur(fish2);
        if(node==null)System.out.println("Fish: "+fish2+"Not Found");
        else System.out.println("Fish found: "+node.fish);
        System.out.println("Non-Recursive search oparation");
        node=fTree.search_Recur(fish1);
        if(node==null)System.out.println("Fish : "+fish1+"Not Found");
        else System.out.println("Fish found: "+node.fish);
        node = fTree.search(fish2);
        if(node==null)System.out.println("Fish : "+fish2+"Not Found");
        else System.out.println("Fish found: "+node.fish);
        System.out.println("Min: "+fTree.leftMost().fish);
        System.out.println("Max: "+fTree.rightMost().fish);
        System.out.println("Tree's height: "+fTree.height());
        //test remove
        AquariumFish remFish = new AquariumFish("45");
        fTree.deleteFish(remFish);
        remFish= new AquariumFish("06");
        fTree.deleteFish(remFish);
        remFish= new AquariumFish("32");
        fTree.deleteFish(remFish);
        System.out.println("After deleting 3 node . result: ");
        fTree.LNR();
        System.out.println("New tree's height "+fTree.height());
    }
}
