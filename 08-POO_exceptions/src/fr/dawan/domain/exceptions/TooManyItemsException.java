/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dawan.domain.exceptions;

/**
 *
 * @author bmarron
 */
public class TooManyItemsException extends DawanException{
    
    public TooManyItemsException(String message) {
        super(message);
    }
    
}
