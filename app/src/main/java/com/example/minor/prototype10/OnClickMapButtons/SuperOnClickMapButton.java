package com.example.minor.prototype10.OnClickMapButtons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.minor.prototype10.AbnormalStates;
import com.example.minor.prototype10.BattleActivity;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.R;

import io.realm.Realm;

abstract public class SuperOnClickMapButton implements View.OnClickListener{
    protected Realm realm;
    protected PlayerInfo playerInfo;
    protected static AppCompatActivity mMain;
    protected static TextView mainText, bleedingText, poisonText;
    protected static ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8;
    protected int position;
    protected AbnormalStates abnormalStates;

    public void setDefaultInstances(AppCompatActivity main) {
        mMain = main;
        mainText = (TextView) main.findViewById(R.id.main_text);
        imageButton1 = (ImageButton) main.findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) main.findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) main.findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) main.findViewById(R.id.imageButton4);
        imageButton5 = (ImageButton) main.findViewById(R.id.imageButton5);
        imageButton6 = (ImageButton) main.findViewById(R.id.imageButton6);
        imageButton7 = (ImageButton) main.findViewById(R.id.imageButton7);
        imageButton8 = (ImageButton) main.findViewById(R.id.imageButton8);
    }

    protected void savePosition(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        abnormalStates = new AbnormalStates();
        abnormalStates.abnormalEffect(realm, playerInfo);
        realm.beginTransaction();
        playerInfo.setPosition(position);
        realm.commitTransaction();
        realm.close();
    }

    public void encounter(int id, double percent){
        if(Math.random() < percent/100){
            Intent intent = new Intent(mMain, BattleActivity.class);
            intent.putExtra("EnemyId", id);
            mMain.startActivity(intent);
        }
    }

    abstract public void createMap();
    abstract public void onClick(View v);
}
