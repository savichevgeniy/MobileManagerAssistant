package com.example.mobilemanagerassistant.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mobilemanagerassistant.R;
import com.example.mobilemanagerassistant.databinding.ActivityAddEditProjectBinding;
import com.example.mobilemanagerassistant.model.Project;

public class AddEditProjectActivity extends AppCompatActivity {

    private Project project;

    public static final String PROJECT_ID = "projectId";
    public static final String PROJECT_NAME = "projectName";
    public static final String PROJECT_CUSTOMER = "projectCustomer";
    public static final String PROJECT_DEADLINE = "projectDeadline";

    private AddEditProjectClickHandlers addEditProjectClickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_project);

        ActivityAddEditProjectBinding activityAddEditProjectBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_add_edit_project);

        activityAddEditProjectBinding.setProject(project);

        addEditProjectClickHandlers =
               new AddEditProjectClickHandlers(this);

        activityAddEditProjectBinding.setClickHandlers(addEditProjectClickHandlers);

        Intent intent = getIntent();

        if (intent.hasExtra(PROJECT_ID)) {
            setTitle("Edit project");

            project.setNameProject(intent.getStringExtra(PROJECT_NAME));
            project.setCustomerProject(intent.getStringExtra(PROJECT_CUSTOMER));
            project.setDeadlineProject(intent.getStringExtra(PROJECT_DEADLINE));
        } else {
            setTitle("Add new project");
        }
    }



    public class AddEditProjectClickHandlers {
        Context context;

        public AddEditProjectClickHandlers(Context context) {
            this.context = context;
        }

        public void onOkButtonClicked(View view) {

            if (project.getNameProject() == null) {

                Toast.makeText(context, "Please enter project name", Toast.LENGTH_LONG).show();

            }
            else {

                Intent intent = new Intent();
                intent.putExtra(PROJECT_NAME, project.getNameProject());
                intent.putExtra(PROJECT_CUSTOMER, project.getCustomerProject());
                intent.putExtra(PROJECT_DEADLINE, project.getDeadlineProject());
                setResult(RESULT_OK, intent);
                finish();
            }

        }

        public void onCancelButtonClicked(View view) {

            finishFromChild((Activity) context);

        }
    }
}