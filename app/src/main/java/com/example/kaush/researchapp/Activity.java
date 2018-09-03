package com.example.kaush.researchapp;

/**
 * Created by applelab7 on 9/3/18.
 */

public class Activity {
    private String category;
    private String data;
    private String description;
    private int floor = 0;
    private String location;

    public Activity(String category, String data, String description, int floor, String location) {
        this.category = category;
        this.data = data;
        this.description = description;
        this.floor = floor;
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "category='" + category + '\'' +
                ", data='" + data + '\'' +
                ", description='" + description + '\'' +
                ", floor=" + floor +
                ", location='" + location + '\'' +
                '}';
    }
}
