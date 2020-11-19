package com.example.mobilemanagerassistant.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Project.class, Task.class}, version = 1)
public  abstract class ProjectsDb extends RoomDatabase {

    private static ProjectsDb projectsDb;

    public abstract ProjectDao getProjectDao();
    public abstract TaskDao getTaskDao();

    public static synchronized ProjectsDb getProjectsDb(Context context) {

        if (projectsDb == null) {

            projectsDb = Room.databaseBuilder(context.getApplicationContext(),
                    ProjectsDb.class, "projectDB")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }

        return projectsDb;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);

            new InitialDataAsyncTask(projectsDb).execute();
        }

    };

    public static class InitialDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private ProjectDao projectDao;
        private TaskDao taskDao;

        public InitialDataAsyncTask(ProjectsDb database) {
            projectDao = database.getProjectDao();
            taskDao = database.getTaskDao();
        }



        @Override
        protected Void doInBackground(Void... voids) {
            projectDao.getAllProjects();
            taskDao.getAllTasks();
            return null;
        }
    }

}
