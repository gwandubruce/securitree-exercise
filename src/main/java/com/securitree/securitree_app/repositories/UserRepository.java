/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.repositories;

import com.securitree.securitree_app.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Bruce Gwandu
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
