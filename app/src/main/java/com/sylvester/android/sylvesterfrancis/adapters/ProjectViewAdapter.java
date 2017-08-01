package com.sylvester.android.sylvesterfrancis.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sylvester.android.sylvesterfrancis.R;
import com.sylvester.android.sylvesterfrancis.data.Project;

import java.util.List;

/**
 * Created by sylvester on 30/07/17.
 */

public class ProjectViewAdapter extends RecyclerView.Adapter<ProjectViewAdapter.ProjectViewHolder> {

    private List<Project> projectList;

    static final int TYPE_HEADER = 0;

    public class ProjectViewHolder extends RecyclerView.ViewHolder {
        public TextView title, description;

        public ProjectViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.project_title);
            description = view.findViewById(R.id.project_description);
        }
    }



    public ProjectViewAdapter(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_HEADER;
        }
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.projects_layout, parent, false);
               return new ProjectViewHolder(view) {
                };
            }
        }
        return null;

    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.title.setText(project.gettitle());
        holder.description.setText(project.getdescription());
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }
}