/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.controllers;

import com.securitree.securitree_app.model.Area;
import com.securitree.securitree_app.model.Door;
import com.securitree.securitree_app.repositories.AccessRuleRepository;
import com.securitree.securitree_app.repositories.AreaRepository;
import com.securitree.securitree_app.repositories.DoorRepository;
import com.securitree.securitree_app.services.DoorManagerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bruce Gwandu
 */
@Controller
public class SecuriController {

    private final AreaRepository areaRepository;
    private final AccessRuleRepository accessRuleRepository;
    private final DoorRepository doorRepository;
    private final DoorManagerService doorManagerService;

    @Autowired
    public SecuriController(AreaRepository areaRepository, AccessRuleRepository accessRuleRepository, DoorRepository doorRepository, DoorManagerService doorManagerService) {
        this.areaRepository = areaRepository;
        this.accessRuleRepository = accessRuleRepository;
        this.doorRepository = doorRepository;
        this.doorManagerService = doorManagerService;
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/manage")
    public String manage() {
        return "manage_doors";
    }

    @GetMapping("/view")
    public String viewTree(Model model) {

        List<Area> areas = areaRepository.findAll();
        model.addAttribute("areas", areas);
        model.addAttribute("doors", doorRepository);
        model.addAttribute("areaRepo", areaRepository);
        model.addAttribute("rules", accessRuleRepository);

        return "hierarchy_screen";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/lock")
    public String lock(Model model) {
        model.addAttribute("door", new Door());
        return "lockdr";
    }

    @GetMapping("/unlock")
    public String test(Model model) {
        model.addAttribute("door", new Door());
        return "unlockdr";
    }

    @RequestMapping("/submit")
    public String lock(@ModelAttribute Door door, Errors errors) {
        if (!errors.hasErrors()) {
            doorManagerService.lockDoor(door);
            return "submit";
        }
        return "error";
    }

    @RequestMapping("/submit0")
    public String unlock(@ModelAttribute Door door, Errors errors) {
        if (!errors.hasErrors()) {
            doorManagerService.unlockDoor(door);
            return "submit0";
        }
        return "error";

    }
}
