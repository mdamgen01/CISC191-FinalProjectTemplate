package edu.sdccd.cisc191.template;

/**
 * The LeafyVegetable class extends the VegetableRequest class and Implements the VegetableFacts class
 * It is used to construct a leafyVegetable object
 * It implements the VegetableFacts class that provides information about the leafy vegetable
 */
public class LeafyVegetable extends VegetableRequest implements VegetableFacts{

    /**
     * Construct the LeafyVegetable Object
     * @param name the name of the leafy vegetable
     * @param quantity the quantity of the leafy vegetable
     * @param variety the variety of the leafy vegetable
     */
    public LeafyVegetable(String name, int quantity, String variety) {
        super(name, quantity, variety);
    }

    /**
     * Returns a fact or information about the leafy vegetable
     * @return fact about the leafy vegetable
     */
    @Override
    public String VegetableFacts() {
        return "Leafy Vegetables are easy to grow!";
    }
}
