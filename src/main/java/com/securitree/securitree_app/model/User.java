/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.model;

import lombok.Data;

/**
 *
 * @author telecel
 * 
 * 
 * 
 *   {
            {
            "username": "knopel",
            "first_name": "Leslie",
            "surname": "Knope",
            "password": "jjsdiner"
        },"
        },
 */

@Data
public class User {
    
    private String username;
    private String first_name;
    private String surname;
    private String password;
    
}
