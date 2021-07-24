/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author telecel
 *
 * "id": "6C4E2C5D-BBBB-4386-AA71-B7F56727433C", "name": "Wonka Factory",
 * "parent_area_id": null, "child_area_ids
 */
@Data
@Entity
@Table(name = "areas")
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String parent_area_id;
    private List<String> child_area_ids;
    @OneToMany
    private List<Door> doors;

}
