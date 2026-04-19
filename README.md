# Mini Website Analytics Tracker

A simple analytics web application built with Java and Spring Boot.

## Features

- Tracks page views (home, about, contact, and custom pages)
- Stores visit data using H2 database
- Displays analytics in a dashboard:
  - Total views
  - Views today
  - Page-specific view counts
  - Recent visit history
- Allows manual tracking via input form

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- H2 Database

## How It Works

When a page is visited or a custom path is submitted, the application records a page-view event with a timestamp.

The backend processes these events and calculates analytics, which are displayed in the dashboard.

## Running the Project

```bash
mvn spring-boot:run