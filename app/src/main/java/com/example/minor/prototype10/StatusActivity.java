package com.example.minor.prototype10;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.minor.prototype10.StatusActivityFragments.EquipmentFragment;
import com.example.minor.prototype10.StatusActivityFragments.ItemFragment;
import com.example.minor.prototype10.StatusActivityFragments.SkillFragment;
import com.example.minor.prototype10.StatusActivityFragments.StatusFragment;

/**
 * ほとんどの処理はフラグメントで行うのでここを編集する必要はないです
 */
public class StatusActivity extends AppCompatActivity {
    private ImageButton statusButton;
    private ImageButton equipmentButton;
    private ImageButton skillButton;
    private ImageButton itemButton;
    private ImageButton backButton;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        statusButton = (ImageButton) findViewById(R.id.status_button);
        equipmentButton = (ImageButton) findViewById(R.id.equipment_button);
        skillButton = (ImageButton) findViewById(R.id.skill_button);
        itemButton = (ImageButton) findViewById(R.id.item_button);
        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(view);
            }
        });
        equipmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(view);
            }
        });
        skillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(view);
            }
        });
        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(view);
            }
        });
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new StatusFragment();
        fragmentTransaction.replace(R.id.player_info_fragment, fragment);
        fragmentTransaction.commit();
    }

    private void ChangeFragment(View view){
        if (view == statusButton){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new StatusFragment();
            fragmentTransaction.replace(R.id.player_info_fragment, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }

        if (view == equipmentButton){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new EquipmentFragment();
            fragmentTransaction.replace(R.id.player_info_fragment, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }

        if(view == skillButton){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new SkillFragment();
            fragmentTransaction.replace(R.id.player_info_fragment, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }

        if(view == itemButton){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragment = new ItemFragment();
            fragmentTransaction.replace(R.id.player_info_fragment, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }
    }
}
