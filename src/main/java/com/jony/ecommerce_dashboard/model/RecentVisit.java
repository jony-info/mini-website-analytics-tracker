package com.jony.ecommerce_dashboard.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecentVisit {

    private String pagePath;
    private LocalDateTime viewedAt;

    public RecentVisit(String pagePath, LocalDateTime viewedAt) {
        this.pagePath = pagePath;
        this.viewedAt = viewedAt;
    }

    public String getPagePath() {
        return pagePath;
    }

    public LocalDateTime getViewedAt() {
        return viewedAt;
    }

    public String getPageName() {
        if (pagePath.equals("/")) {
            return "Dashboard";
        } else if (pagePath.equals("/about")) {
            return "About";
        } else if (pagePath.equals("/contact")) {
            return "Contact";
        }
        return pagePath;
    }

    public String getFormattedViewedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return viewedAt.format(formatter);
    }
}