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
import javax.persistence.JoinColumn;
import lombok.Data;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

/**
 *
 * @author Bruce Gwandu
 *
 */
@Data
@Entity
public class AccessRule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int txnid;
    private String id;
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "door_list", joinColumns = @JoinColumn(name = "txnid"))
    @Column(name = "doors")
    private List<String> doors;

}
