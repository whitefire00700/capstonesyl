package com.sylvester.android.sylvesterfrancis.data;

/**
 * Created by sylvester on 07/08/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Certificate {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("authority")
    @Expose
    private String authority;
    @SerializedName("url")
    @Expose
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}



