/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.classifiedindia.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Amzad
 */
public class RadioActionForm extends org.apache.struts.action.ActionForm {
    private String radio="";
    private String payment="";
    private String status ="";
    private String termandcondition ="";

    /**
     * @return the radio
     */
    public String getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(String radio) {
        this.radio = radio;
    }

    /**
     * @return the payment
     */
    public String getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the termandcondition
     */
    public String getTermandcondition() {
        return termandcondition;
    }

    /**
     * @param termandcondition the termandcondition to set
     */
    public void setTermandcondition(String termandcondition) {
        this.termandcondition = termandcondition;
    }
    
    
    
}
