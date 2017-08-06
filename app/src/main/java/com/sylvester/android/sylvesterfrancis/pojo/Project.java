package com.sylvester.android.sylvesterfrancis.pojo;

/**
 * Created by sylvester on 05/08/17.
 */


public class Project {

    private String title;
    private String description;

    /**
     * No args constructor for use in serialization
     *
     */
    public Project() {}

    /**
     *
     * @param title
     * @param description
     */
    public Project(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
