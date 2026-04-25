package tries;

import binarysearchtrees.ds.BST;

import java.awt.desktop.AboutEvent;

public class ValidateThreeNodes {

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        BST searchOne = nodeOne;
        BST searchTwo = nodeThree;

        while (true){
            boolean foundNodeTwo = (searchOne == nodeTwo || searchTwo == nodeTwo);
            boolean finishedSearching = (searchOne == null && searchTwo == null);
            boolean crossed = (searchOne == nodeThree || searchTwo == nodeOne);

            if(foundNodeTwo || finishedSearching || crossed){
                break;
            }

            if(searchOne != null){
                searchOne = searchOne.value > nodeTwo.value ? searchOne.left : searchOne.right;
            }

            if(searchTwo != null){
                searchTwo = searchTwo.value > nodeTwo.value ? searchTwo.left : searchTwo.right;
            }

        }
        // if neither reached nodeTwo, invalid
        if(searchOne != nodeTwo && searchTwo != nodeTwo){
            return false;
        }

        // determine direction
        return searchForTarget(nodeTwo, searchOne == nodeTwo ? nodeThree : nodeOne);
    }

    public boolean searchForTarget(BST node, BST target){
        while (node != null && node != target){
            node =  node.value > target.value ? node.left : node.right;
        }
        return node == target;
    }



//    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
//
//        if(isDescendant(nodeTwo, nodeOne)){
//            return isDescendant(nodeThree, nodeTwo);
//        }
//
//        if(isDescendant(nodeTwo, nodeThree)){
//            return isDescendant(nodeOne, nodeThree);
//        }
//
//        return false;
//    }
//
//    private boolean isDescendant(BST node, BST target) {
//        if(node == null){
//            return false;
//        }
//
//        if(node == target){
//            return true;
//        }
//        return target.value < node.value ? isDescendant(node.left, target) : isDescendant(node.right, target);
//    }

//    private boolean isDescendant(BST node, BST target){
//        while(node != null && node != target){
//            node = node.value > target.value ? node.left : node.right;
//        }
//        return node == target;
//    }


}
