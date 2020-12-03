package com.example.mobilemanagerassistant.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mobilemanagerassistant.data.ProjectDao;
import com.example.mobilemanagerassistant.data.ProjectsDb;
import com.example.mobilemanagerassistant.data.TaskDao;
import com.example.mobilemanagerassistant.model.Project;
import com.example.mobilemanagerassistant.model.Task;

import java.util.List;

public class RoomRepository {

    private ProjectDao projectDao;
    private TaskDao taskDao;

    private LiveData<List<Project>> projects;
    private LiveData<List<Task>> tasks;

    public RoomRepository(Application application) {

        ProjectsDb database = ProjectsDb.getProjectsDb(application);
        projectDao = database.getProjectDao();
        taskDao = database.getTaskDao();

    }

    //get and CRUD projects
    public LiveData<List<Project>> getProjects() {
        return projectDao.getAllProjects();
    }

    public void insertProject(Project project) {
        new InsertProjectAsyncTask(projectDao).execute(project);
    }

    private static class InsertProjectAsyncTask extends AsyncTask<Project, Void, Void>{

        private ProjectDao projectDao;

        public InsertProjectAsyncTask(ProjectDao projectDao) {
            this.projectDao = projectDao;
        }

        @Override
        protected Void doInBackground(Project... projects) {
            projectDao.insertProject(projects[0]);
            return null;
        }
    }

    public void updateProject(Project project) {
        new UpdateProjectAsyncTask(projectDao).execute(project);
    }

    private static class UpdateProjectAsyncTask extends AsyncTask<Project, Void, Void> {

        private ProjectDao projectDao;

        public UpdateProjectAsyncTask(ProjectDao projectDao) {
            this.projectDao = projectDao;
        }

        @Override
        protected Void doInBackground(Project... projects) {
            projectDao.updateProject(projects[0]);
            return null;
        }
    }

    public void deleteProject(Project project) {
        new DeleteProjectAsyncTask(projectDao).execute(project);
    }

    private static class DeleteProjectAsyncTask extends AsyncTask<Project, Void, Void> {

        private ProjectDao projectDao;

        public DeleteProjectAsyncTask(ProjectDao projectDao) {
            this.projectDao = projectDao;
        }

        @Override
        protected Void doInBackground(Project... projects) {
            projectDao.deleteProject(projects[0]);
            return null;
        }
    }

    //get and CRUD tasks
    public LiveData<List<Task>> getTaskProject(int idProject){
        return taskDao.getProjectTask(idProject);
    }

    public LiveData<List<Task>> getTasks(){
        return taskDao.getAllTasks();
    }

    public void insertTask(Task task) {
        new InsertTaskAsyncTask(taskDao).execute(task);
    }

    private static class InsertTaskAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDao taskDao;

        public InsertTaskAsyncTask(TaskDao taskDao) {
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... task) {
            taskDao.insertTask(task[0]);
            return null;
        }
    }

    public void updateTask(Task task) {
        new UpdateTaskAsyncTask(taskDao).execute(task);
    }

    private static class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDao taskDao;

        public UpdateTaskAsyncTask(TaskDao taskDao) {
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... task) {
            taskDao.updateTask(task[0]);
            return null;
        }
    }

    public void deleteTask(Task task) {
        new DeleteTaskAsyncTask(taskDao).execute(task);
    }

    private static class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void> {

        private TaskDao taskDao;

        public DeleteTaskAsyncTask(TaskDao taskDao) {
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... task) {
            taskDao.deleteTask(task[0]);
            return null;
        }
    }
}
