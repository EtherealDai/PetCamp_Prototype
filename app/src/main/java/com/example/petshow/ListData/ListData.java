package com.example.petshow.ListData;

public class ListData {
    private String title;
    private String description;
    private boolean isSelected;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ListData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
