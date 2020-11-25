package com.example.mobilemanagerassistant.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mobilemanagerassistant.model.Task;
import com.example.mobilemanagerassistant.repository.RoomRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private LiveData<List<Task>> taskListLiveData;
    private RoomRepository roomRepository;


    public TaskViewModel(@NonNull Application application) {
        super(application);
        roomRepository = new RoomRepository(application);
    }

    public LiveData<List<Task>> getListLiveDataTask(){
        taskListLiveData = roomRepository.getTasks();
        return  taskListLiveData;
    }

    public void addNewTask(Task task) {
        roomRepository.insertTask(task);
    }

    public void updateTask(Task task) {
        roomRepository.updateTask(task);
    }

    public void deleteTask(Task task) {
        roomRepository.deleteTask(task);
    }


}
