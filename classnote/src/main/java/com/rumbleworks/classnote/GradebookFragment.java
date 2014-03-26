package com.rumbleworks.classnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GradebookFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "section_number";

    public GradebookFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gradebook, container, false);
        //TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
        //dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

        Intent intent = new Intent();
        intent.setClass(getActivity(), OverlayActivity.class);
        startActivity(intent);
        //finish();

        return rootView;
    }
}