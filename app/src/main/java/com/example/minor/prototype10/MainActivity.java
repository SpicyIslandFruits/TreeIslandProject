package com.example.minor.prototype10;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.minor.prototype10.Models.AmuletName;
import com.example.minor.prototype10.Models.ImportantItemName;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.RecoveryItemName;
import com.example.minor.prototype10.Models.WeaponName;
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
    private RealmResults<WeaponName> weaponNames;
    private RealmResults<PlayerInfo> playerInfos;
    private ImageButton imageButton;
    private int position;
    private SuperOnClickMapButton onClickMapButton;
    private ProgressBar mainHpBar, mainMpBar;
    private MakeWeaponRealmObject makeWeaponRealmObject;
    private MakeArmorRealmObject makeArmorRealmObject;
    private TextView bleedingText, poisonText;
    public static SoundPool soundPool;
    public static int walkingSound, oldMansionWalkingSound, cureSound, battleStartSound, oldMansionShowerSound, oldMansionSleepSound, oldMansionBedSound;
    public static  int oldMansionOshiireSound, oldMansionNightSkySound, waterDropSound, moneyDropSound, oldWoodenDoorSound, burstSound, woodBrokenSound;
    public static MediaPlayer mediaPlayer;
    private ImportantItemName importantItemName;
    private RecoveryItemName recoveryItemName;
    private AmuletName amuletName;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        bleedingText = findViewById(R.id.bleeding_state);
        poisonText = findViewById(R.id.poison_state);
        imageButton = findViewById(R.id.status_button);
        mainHpBar = findViewById(R.id.main_hp_bar);
        mainMpBar = findViewById(R.id.main_mp_bar);
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
        makeArmorRealmObject = new MakeArmorRealmObject();
        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_SPEECH).build();
        soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(1).build();
        //soundPoolのロードは非同期処理なのでここで行う、ロードに時間がかかる為ロードしてすぐに再生してはいけない
        walkingSound = soundPool.load(this, R.raw.walking_sound, 1);
        cureSound = soundPool.load(this, R.raw.inn3, 1);
        battleStartSound = soundPool.load(this, R.raw.sample_battle_start, 1);
        oldMansionShowerSound = soundPool.load(this, R.raw.old_mansion_shower_sound, 1);
        oldMansionWalkingSound = soundPool.load(this, R.raw.old_mansion_walking_sound, 1);
        oldMansionSleepSound = soundPool.load(this, R.raw.old_mansion_sleep_sound, 1);
        oldMansionBedSound = soundPool.load(this, R.raw.old_mansion_bed_sound, 1);
        oldMansionOshiireSound = soundPool.load(this, R.raw.old_mansion_oshiire_sound, 1);
        oldMansionNightSkySound = soundPool.load(this, R.raw.old_mansion_night_sky_sound, 1);
        moneyDropSound = soundPool.load(this, R.raw.money_drop, 1);
        waterDropSound = soundPool.load(this, R.raw.water_drop, 1);
        burstSound = soundPool.load(this, R.raw.burst_sound, 1);
        woodBrokenSound = soundPool.load(this, R.raw.wood_broken_sound, 1);
        oldWoodenDoorSound = soundPool.load(this, R.raw.old_wooden_door, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Log.d("debug", "sampleId="+sampleId);
                Log.d("debug", "status="+status);
            }
        });
        createSaveData();
        gameStart();
    }

    private void onClickStatus(View view){
        startActivity(new Intent(this, StatusActivity.class));
    }

    private void gameStart() {
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        playerInfos = realm.where(PlayerInfo.class).findAll();
        //ここは後から編集します
        playerInfos.addChangeListener(new OrderedRealmCollectionChangeListener<RealmResults<PlayerInfo>>() {
            @Override
            public void onChange(@NonNull RealmResults<PlayerInfo> playerInfos, @NonNull OrderedCollectionChangeSet changeSet) {
                mainHpBar.setMax(playerInfo.getFmaxHP());
                mainHpBar.setProgress(playerInfo.getHP());
                mainMpBar.setMax(playerInfo.getFmaxMP());
                mainMpBar.setProgress(playerInfo.getMP());
                if(playerInfo.isBleedingFlag()){
                    bleedingText.setText("血");
                }else {
                    bleedingText.setText("");
                }
                if(playerInfo.isPoisonFlag()){
                    poisonText.setText("毒");
                }else{
                    poisonText.setText("");
                }
            }
        });
        weaponNames = realm.where(WeaponName.class).findAll();
        position = playerInfo.getPosition();
        onClickMapButton = makeData.makeMapFromPosition(position);
        onClickMapButton.setDefaultInstances(this);
        //trueだった場合戦闘アクティビティを開きなおします、battleFlagは戦闘開始時にtrueに戦闘終了時にfalseに変更されます
        if(playerInfo.isBattleFlag()){
            Intent intent = new Intent(this, BattleActivity.class);
            intent.putExtra("EnemyId", playerInfo.getLastAffrontEnemy());
            startActivity(intent);
        }
        onClickMapButton.createMap();
    }

    //実際はmakePlayerStatusFromLevelメソッドにLevel0を代入して初期化します
    private void createSaveData(){
        try {
            realm.beginTransaction();
            playerInfo = realm.createObject(PlayerInfo.class, new String("player"));
            playerInfo.setPlayerLevel(50);
            playerInfo.setPosition(5);
            playerInfo.setMoney(100);
            playerInfo.setFmaxHP(1000);
            playerInfo.setHP(100);
            playerInfo.setFmaxMP(100);
            playerInfo.setMP(100);
            playerInfo.setSP(10);
            playerInfo.setfSP(180);
            playerInfo.setATK(10);
            playerInfo.setmATK(120);
            playerInfo.setDF(100);
            playerInfo.setLUK(10);
            //fLukはデフォで1/12*100程度の値をセット
            playerInfo.setfLUK(10);
            //状態異常のセット
            playerInfo.setBleedingFlag(false);
            playerInfo.setPoisonFlag(false);
            //階層を移動したときはsetEnemyLevel,街の中で敵を倒したときはsetAdditionalEnemyLevelを実行してください、後々時間経過で敵のレベルが戻っていく処理も追加します
            playerInfo.setBaseEnemyLevel(50);
            playerInfo.setAdditionalEnemyLevel(0);
            realm.commitTransaction();
            //atkとdfとhpのステータスを自動生成してだい素のステータスに代入してくれるメソッドです
            makeData.makePlayerStatusFromLevel(playerInfo.getPlayerLevel());
            //防具の処理を後々見直します
            realm.beginTransaction();
            //防具のステータスは考慮していません、防具の基礎ステータスも120前後、武器と同様にarmorDfとarmorLevelに保存し、装備時にfDfに保存、battleActivityで受け取ります
            //adapterのsetTextも変える
            playerInfo.setHP(playerInfo.getMaxHP());
            playerInfo.setFmaxHP(playerInfo.getMaxHP());
            playerInfo.setmATK(playerInfo.getATK());
            playerInfo.setmDF(playerInfo.getDF());
            //makeItemRealmObjectというクラスを作り、そこで行います。
            importantItemName = realm.createObject(ImportantItemName.class);
            importantItemName.setItemName("ベンチの材料");
            importantItemName = realm.createObject(ImportantItemName.class);
            importantItemName.setItemName("ブランコの材料");
            recoveryItemName = realm.createObject(RecoveryItemName.class);
            recoveryItemName.setItemName("HP回復薬小");
            recoveryItemName = realm.createObject(RecoveryItemName.class);
            recoveryItemName.setItemName("HP回復薬小");
            recoveryItemName = realm.createObject(RecoveryItemName.class);
            recoveryItemName.setItemName("HP回復薬小");
            recoveryItemName = realm.createObject(RecoveryItemName.class);
            recoveryItemName.setItemName("MP回復薬小");
            recoveryItemName = realm.createObject(RecoveryItemName.class);
            recoveryItemName.setItemName("MP回復薬小");
            amuletName = realm.createObject(AmuletName.class);
            amuletName.setAmuletName("SampleAmulet");
            //防具の中身の実装がまだの為、一時的に主人公の防御力を防具の防御力に代入しているが、実際は武器の時と同様にmakeArmorRealmObjectで生成した数値を代入する
            //防具のDfをマップレベルから生成しfDfに設定する処理とスキルの実装方法が今後の課題
            //防具のスキルはすべてパッシブなので装備時にRealmの値を変更する
            //hpの増減は防具のステータスによるものではなく、防具のパッシブスキルによるものとし
            //防具装備時にFmaxHPを直接変更する
            //メソッドを防具クラスに定義し、処理はEquipmentFragmentのsetOnClickListener内で実行する
            realm.commitTransaction();
            //防具もこれと同様にしてください
            makeWeaponRealmObject.createNewWeapon("SampleWeapon");
            makeArmorRealmObject.createNewArmor("SampleArmor");
            makeArmorRealmObject.createNewArmor("SampleArmor2");
        }catch (Exception e){
            realm.cancelTransaction();
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        MainActivity.mediaPlayer.stop();
        MainActivity.mediaPlayer.reset();
        MainActivity.mediaPlayer.release();
        MainActivity.mediaPlayer = null;
        soundPool.release();
        playerInfos.removeAllChangeListeners();
        realm.close();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    protected void onResume(){
        super.onResume();
        mediaPlayer.start();
    }
}
