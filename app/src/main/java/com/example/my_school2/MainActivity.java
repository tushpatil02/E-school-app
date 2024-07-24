package com.example.my_school2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            loadFragment(new fragment_dashboard());
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        Fragment selectedFragment = null;

        if (itemId == R.id.nav_dashboard) {
            selectedFragment = new fragment_dashboard();
            showToast(getString(R.string.nav_dashboard) + " clicked");
        } else if (itemId == R.id.nav_attendance) {
            showToast(getString(R.string.nav_attendance) + " clicked");
        } else if (itemId == R.id.nav_class_test) {
            showToast(getString(R.string.nav_class_test) + " clicked");
        } else if (itemId == R.id.nav_assignment) {
            showToast(getString(R.string.nav_assignment) + " clicked");
        } else if (itemId == R.id.nav_communication) {
            showToast(getString(R.string.nav_communication) + " clicked");
        } else if (itemId == R.id.nav_exams) {
            showToast(getString(R.string.nav_exams) + " clicked");
        } else if (itemId == R.id.nav_time_table) {
            showToast(getString(R.string.nav_time_table) + " clicked");
        } else if (itemId == R.id.nav_live_classes) {
            showToast(getString(R.string.nav_live_classes) + " clicked");
        } else if (itemId == R.id.nav_notification) {
            showToast(getString(R.string.nav_notification) + " clicked");
        } else if (itemId == R.id.nav_sign_out) {
            showToast(getString(R.string.nav_sign_out) + " clicked");
        } else {
            throw new IllegalStateException("Unexpected value: " + itemId);
        }

        if (selectedFragment != null) {
            loadFragment(selectedFragment);
        }

        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
