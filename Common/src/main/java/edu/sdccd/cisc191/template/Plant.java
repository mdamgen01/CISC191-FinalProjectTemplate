package edu.sdccd.cisc191.template;

import java.io.Serializable;

/**
 * Plant Class is a class representing a generic plant
 * It also implements Serializable so it's subclasses can be serialized and deserialized
 * It is used as a based class to create more specific type of plants
 */
public class Plant implements Serializable {

    /**
     * Plant name
     */
    private String name;

    /**
     * Plant quantity
     */
    private int quantity;

    /**
     * Constructor for a plant
     * @param name the name of the plant
     * @param quantity the quantity of the plant
     */
    public Plant(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Get plant name
     * @return the name of the plant
     */
    public String getName() {
        return name;
    }

    /**
     * Get plant quantity
     * @return the quantity of plant
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the plant name
     * @param name the name of the plant
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the quantity of the plant
     * @param quantity the quantity of the plant
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
