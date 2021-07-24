/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Bruce Gwandu
 *
 */

@Data
public class AccessRule {

    private String id;
    private String name;
    private List<String> doors;

}
