package edu.sdccd.cisc191.template;

import java.io.Serializable;

/**
 * The VegetableRequest class extends the Plant class and implements Serializable
 * It is used to construct a vegetableRequest object
 */
public class VegetableRequest extends Plant implements Serializable {

    /**
     * Vegetable variety
     */
    private String variety;


    /**
     * VegetableRequest object constructor
     *
     * @param name     the name of the vegetable
     * @param quantity the quantity of the vegetable
     * @param variety  the variety of the vegetable
     */
    public VegetableRequest(String name, int quantity, String variety) {
        super(name, quantity);
        this.variety = variety;
    }

    /**
     * Gets the variety of the vegetable
     *
     * @return the variety of the vegetable
     */
    public String getVariety() {
        return variety;
    }

    /**
     * Sets the variety of the vegetable
     *
     * @param variety the variety of the vegetable
     */
    public void setVariety(String variety) {
        this.variety = variety;
    }
}
