package com.sylvester.android.sylvesterfrancis.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sylvester on 05/08/17.
 */

public class Certificate implements Parcelable {

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


    protected Certificate(Parcel in) {
        title = in.readString();
        authority = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(authority);
        dest.writeString(url);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Certificate> CREATOR = new Parcelable.Creator<Certificate>() {
        @Override
        public Certificate createFromParcel(Parcel in) {
            return new Certificate(in);
        }

        @Override
        public Certificate[] newArray(int size) {
            return new Certificate[size];
        }
    };
}