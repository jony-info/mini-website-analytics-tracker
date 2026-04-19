package com.jony.ecommerce_dashboard.model;

import java.util.List;

public class DashboardData {

    private long totalViews;
    private long viewsToday;
    private long homeViews;
    private long aboutViews;
    private long contactViews;
    private List<RecentVisit> recentVisits;

    public DashboardData(long totalViews, long viewsToday, long homeViews, long aboutViews, long contactViews, List<RecentVisit> recentVisits) {
        this.totalViews = totalViews;
        this.viewsToday = viewsToday;
        this.homeViews = homeViews;
        this.aboutViews = aboutViews;
        this.contactViews = contactViews;
        this.recentVisits = recentVisits;
    }

    public long getTotalViews() {
        return totalViews;
    }

    public long getViewsToday() {
        return viewsToday;
    }

    public long getHomeViews() {
        return homeViews;
    }

    public long getAboutViews() {
        return aboutViews;
    }

    public long getContactViews() {
        return contactViews;
    }

    public List<RecentVisit> getRecentVisits() {
        return recentVisits;
    }
}