package com.mariammuhammad.chips;

public class MobileModel {
private  String title;
    private  String description;
    String iconText;

    public MobileModel(String title, String description, String iconText) {
        this.title = title;
        this.description = description;
        this.iconText = iconText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconText() {
        return iconText;
    }

    public void setIconText(String iconText) {
        this.iconText = iconText;
    }


}
