/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newage.erp.backBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author mohammed
 */
@Named(value = "indexBack")
@Dependent
public class IndexBack {

    /**
     * Creates a new instance of IndexBack
     */
    public IndexBack() {
    }
    
    public String hello() {
        return "hello from back";
    }
    
}
