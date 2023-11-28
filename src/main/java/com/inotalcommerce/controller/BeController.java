package com.inotalcommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeController {

	@GetMapping(value = "")
    public String getIndex(){
        return "be/index";
    }
}
