package com.sylvester.android.sylvesterfrancis.data;

/**
 * Created by sylvester on 01/08/17.
 */

public class Certificate {
    private String certificate_title, certificate_authority;
    private int certificate_id;

    public Certificate() {}


    public Certificate(String title, String authority,int image_id) {
        this.certificate_title = title;
        this.certificate_authority = authority;
        this.certificate_id = image_id;
    }


    public String gettitle() {
        return certificate_title;
    }


    public void settitle(String title) {
        this.certificate_title = title;
    }

    public String getauthority() {
        return certificate_authority;
    }

    public void setdescription(String authority) {
        this.certificate_authority = authority;
    }

    public int getCertificate_id() {
        return certificate_id;
    }

    public void setCertificate_id(int certificate_id) {
        this.certificate_id = certificate_id;
    }
}
