/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.repositories;

import com.securitree.securitree_app.model.Door;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruce Gwandu
 */
@Repository
public interface DoorRepository extends JpaRepository<Door, Integer> {
    
    Door findById(String id);
    List<Door> findByParentArea(String parent_area);
  
}
