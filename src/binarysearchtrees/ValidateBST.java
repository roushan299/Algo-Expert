package binarysearchtrees;

import binarysearchtrees.ds.BST;

public class ValidateBST {

    public static boolean validateBst(BST tree) {
        return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validate(BST tree, int minValue, int maxValue) {
        if(tree == null) return true;

        if(tree.value < minValue || tree.value >= maxValue) return false;

        boolean isLeftValid = validate(tree.left, minValue, tree.value);
        boolean isRightValid = validate(tree.right, tree.value, maxValue);
        return isLeftValid && isRightValid;
    }

}
