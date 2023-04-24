package edu.sdccd.cisc191.template;

/**
 * The RootVegetable class extends the VegetableRequest class and Implements the VegetableFacts class
 * It is used to construct a RootVegetable object
 * It implements the VegetableFacts class that provides information about the leafy vegetable
 */
public class RootVegetable extends VegetableRequest implements VegetableFacts{
    /**
     * The container depth of the pot required for the plant
     */
    private double containerDepth;

    /**
     * Constructor for the RootVegetable object
     * @param name the name of the root vegetable
     * @param quantity the quantity of the root vegetable
     * @param variety the variety of the root vegetable
     * @param containerDepth the container depth required for the root vegetable
     */
    public RootVegetable(String name, int quantity, String variety, double containerDepth){
        super(name, quantity, variety);
        this.containerDepth = containerDepth;
    }

    /**
     * Get the container depth of the root vegetable
     * @return the container depth
     */
    public double getContainerDepth() {
        return containerDepth;
    }

    /**
     * Sets the container depth of the root vegetable
     * @param containerDepth the container depth
     */
    public void setContainerDepth(double containerDepth) {
        this.containerDepth = containerDepth;
    }

    /**
     * Returns a fact or information about the root vegetable
     * @return fact about the root vegetable
     */
    @Override
    public String VegetableFacts() {
        return "Root Vegetables require deeper container!";
    }
}
