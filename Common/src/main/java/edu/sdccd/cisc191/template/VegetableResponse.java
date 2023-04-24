package edu.sdccd.cisc191.template;

import java.io.Serializable;

/**
 * The class VegetableResponse implements the interface Serializable
 */
public class VegetableResponse implements Serializable {

    /**
     * The vegetable requested
     */
    private VegetableRequest request;

    /**
     * The status of the vegetable requested
     */
    private String status;

    /**
     * Constructor method for VegetableResponse Class
     * @param request the requested vegetable
     * @param status the status of the requested vegetable
     */
    public VegetableResponse (VegetableRequest request, String status) {
        this.request = request;
        this.status = status;
    }

    /**
     * Gets the requested vegetable
     * @return the vegetable requested
     */
    public VegetableRequest getRequest() {
        return request;
    }

    /**
     * Get's the status of the vegetable requested
     * @return the status of the vegetable requested
     */
    public String getStatus() {
        return status;
    }

    /**
     * The toString method is an override of the toString method of Object Class
     * @return The requested vegetables name and it's status in a string
     */
    @Override
    public String toString() {
        return "Don't forget to harden off " + request.getName() + " before " + status;
    }
}
