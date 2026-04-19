package com.jony.ecommerce_dashboard.service;

import com.jony.ecommerce_dashboard.entity.PageView;
import com.jony.ecommerce_dashboard.model.DashboardData;
import com.jony.ecommerce_dashboard.model.RecentVisit;
import com.jony.ecommerce_dashboard.repository.PageViewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    private final PageViewRepository pageViewRepository;

    public DashboardService(PageViewRepository pageViewRepository) {
        this.pageViewRepository = pageViewRepository;
    }

    public void trackPageView(String pagePath) {
        PageView pageView = new PageView(pagePath, LocalDateTime.now());
        pageViewRepository.save(pageView);
    }

    public DashboardData getDashboardData() {
        List<PageView> pageViews = pageViewRepository.findAll();

        long totalViews = pageViews.size();
        long viewsToday = 0;
        long homeViews = 0;
        long aboutViews = 0;
        long contactViews = 0;

        for (PageView pageView : pageViews) {
            if (pageView.getViewedAt().toLocalDate().equals(LocalDate.now())) {
                viewsToday++;
            }

            String path = pageView.getPagePath();

            if (path.equals("/")) {
                homeViews++;
            } else if (path.equals("/about")) {
                aboutViews++;
            } else if (path.equals("/contact")) {
                contactViews++;
            }
        }

        List<RecentVisit> recentVisits = new ArrayList<>();

        int startIndex = Math.max(0, pageViews.size() - 5);
        for (int i = pageViews.size() - 1; i >= startIndex; i--) {
            PageView pageView = pageViews.get(i);
            recentVisits.add(new RecentVisit(pageView.getPagePath(), pageView.getViewedAt()));
        }

        return new DashboardData(
                totalViews,
                viewsToday,
                homeViews,
                aboutViews,
                contactViews,
                recentVisits
        );
    }
}