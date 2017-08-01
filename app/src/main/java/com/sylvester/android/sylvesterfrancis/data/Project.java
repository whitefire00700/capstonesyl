package com.sylvester.android.sylvesterfrancis.data;

/**
 * Created by sylvester on 01/08/17.
 */

public class Project {
    private String project_title,project_description;

    public Project() {}



    public Project(String title, String description) {
        this.project_title = title;
        this.project_description = description;
    }


    public String gettitle() {
        return project_title;
    }


    public void settitle(String title) {
        this.project_title = title;
    }

    public String getdescription() {
        return project_description;
    }

    public void setdescription(String description) {
        this.project_description = description;
    }
}
