package com.example.mobilemanagerassistant.view;

import android.content.Intent;
import android.os.Bundle;

import com.example.mobilemanagerassistant.adapter.ProjectAdapter;
import com.example.mobilemanagerassistant.databinding.ActivityProjectBinding;
import com.example.mobilemanagerassistant.model.Project;
import com.example.mobilemanagerassistant.viewmodel.ProjectViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.mobilemanagerassistant.R;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity {

    public static final int ADD_MOVIE_REQUEST_CODE = 111;
    public static final int EDIT_MOVIE_REQUEST_CODE = 222;

    private ProjectViewModel projectViewModel;
    private ActivityProjectBinding activityProjectBinding;
    private ProjectActivityClickHandlers projectActivityClickHandlers;
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter = new ProjectAdapter();
    private ArrayList<Project> projectArrayList;
    private int selectedProjectId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityProjectBinding = DataBindingUtil.setContentView(this, R.layout.activity_project);

        projectViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication())
                .create(ProjectViewModel.class);

        projectActivityClickHandlers = new ProjectActivityClickHandlers();
        activityProjectBinding.setClickHandlers(projectActivityClickHandlers);

        loadProjectRecyclerView();
    }

    private void loadProjectRecyclerView() {

        recyclerView = activityProjectBinding.layoutContentProject.projectRecyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        projectAdapter.setProjectArrayList(projectArrayList);
        recyclerView.setAdapter(projectAdapter);

        projectAdapter.setOnItemClickListener(new ProjectAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Project project) {
                selectedProjectId = project.getId();
                Intent intent =
                        new Intent(ProjectActivity.this, AddEditProjectActivity.class);
                intent.putExtra(AddEditProjectActivity.PROJECT_ID, selectedProjectId);
                intent.putExtra(AddEditProjectActivity.PROJECT_NAME, project.getNameProject());
                intent.putExtra(AddEditProjectActivity.PROJECT_CUSTOMER, project.getCustomerProject());
                intent.putExtra(AddEditProjectActivity.PROJECT_DEADLINE, project.getDeadlineProject());
                startActivityForResult(intent, EDIT_MOVIE_REQUEST_CODE);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Project swipeToDeleteProject = projectArrayList.get(viewHolder.getAdapterPosition());
                projectViewModel.deleteProject(swipeToDeleteProject);
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Project project =  new Project();

        selectedProjectId = project.getId();

        if (requestCode == ADD_MOVIE_REQUEST_CODE && resultCode == RESULT_OK){
            project.setId(selectedProjectId);
            assert data != null;
            project.setNameProject(data.getStringExtra(AddEditProjectActivity.PROJECT_NAME));
            project.setCustomerProject(data.getStringExtra(AddEditProjectActivity.PROJECT_CUSTOMER));
            project.setDeadlineProject(data.getStringExtra(AddEditProjectActivity.PROJECT_DEADLINE));

            projectViewModel.addNewProject(project);
        } else if (requestCode == EDIT_MOVIE_REQUEST_CODE && resultCode == RESULT_OK){
            project.setId(selectedProjectId);
            assert data != null;
            project.setNameProject(data.getStringExtra(AddEditProjectActivity.PROJECT_NAME));
            project.setCustomerProject(data.getStringExtra(AddEditProjectActivity.PROJECT_CUSTOMER));
            project.setDeadlineProject(data.getStringExtra(AddEditProjectActivity.PROJECT_DEADLINE));

            projectViewModel.updateProject(project);
        }

    }

    public class ProjectActivityClickHandlers {

        public void onFabClicked(View view) {
            Intent intent = new Intent(ProjectActivity.this,
                    AddEditProjectActivity.class);
            startActivityForResult(intent, ADD_MOVIE_REQUEST_CODE);
        }
    }
}