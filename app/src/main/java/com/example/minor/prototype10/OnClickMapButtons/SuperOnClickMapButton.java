package com.example.minor.prototype10.OnClickMapButtons;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.minor.prototype10.AbnormalStates;
import com.example.minor.prototype10.BattleActivity;
import com.example.minor.prototype10.MakeWeaponRealmObject;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.R;

import java.io.IOException;

import io.realm.Realm;

abstract public class SuperOnClickMapButton implements View.OnClickListener{
    protected Realm realm;
    protected PlayerInfo playerInfo;
    protected static AppCompatActivity mMain;
    protected static TextView mainText, bleedingText, poisonText;
    protected static ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8;
    protected static TextView imageButton1Text, imageButton2Text, imageButton3Text, imageButton4Text, imageButton5Text, imageButton6Text, imageButton7Text, imageButton8Text;
    protected int position;
    protected AbnormalStates abnormalStates;
    protected MediaPlayer mediaPlayer;

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

        imageButton1Text = (TextView) main.findViewById(R.id.image_button1_text);
        imageButton2Text = (TextView) main.findViewById(R.id.image_button2_text);
        imageButton3Text = (TextView) main.findViewById(R.id.image_button3_text);
        imageButton4Text = (TextView) main.findViewById(R.id.image_button4_text);
        imageButton5Text = (TextView) main.findViewById(R.id.image_button5_text);
        imageButton6Text = (TextView) main.findViewById(R.id.image_button6_text);
        imageButton7Text = (TextView) main.findViewById(R.id.image_button7_text);
        imageButton8Text = (TextView) main.findViewById(R.id.image_button8_text);
    }

    protected void resetAllButtons(){
        imageButton1.setOnClickListener(null);
        imageButton2.setOnClickListener(null);
        imageButton3.setOnClickListener(null);
        imageButton4.setOnClickListener(null);
        imageButton5.setOnClickListener(null);
        imageButton6.setOnClickListener(null);
        imageButton7.setOnClickListener(null);
        imageButton8.setOnClickListener(null);

        imageButton1Text.setText("");
        imageButton2Text.setText("");
        imageButton3Text.setText("");
        imageButton4Text.setText("");
        imageButton5Text.setText("");
        imageButton6Text.setText("");
        imageButton7Text.setText("");
        imageButton8Text.setText("");

        mainText.setText("");
    }

    protected void obtainWeapon(int weaponId, int percent){
        MakeWeaponRealmObject makeWeaponRealmObject = new MakeWeaponRealmObject();
        if(Math.random()*100 < percent) {
            if (makeWeaponRealmObject.createNewWeapon(weaponId)) {
                mainText.setText("武器を取得しました");
            }
        }
    }

    protected void stopAllButtons(){
        imageButton1.setEnabled(false);
        imageButton2.setEnabled(false);
        imageButton3.setEnabled(false);
        imageButton4.setEnabled(false);
        imageButton5.setEnabled(false);
        imageButton6.setEnabled(false);
        imageButton7.setEnabled(false);
        imageButton8.setEnabled(false);
    }

    protected void startAllButtons(){
        imageButton1.setEnabled(true);
        imageButton2.setEnabled(true);
        imageButton3.setEnabled(true);
        imageButton4.setEnabled(true);
        imageButton5.setEnabled(true);
        imageButton6.setEnabled(true);
        imageButton7.setEnabled(true);
        imageButton8.setEnabled(true);
    }

    //マップのクラスでは必ずこのメソッドを呼んでください
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

    //必ずsavePositionの後に呼んでください
    protected void changeBaseEnemyLevel(int baseEnemyLevel){
        realm.beginTransaction();
        playerInfo.setBaseEnemyLevel(baseEnemyLevel);
        realm.commitTransaction();
    }

    protected void changeAdditionalEnemyLevel(int additionalEnemyLevel){
        realm.beginTransaction();
        playerInfo.setAdditionalEnemyLevel(additionalEnemyLevel);
        realm.commitTransaction();
    }

    protected void encounter(int id, double percent){
        if(Math.random() < percent/100){
            Intent intent = new Intent(mMain, BattleActivity.class);
            intent.putExtra("EnemyId", id);
            mMain.startActivity(intent);
        }
    }

    abstract public void createMap();
    abstract public void onClick(View v);

    protected boolean audioSetup(MediaPlayer mMediaPlayer){
        boolean fileCheck = false;

        // rawにファイルがある場合
        mediaPlayer = mMediaPlayer;
        // 音量調整を端末のボタンに任せる
        mMain.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        fileCheck = true;

        return fileCheck;
    }

    protected void audioPlay() {
        // 繰り返し再生する場合
        mediaPlayer.stop();
        mediaPlayer.reset();
        // リソースの解放
        mediaPlayer.release();

        // 再生する
        mediaPlayer.start();

        // 終了を検知するリスナー
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d("debug","end of audio");
                audioStop();
            }
        });
    }

    protected void audioStop() {
        // 再生終了
        mediaPlayer.stop();
        // リセット
        mediaPlayer.reset();
        // リソースの解放
        mediaPlayer.release();

        mediaPlayer = null;
    }
}

