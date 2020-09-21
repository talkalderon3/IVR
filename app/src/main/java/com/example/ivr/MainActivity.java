package com.example.ivr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String init [] = {"start","acticity","next"};
        Bundle bundle = new Bundle();
        bundle.putStringArray("StringKey",init);
        addFragment(bundle);
    }



    private  void addFragment(Bundle bundle) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MenuFragment menuFragment = new MenuFragment();
        menuFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainer,menuFragment);
        fragmentTransaction.addToBackStack("tal");
        fragmentTransaction.commit();
    }

    @Override
    public void onActionPerformed(Bundle bundle) {
        Toast.makeText(this,"onActionPerformed",Toast.LENGTH_LONG).show();
        addFragment(bundle);
    }
}