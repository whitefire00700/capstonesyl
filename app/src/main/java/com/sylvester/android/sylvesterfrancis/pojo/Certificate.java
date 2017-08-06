package com.sylvester.android.sylvesterfrancis.pojo;

/**
 * Created by sylvester on 05/08/17.
 */


public class Certificate {

    private String title;
    private String authority;
    private String url;

    /**
     * No args constructor for use in serialization
     *
     */
    public Certificate() {}

    /**
     *
     * @param authority
     * @param title
     * @param url
     */
    public Certificate(String title, String authority, String url) {
        super();
        this.title = title;
        this.authority = authority;
        this.url = url;
    }

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