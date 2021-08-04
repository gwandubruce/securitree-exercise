/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.services;

import com.securitree.securitree_app.model.Door;
import com.securitree.securitree_app.repositories.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bruce Gwandu
 */
@Service
public class DoorManagerService {

    private final DoorRepository doorRepository;

    @Autowired
    public DoorManagerService(DoorRepository doorRepository) {
        this.doorRepository = doorRepository;
    }

    public void lockDoor(Door door) {
        Door dr = doorRepository.findById(door.getId());
        dr.setStatus("LOCKED");
        doorRepository.save(dr);
    }

    public void unlockDoor(Door door) {
         Door dr = doorRepository.findById(door.getId());
        dr.setStatus("UNLOCKED");
        doorRepository.save(dr);
    }

}
