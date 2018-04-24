package com.example.minor.prototype10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBossRoomButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickDungeonButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickInnButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickTownButton;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmResults;

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
    private RealmResults<WeaponId> weaponIds;
    private RealmResults<PlayerInfo> playerInfos;
    private ImageButton imageButton;
    private int position;
    private SuperOnClickMapButton onClickMapButton;
    private ProgressBar mainHpBar, mainMpBar;
    private MakeWeaponRealmObject makeWeaponRealmObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (ImageButton) findViewById(R.id.status_button);
        mainHpBar = (ProgressBar) findViewById(R.id.main_hp_bar);
        mainMpBar = (ProgressBar) findViewById(R.id.main_mp_bar);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStatus(v);
            }
        });
        realm = Realm.getDefaultInstance();
        //createSaveDataで初期ステータスを取得するために使います
        makeData = new MakeData();
        makeWeaponRealmObject = new MakeWeaponRealmObject();
        createSaveData();
        gameStart();
    }

    private void onClickStatus(View view){
        startActivity(new Intent(this, StatusActivity.class));
    }

    private void gameStart() {
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        playerInfos = realm.where(PlayerInfo.class).findAll();
        playerInfos.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<PlayerInfo>>() {
            @Override
            public void onChange(RealmResults<PlayerInfo> playerInfos, OrderedCollectionChangeSet changeSet) {
                mainHpBar.setMax(playerInfo.getFmaxHP());
                mainHpBar.setProgress(playerInfo.getHP());
                mainMpBar.setMax(playerInfo.getFmaxMP());
                mainMpBar.setProgress(playerInfo.getMP());
            }
        });
        weaponIds = realm.where(WeaponId.class).findAll();
        position = playerInfo.getPosition();
        onClickMapButton = makeData.makeMapFromPosition(position);
        onClickMapButton.setDefaultInstances(this);
        onClickMapButton.createMap();
    }

    //実際はmakePlayerStatusFromLevelメソッドにLevel0を代入して初期化します
    private void createSaveData(){
        try {
            realm.beginTransaction();
            playerInfo = realm.createObject(PlayerInfo.class, new String("player"));
            playerInfo.setPlayerLevel(50);
            playerInfo.setPosition(1);
            playerInfo.setMoney(100);
            playerInfo.setFmaxHP(1000);
            playerInfo.setHP(100);
            playerInfo.setFmaxMP(100);
            playerInfo.setMP(100);
            playerInfo.setSP(10);
            playerInfo.setfSP(10);
            playerInfo.setATK(10);
            playerInfo.setmATK(120);
            playerInfo.setDF(100);
            playerInfo.setfDF(100);
            playerInfo.setLUK(100);
            playerInfo.setfLUK(100);
            playerInfo.setWeaponId(0);
            //階層を移動したときはsetEnemyLevel,街の中で敵を倒したときはsetAdditionalEnemyLevelを実行してください、後々時間経過で敵のレベルが戻っていく処理も追加します
            playerInfo.setBaseEnemyLevel(50);
            playerInfo.setAdditionalEnemyLevel(0);
            realm.commitTransaction();
            //atkとdfとhpのステータスを自動生成してだい素のステータスに代入してくれるメソッドです
            makeData.makePlayerStatusFromLevel(playerInfo.getPlayerLevel());
            //防具の処理を後々見直します
            realm.beginTransaction();
            //防具のステータスは考慮していません、後で考える
            playerInfo.setHP(playerInfo.getMaxHP());
            playerInfo.setFmaxHP(playerInfo.getMaxHP());
            playerInfo.setmATK(playerInfo.getATK());
            playerInfo.setfDF(playerInfo.getDF());
            realm.commitTransaction();
            //防具もこれと同様にしてください
            makeWeaponRealmObject.createNewWeapon(0);
        }catch (Exception e){
            realm.cancelTransaction();
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        realm.close();
    }
}
