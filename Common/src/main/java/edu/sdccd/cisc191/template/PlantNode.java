package edu.sdccd.cisc191.template;

/**
 * The class PlantNode represents the nodes in the binary tree
 */
public class PlantNode {

    /**
     * The plant idea
     */
    private String plantIdeas;

    /**
     * The left node
     */
    private PlantNode left;

    /**
     * The right node
     */
    private PlantNode right;

    /**
     * The method constructor for PlantNode
     * @param plantIdeas the plant ideas
     */
    public PlantNode(String plantIdeas) {
        this.plantIdeas = plantIdeas;
        this.right = null;
        this.left = null;
    }

    /**
     * Gets the plant ideas
     * @return the plant ideas
     */
    public String getPlantIdea() {
        return plantIdeas;
    }

    /**
     * Gets the right node
     * @return the right node
     */
    public PlantNode getRight() {
        return right;
    }

    /**
     * Gets the left node
     * @return the left node
     */
    public PlantNode getLeft() {
        return left;
    }

    /**
     * Sets the plant ideas
     * @param plantIdeas
     */
    public void setPlantIdea(String plantIdeas) {
        this.plantIdeas = plantIdeas;
    }

    /**
     * Sets the left node
     * @param left the left node
     */
    public void setLeft(PlantNode left) {
        this.left = left;
    }

    /**
     * Sets the right node
     * @param right the right node
     */
    public void setRight(PlantNode right) {
        this.right = right;
    }

}
