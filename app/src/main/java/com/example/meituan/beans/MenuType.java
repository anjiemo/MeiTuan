package com.example.meituan.beans;

public class MenuType {

    private int icon;
    private String description;

    public MenuType(int icon, String description) {
        this.icon = icon;
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
