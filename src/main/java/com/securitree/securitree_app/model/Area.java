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
 * @author telecel
 *
 * "id": "6C4E2C5D-BBBB-4386-AA71-B7F56727433C", "name": "Wonka Factory",
 * "parent_area_id": null, "child_area_ids
 */
@Data
public class Area {

    private String id;
    private String name;
    private String parent_area_id;
    private List<String> child_area_ids;

}
