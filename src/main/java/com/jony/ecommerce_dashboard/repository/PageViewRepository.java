package com.jony.ecommerce_dashboard.repository;

import com.jony.ecommerce_dashboard.entity.PageView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageViewRepository extends JpaRepository<PageView, Long> {
}