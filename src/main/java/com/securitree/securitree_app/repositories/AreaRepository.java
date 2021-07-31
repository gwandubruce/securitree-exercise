/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.repositories;

import com.securitree.securitree_app.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruce Gwandu
 */
@Repository
public interface AreaRepository extends JpaRepository<Area, Integer>{
    
    Area findById(String id);
    
}
