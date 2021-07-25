/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Bruce Gwandu
 *
 *
 */
@Data
@Entity
@Table(name = "areas")
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int txnid;
    private String id;
    private String name;
    private String parent_area_id;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "child_list", joinColumns = @JoinColumn(name = "txnid"))
    @Column(name = "child_area_ids")
    private List<String> child_area_ids;
    @OneToMany
    private List<Door> doors;
    @ManyToOne
    @JoinColumn(name = "FK_PARENT_AREA")
    public Area parentArea;
    @OneToMany(mappedBy = "parentArea", orphanRemoval = true)
    public List<Area> childAreas = new ArrayList<Area>();

}
