package binarytrees;

import binarytrees.ds.BinaryTree;

public class BinaryTreeDiameter {

   static class Dia{
       int diameter;
       int height;

       public Dia(int diameter, int height) {
           this.diameter = diameter;
           this.height = height;
       }
   }
    public int binaryTreeDiameter(BinaryTree tree) {
        return findDiameter(tree).diameter;
    }

    public Dia findDiameter(BinaryTree tree) {
       if(tree == null) return new Dia(0, 0);

       Dia leftDia =  findDiameter(tree.left);
       Dia rightDia =  findDiameter(tree.right);

       int height = Math.max(leftDia.height, rightDia.height) + 1;
       int diameter = Math.max(
               Math.max(leftDia.diameter, rightDia.diameter),
               leftDia.height + rightDia.height);
       return new Dia(diameter, height);
    }
}
