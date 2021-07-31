/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Bruce Gwandu
 *
 */
@Data
@Entity
@Table(name = "accessrules")
public class AccessRule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int txnid;
    @Column(name = "rule_id")
    private String id;
    private String name;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "rule_door_map")
    private List<String> doors;
    

}
