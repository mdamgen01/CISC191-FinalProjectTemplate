package edu.sdccd.cisc191.template;

/**
 * The BinaryAddTree class is a binary tree that stores the ideas for plants.
 * It has the methods to add a new plant into the tree.
 * It also return the plant idea in order
 */
public class BinaryAddTree {

    /**
     * An object of dataType PlantNode that represents the root of the tree
     */
    private PlantNode root;

    /**
     * The constructor method BinaryAddTree will create an empty binary tree with a null root
     */
    public BinaryAddTree() {
        this.root = null;
    }

    /**
     * The method addPlantIdea adds a new node containing the plant idea to the tree
     * It utilizes the method addPlantIdeaRecur to add the plant idea to the node recursively
     * @param plantIdea the plant idea to be added to the tree
     */
    public void addPlantIdea(String plantIdea) {
        this.root = addPlantIdeaRecur(this.root, plantIdea);
    }

    /**
     * The method addPlantIdeaRecur adds the plant idea to the node recursively
     * If the currNode is null, it will add the plant idea to the current node
     * If the plant idea to be added is less than the plant idea stored in the current node
     * then it will place the plant idea to be added on the left of the subtree
     * If the plant idea to be added is greater than the plant idea stored in the current node
     * then it will place the plant idea to be added on the right of the subtree
     * @param currNode the current node being used or processed
     * @param plantIdea the plant idea to be added in the node
     * @return the current node
     */
    private PlantNode addPlantIdeaRecur(PlantNode currNode, String plantIdea) {
        if(currNode == null) {
            return new PlantNode(plantIdea);
        }
        if(plantIdea.compareTo(currNode.getPlantIdea()) < 0) {
            currNode.setLeft(addPlantIdeaRecur(currNode.getLeft(), plantIdea));
        } else if(plantIdea.compareTo(currNode.getPlantIdea()) > 0) {
            currNode.setRight(addPlantIdeaRecur(currNode.getRight(), plantIdea));
        }
        return currNode;
    }

    /**
     * The method plantInOrder will return the plant Ideas in the tree in sorted order
     * @return String of plant ideas sorted in order
     */
    public String plantInOrder() {
        StringBuilder stringBuilder = new StringBuilder();
        plantInOrderRecur(this.root, stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * The method plantInOrderRecur will process the left subtree
     * and append a comma then will process the right subtree which happens recursively
     * @param currNode the current node
     * @param stringBuilder list of plant ideas
     */
    private void plantInOrderRecur(PlantNode currNode, StringBuilder stringBuilder) {
        if (currNode == null) {
            return;
        }

        plantInOrderRecur(currNode.getLeft(), stringBuilder);
        stringBuilder.append(currNode.getPlantIdea()).append(", ");
        plantInOrderRecur(currNode.getRight(), stringBuilder);
    }
}
