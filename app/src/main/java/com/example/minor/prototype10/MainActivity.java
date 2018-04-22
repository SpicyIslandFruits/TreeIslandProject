package com.example.minor.prototype10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBossRoomButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickDungeonButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickInnButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickTownButton;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

import io.realm.Realm;

/**
 * 武器、防具、アイテム、主人公スキル、マップの追加方法
 * 1.それぞれのパッケージにクラスを追加、メソッドの実装、ゲッターを見て適当なメンバの追加
 * 2.MakeDataクラスのswitch文にcaseを追加
 * 3.idをRealmList<Weapon>にcreateObjectするイベントの作成
 * 4.マップの場合はcreateMapメソッドの中ににどのマップとつながっているかを書く
 */

public class MainActivity extends AppCompatActivity{
    private Realm realm;
    private MakeData makeData;
    private PlayerInfo playerInfo;
    private ImageButton imageButton;
    private int position;
    private SuperOnClickMapButton onClickMapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (ImageButton) findViewById(R.id.status_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStatus(v);
            }
        });
        realm = Realm.getDefaultInstance();
        //createSaveDataで初期ステータスを取得するために使います
        makeData = new MakeData();
        createSaveData();
        gameStart();
    }

    private void onClickStatus(View view){
        startActivity(new Intent(this, StatusActivity.class));
    }

    private void gameStart() {
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                playerInfo = realm.where(PlayerInfo.class).findFirst();
                position = playerInfo.getPosition();
            }
        });
        onClickMapButton = makeData.makeMapFromPosition(position);
        onClickMapButton.setDefaultInstances(this);
        onClickMapButton.createMap();
    }

    //実際はmakePlayerStatusFromLevelメソッドにLevel0を代入して初期化します
    private void createSaveData(){
        try {
            realm.beginTransaction();
            playerInfo = realm.createObject(PlayerInfo.class, new String("player"));
            playerInfo.setPlayerLevel(0);
            playerInfo.setPosition(1);
            playerInfo.setMoney(100);
            playerInfo.setFmaxHP(300);
            playerInfo.setHP(300);
            playerInfo.setFmaxMP(100);
            playerInfo.setMP(100);
            playerInfo.setSP(10);
            playerInfo.setfSP(10);
            playerInfo.setATK(10);
            playerInfo.setmATK(12);
            playerInfo.setDF(100);
            playerInfo.setfDF(100);
            playerInfo.setLUK(100);
            playerInfo.setfLUK(100);
            playerInfo.setWeaponId(0);
            WeaponId weaponId = realm.createObject(WeaponId.class, new String("sampleWeapon"));
            weaponId.setWeaponId(0);
            playerInfo.getWeaponIds().add(weaponId);
            weaponId = realm.createObject(WeaponId.class, new String("SampleWeapon2"));
            weaponId.setWeaponId(1);
            playerInfo.getWeaponIds().add(weaponId);
            realm.commitTransaction();
        }catch (Exception e){
            realm.cancelTransaction();
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        realm.close();
    }
}
