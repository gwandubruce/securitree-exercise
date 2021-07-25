/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Bruce Gwandu
 * 
 */

@Data
@Entity
public class User implements Serializable {
    
    @Id
    private int userId;
    private String username;
    private String first_name;
    private String surname;
    private String password;
    
}
