/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Bruce Gwandu
 *
 *
 */
@Data
@Entity
public class Door implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int txnid;
    @Column(name = "door_id")
    private String id;
    private String name;
    @Column(name = "area_id")
    private String parentArea;
    private String status;


}
