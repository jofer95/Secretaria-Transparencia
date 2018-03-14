/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.st.models.accesos;

import java.util.Date;

/**
 *
 * @author ulises
 */
public class ModelTurnedOn {

    private boolean turnedOn;
    private Date date;

    public ModelTurnedOn() {
    }

    public ModelTurnedOn(boolean turnedOn, Date date) {
        this.turnedOn = turnedOn;
        this.date = date;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
