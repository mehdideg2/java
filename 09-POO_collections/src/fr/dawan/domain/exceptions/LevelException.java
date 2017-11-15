/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dawan.domain.exceptions;

import fr.dawan.domain.enums.Niveau;

/**
 *
 * @author bmarron
 */
public class LevelException extends DawanException{
    Niveau current;
    Niveau expected;

    public LevelException(String message, Niveau current, Niveau expected) {
        super(message);
        this.current = current;
        this.expected = expected;
    }

    public Niveau getCurrent() {
        return current;
    }

    public void setCurrent(Niveau current) {
        this.current = current;
    }

    public Niveau getExpected() {
        return expected;
    }

    public void setExpected(Niveau expected) {
        this.expected = expected;
    }

}
