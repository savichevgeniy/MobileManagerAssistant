package com.example.mobilemanagerassistant.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobilemanagerassistant.R;
import com.example.mobilemanagerassistant.databinding.ProjectListItemBinding;
import com.example.mobilemanagerassistant.model.Project;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<Project> projectArrayList = new ArrayList<>();

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProjectListItemBinding projectListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()), R.layout.project_list_item, parent, false);
        return new ProjectViewHolder(projectListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project project = projectArrayList.get(position);
        holder.projectListItemBinding.setProject(project);
    }

    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {
        ProjectListItemBinding projectListItemBinding;

        public ProjectViewHolder(@NonNull ProjectListItemBinding projectListItemBinding) {
            super(projectListItemBinding.getRoot());
            this.projectListItemBinding = projectListItemBinding;
            projectListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (onItemClickListener != null && position != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(projectArrayList.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
         void onItemClick(Project project);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener =  onItemClickListener;
    }

    public void setProjectArrayList(ArrayList<Project> projectArrayList) {
        this.projectArrayList = projectArrayList;
        notifyDataSetChanged();
    }


}
