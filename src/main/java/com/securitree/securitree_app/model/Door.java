/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.model;

import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author telecel
 *
 *
 */
@Data
public class Door {

    private String id;
    private String name;
    private String parent_area;
    private String status;
    @ManyToOne
    private Area area;
    @OneToMany
    private List<AccessRule> accessRules;

}
