package com.example.minor.prototype10.OnClickMapButtons;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minor.prototype10.AbnormalStates;
import com.example.minor.prototype10.BattleActivity;
import com.example.minor.prototype10.Items.SuperItem;
import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.MakeArmorRealmObject;
import com.example.minor.prototype10.MakeData;
import com.example.minor.prototype10.MakeWeaponRealmObject;
import com.example.minor.prototype10.Models.AmuletName;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.R;

import io.realm.Realm;

import static android.content.Context.MODE_PRIVATE;

abstract public class SuperOnClickMapButton implements View.OnClickListener{
    protected Realm realm;
    protected PlayerInfo playerInfo;
    public static SharedPreferences sharedPreferences;
    protected static AppCompatActivity mMain;
    protected static TextView mainText;
    protected static ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8;
    protected static TextView imageButton1Text, imageButton2Text, imageButton3Text, imageButton4Text, imageButton5Text, imageButton6Text, imageButton7Text, imageButton8Text;
    protected int position;
    protected AbnormalStates abnormalStates;
    protected MediaPlayer mediaPlayer;

    public void setDefaultInstances(AppCompatActivity main) {
        mMain = main;
        sharedPreferences = mMain.getSharedPreferences("MapInfo", MODE_PRIVATE);
        mainText = main.findViewById(R.id.main_text);
        imageButton1 = main.findViewById(R.id.imageButton1);
        imageButton2 = main.findViewById(R.id.imageButton2);
        imageButton3 = main.findViewById(R.id.imageButton3);
        imageButton4 = main.findViewById(R.id.imageButton4);
        imageButton5 = main.findViewById(R.id.imageButton5);
        imageButton6 = main.findViewById(R.id.imageButton6);
        imageButton7 = main.findViewById(R.id.imageButton7);
        imageButton8 = main.findViewById(R.id.imageButton8);

        imageButton1Text = main.findViewById(R.id.image_button1_text);
        imageButton2Text = main.findViewById(R.id.image_button2_text);
        imageButton3Text = main.findViewById(R.id.image_button3_text);
        imageButton4Text = main.findViewById(R.id.image_button4_text);
        imageButton5Text = main.findViewById(R.id.image_button5_text);
        imageButton6Text = main.findViewById(R.id.image_button6_text);
        imageButton7Text = main.findViewById(R.id.image_button7_text);
        imageButton8Text = main.findViewById(R.id.image_button8_text);

        makeBgm();
        MainActivity.mediaPlayer.setLooping(true);
        mMain.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        MainActivity.mediaPlayer.start();
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

    protected void obtainWeapon(String weaponName, int percent){
        MakeWeaponRealmObject makeWeaponRealmObject = new MakeWeaponRealmObject();
        if(Math.random()*100 < percent) {
            if (makeWeaponRealmObject.createNewWeapon(weaponName)) {
                Toast toast = Toast.makeText(MainActivity.context, "武器を取得した！", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    protected void obtainArmor(String armorName, int percent){
        MakeArmorRealmObject makeArmorRealmObject = new MakeArmorRealmObject();
        if(Math.random()*100 < percent){
            if(makeArmorRealmObject.createNewArmor(armorName)){
                //取得した防具の名前を表示した方がいいかもしれない。
                Toast toast = Toast.makeText(MainActivity.context, "防具を取得した！", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    //ここに装飾品のスキルを実行する処理を書く。
    protected void obtainAmulet(String amuletName, int percent){
        if(Math.random()*100 < percent) {
            realm.beginTransaction();
            AmuletName amuletNameInstance = realm.createObject(AmuletName.class);
            amuletNameInstance.setAmuletName(amuletName);
            realm.commitTransaction();
            MakeData makeData = new MakeData();
            SuperItem superItem = makeData.makeItemFromName(amuletName);
            superItem.putOnAmulet();
            Toast toast = Toast.makeText(MainActivity.context, "装飾品を取得した！", Toast.LENGTH_SHORT);
            toast.show();
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
        imageButton1Text.setText("");
        imageButton2Text.setText("");
        imageButton3Text.setText("");
        imageButton4Text.setText("");
        imageButton5Text.setText("");
        imageButton6Text.setText("");
        imageButton7Text.setText("");
        imageButton8Text.setText("");
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

    protected void audioSetup(){
        MainActivity.mediaPlayer.setLooping(true);
        mMain.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    protected void audioPlay(MediaPlayer mediaPlayer, int bgmId) {
        if(playerInfo.getNowPlayingBgm() != bgmId) {
            realm.beginTransaction();
            playerInfo.setNowPlayingBgm(bgmId);
            realm.commitTransaction();
            audioStop();
            MainActivity.mediaPlayer = mediaPlayer;
            audioSetup();
            MainActivity.mediaPlayer.start();
        }else {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    protected void audioStop() {
        MainActivity.mediaPlayer.stop();
        MainActivity.mediaPlayer.reset();
        MainActivity.mediaPlayer.release();
        MainActivity.mediaPlayer = null;
    }

    //BGMを追加したときはここにswitch文を追加する。場所が場所なので忘れやすい、、、
    protected void makeBgm(){
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        int bgmId = playerInfo.getNowPlayingBgm();
        switch (bgmId){
            case 0:
                MainActivity.mediaPlayer = MediaPlayer.create(mMain, R.raw.old_mansion_bgm);
                break;
            case 1:
                MainActivity.mediaPlayer = MediaPlayer.create(mMain, R.raw.sample_bgm);
                break;
            case 2:
                MainActivity.mediaPlayer = MediaPlayer.create(mMain, R.raw.night_sound);
                break;
            case 3:
                MainActivity.mediaPlayer = MediaPlayer.create(mMain, R.raw.old_mansion_event_sound);
                break;
            case 4:
                MainActivity.mediaPlayer = MediaPlayer.create(mMain, R.raw.noise);
                break;
            case 5:
                MainActivity.mediaPlayer = MediaPlayer.create(mMain, R.raw.basement_sound);
                break;

        }
    }
}