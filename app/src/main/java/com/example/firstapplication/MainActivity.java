package com.example.firstapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import com.example.firstapplication.database.UserDatabase;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    public static UserDatabase userDatabase;
//    private EditText editTextName;
//    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "userdb").allowMainThreadQueries().build();

        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            // Home fragment
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_history:
                            // History fragment
                            openFragment(HistoryFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /*public void saveOnClick(View view) {

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);

        User user = new User(3, editTextName.getText().toString(), editTextEmail.getText().toString());

        MainActivity.userDatabase.userDao().addUser(user);

        Toast.makeText(getApplicationContext(), "User successfully saved", Toast.LENGTH_SHORT).show();

        editTextName.setText("");
        editTextEmail.setText("");
    }*/
}
