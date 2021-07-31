/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.services;

import com.securitree.securitree_app.model.AccessRule;
import com.securitree.securitree_app.model.Area;
import com.securitree.securitree_app.model.Door;
import com.securitree.securitree_app.model.User;
import com.securitree.securitree_app.repositories.AccessRuleRepository;
import com.securitree.securitree_app.repositories.AreaRepository;
import com.securitree.securitree_app.repositories.DoorRepository;
import com.securitree.securitree_app.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruce Gwandu
 */
@Service
public class WriteToDatabaseService {
    
    private final AccessRuleRepository accessRuleRepository;
    private final AreaRepository areaRepository;
    private final DoorRepository doorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encrypt;
    
    @Autowired
    public WriteToDatabaseService(AccessRuleRepository accessRuleRepository, AreaRepository areaRepository, DoorRepository doorRepository, UserRepository userRepository, PasswordEncoder encrypt) {
        this.accessRuleRepository = accessRuleRepository;
        this.areaRepository = areaRepository;
        this.doorRepository = doorRepository;
        this.userRepository = userRepository;
        this.encrypt = encrypt;
    }
    
    public void writeRules(List<AccessRule> rules) {
        accessRuleRepository.saveAll(rules);
    }
    
    public void writeAreas(List<Area> areas) {
        
        areaRepository.saveAll(areas);
    }
    
    public void writeDoors(List<Door> doors) {
        doorRepository.saveAll(doors);
    }
    
    public void writeUsers(List<User> users) {
      users.stream()
           .forEach(usr->usr.setPassword(encrypt.encode(usr.getPassword())));
        userRepository.saveAll(users);
    }
    
}
