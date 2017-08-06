package com.sylvester.android.sylvesterfrancis.retrofit;

import com.sylvester.android.sylvesterfrancis.pojo.Certificate;
import com.sylvester.android.sylvesterfrancis.pojo.Project;

/**
 * Created by sylvester on 06/08/17.
 */

public class JSONResponse {
    private Project[] project;
    private Certificate[] certificate;

    public Project[] getProject() {
        return project;
    }
    public Certificate[] getCertificate() { return certificate; }
}
