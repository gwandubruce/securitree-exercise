/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.repositories;

import com.securitree.securitree_app.model.AccessRule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruce Gwandu
 */
@Repository
public interface AccessRuleRepository extends JpaRepository<AccessRule, Integer> {

    @Query("SELECT DISTINCT name FROM AccessRule name WHERE :door MEMBER OF name.doors")
    List<AccessRule> findByDoorId(@Param("door") String door);

}
