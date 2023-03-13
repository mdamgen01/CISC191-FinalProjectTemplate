package edu.sdccd.cisc191.template;

/**
 * The Vegetable class extends the Plant class
 * It is used to construct a vegetable object
 */
public class Vegetable extends Plant {

    /**
     * Vegetable variety
     */
    private String variety;

    /**
     * Vegetable object constructor
     * @param name the name of the vegetable
     * @param quantity the quantity of the vegetable
     * @param variety the variety of the vegetable
     */
    public Vegetable(String name, int quantity, String variety) {
        super(name,quantity);
        this.variety = variety;
    }

    /**
     * Gets the variety of the vegetable
     * @return the variety of the vegetable
     */
    public String getVariety() {
        return variety;
    }

    /**
     *  Sets the variety of the vegetable
     * @param variety the variety of the vegetable
     */
    public void setVariety(String variety) {
        this.variety = variety;
    }
}
