/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securitree.securitree_app;

import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 *
 * @author Bruce Gwandu
 */
@RunWith(SpringRunner.class)
public class FrontEndWebPageTests {
    
    	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testHomePage() throws Exception{
		
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("home"))
		.andExpect(content().string(containsString("View ...")));
	}
        @Test
	public void testViewHierarchyScreen() throws Exception{
		
		mockMvc.perform(get("/view"))
		.andExpect(status().isOk())
		.andExpect(view().name("hierarchy_screen"))
		.andExpect(content().string(containsString("Securitree View ...")));
	}
             @Test
	public void testManageDoorsScreen() throws Exception{
		
		mockMvc.perform(get("/view"))
		.andExpect(status().isOk())
		.andExpect(view().name("manage_doors"))
		.andExpect(content().string(containsString("Manage Door Menu ...")));
	}
    
}
