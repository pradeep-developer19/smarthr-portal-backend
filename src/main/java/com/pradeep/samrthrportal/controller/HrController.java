package com.pradeep.samrthrportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hr")
public class HrController {

    @GetMapping("/test")
    public String test() {
        return "HR access granted!";
    }
}
