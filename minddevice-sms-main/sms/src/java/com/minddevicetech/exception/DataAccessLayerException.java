/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.minddevicetech.exception;

/**
 *
 * @author Minddevice
 */
/**
 * Represents Exceptions thrown by the Data Access Layer.
 */
public class DataAccessLayerException extends RuntimeException {
    public DataAccessLayerException() {
    }

    public DataAccessLayerException(String message) {
        super(message);
    }

    public DataAccessLayerException(Throwable cause) {
        super(cause);
    }

    public DataAccessLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}



