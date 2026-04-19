package com.jony.ecommerce_dashboard.controller;

import com.jony.ecommerce_dashboard.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final DashboardService dashboardService;

    public HomeController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data", dashboardService.getDashboardData());
        return "dashboard";
    }

    @PostMapping("/track")
    public String trackCustomPage(@RequestParam("pagePath") String pagePath) {

        if (pagePath != null) {
            pagePath = pagePath.trim();

            // validation: must start with "/" and be longer than 1 character
            if (pagePath.startsWith("/") && pagePath.length() > 1) {
                dashboardService.trackPageView(pagePath);
            }
        }

        return "redirect:/";
    }

    @GetMapping("/about")
    public String about() {
        dashboardService.trackPageView("/about");
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        dashboardService.trackPageView("/contact");
        return "contact";
    }
}