/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app.controllers;

import com.securitree.securitree_app.model.AccessRule;
import com.securitree.securitree_app.model.Area;
import com.securitree.securitree_app.model.Door;
import com.securitree.securitree_app.repositories.AccessRuleRepository;
import com.securitree.securitree_app.repositories.AreaRepository;
import com.securitree.securitree_app.repositories.DoorRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Bruce Gwandu
 */
@Controller
public class SecuriController {

    private final AreaRepository areaRepository;
    private final AccessRuleRepository accessRuleRepository;
    private final DoorRepository doorRepository;

    public SecuriController(AreaRepository areaRepository, AccessRuleRepository accessRuleRepository, DoorRepository doorRepository) {
        this.areaRepository = areaRepository;
        this.accessRuleRepository = accessRuleRepository;
        this.doorRepository = doorRepository;
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

    @GetMapping("/test")
    public String test() {
        return "lockdr";
    }
}
