package com.jony.ecommerce_dashboard.controller;

import com.jony.ecommerce_dashboard.model.DashboardData;
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
    public String showDashboard(Model model) {
        dashboardService.trackPageView("/");

        DashboardData dashboardData = dashboardService.getDashboardData();
        model.addAttribute("data", dashboardData);

        return "dashboard";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        dashboardService.trackPageView("/about");
        return "about";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        dashboardService.trackPageView("/contact");
        return "contact";
    }

    @PostMapping("/track")
    public String trackCustomPage(@RequestParam String pagePath) {
        if (pagePath != null && pagePath.startsWith("/")) {
            dashboardService.trackPageView(pagePath);
        }

        return "redirect:/";
    }
}