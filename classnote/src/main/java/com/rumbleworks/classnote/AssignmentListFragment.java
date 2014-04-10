package com.rumbleworks.classnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Observable;
import java.util.Observer;

public class AssignmentListFragment extends ListFragment implements Observer {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "section_number";

    public AssignmentListFragment() {

    }


    public void onResume() {
        super.onResume();
        AssignmentAdapter assignmentAdapter = (AssignmentAdapter)this.getListAdapter();
        assignmentAdapter.setList(Datamart.getInstance().getUpcomingAssignments());
        assignmentAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_assignment_list, container, false);

        this.setListAdapter(new AssignmentAdapter(Datamart.getInstance().getUpcomingAssignments(), this.getActivity()));

        return rootView;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Datamart.getInstance().addObserver(this);
    }

    public void onDestroy() {
        super.onDestroy();
        Datamart.getInstance().deleteObserver(this);
    }

    public void update(Observable observable, Object data) {
        this.setListAdapter(new AssignmentAdapter(Datamart.getInstance().getUpcomingAssignments(), this.getActivity()));
    }


    public void onListItemClick(ListView l, View v, int position, long id) {
        AssignmentAdapter adapter = (AssignmentAdapter)getListAdapter();
        Assignment a = (Assignment)adapter.getItem(position);
        Intent i = new Intent(this.getActivity(), AssignmentDetails.class);
        i.putExtra("COURSE_ID", a.getId());
        i.putExtra("DESCRIPTION", a.getDescription());
        i.putExtra("DUE_DATE", a.getDueDate());
        startActivity(i);
    }

}