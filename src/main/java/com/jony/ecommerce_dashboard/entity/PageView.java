package com.jony.ecommerce_dashboard.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "page_views")
public class PageView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pagePath;

    private LocalDateTime viewedAt;

    public PageView() {
    }

    public PageView(String pagePath, LocalDateTime viewedAt) {
        this.pagePath = pagePath;
        this.viewedAt = viewedAt;
    }

    public Long getId() {
        return id;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public LocalDateTime getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(LocalDateTime viewedAt) {
        this.viewedAt = viewedAt;
    }
}