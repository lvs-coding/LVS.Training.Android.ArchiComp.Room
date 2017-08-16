package com.example.roomtraining.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.roomtraining.dao.UserDao;
import com.example.roomtraining.database.AppDatabase;
import com.example.roomtraining.R;
import com.example.roomtraining.entity.User;
import com.example.roomtraining.utils.DatabaseInitializer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_populate)
    public void Populate() {
        DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this));

        AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
        List<User> users = appDatabase.userDao().getAll();

        for (User u:users) {
            Log.i(TAG,u.getFirstName());
        }
    }
}
