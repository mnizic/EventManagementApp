package com.nizic.app.eventmanagment;

import org.springframework.web.bind.annotation.GetMapping;

public class HomePageController {
    @GetMapping("")
    public String showHomePage() {
        return "index";
    }
}
