/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softapple.online.doctor.common.enums;
/**
 *
 * @author Md. Zakir Hossain
 */
public enum ViewStatus {
    VISIBLE(1),
    INVISIBLE(0);
    
    private final int code;

    private ViewStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
}
