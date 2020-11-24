package com.example.mobilemanagerassistant.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mobilemanagerassistant.model.Project;
import com.example.mobilemanagerassistant.repository.RoomRepository;

import java.util.List;

public class ProjectViewModel extends AndroidViewModel {
    
    private RoomRepository roomRepository;
    private LiveData<List<Project>> project;
    
    public ProjectViewModel(@NonNull Application application) {
        super(application);
        roomRepository = new RoomRepository(application);
    }

    public LiveData<List<Project>> getProject() {
        project = roomRepository.getProjects();
        return project;
    }

    public void addNewProject(Project project) {
        roomRepository.insertProject(project);
    }

    public void updateProject(Project project) {
        roomRepository.updateProject(project);
    }
    public void deleteProject(Project project) {
        roomRepository.deleteProject(project);
    }
}
