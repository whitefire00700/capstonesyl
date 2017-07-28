package com.sylvester.android.sylvesterfrancis.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sylvester.android.sylvesterfrancis.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContactMeFragment extends Fragment {

    public ContactMeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_me, container, false);
    }
}
