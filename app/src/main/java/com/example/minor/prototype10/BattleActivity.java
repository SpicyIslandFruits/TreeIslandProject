package com.example.minor.prototype10;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.minor.prototype10.Enemys.SampleBoss;
import com.example.minor.prototype10.Enemys.SuperEnemy;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.PlayerSkill.SampleSkill;
import com.example.minor.prototype10.PlayerSkill.SuperSkill;
import com.example.minor.prototype10.Weapons.SampleWeapon;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.Realm;

/**
 * 敵とのエンカウント方式の実装、intentから敵情報受け取り
 * 受け取る情報は敵のidのみ基礎ステータスとbaseEnemyLevelとadditionalEnemyLevelからそのダンジョンにふさわしいステータスを生成します
 * 後でキャンセルボタンの追加を行う
 */
public class BattleActivity extends AppCompatActivity {
    private Realm realm;
    private PlayerInfo playerInfo;
    private ProgressBar hpBar, mpBar, spBar, enemyHpBar;
    private GaugeView breakGage;
    private TextView battleText;
    private ListView selectedSkillLists;
    private ArrayAdapter<String> skillNameAdapter;
    private MakeData makeData;
    private int weaponId;
    private int enemyId;
    private SuperEnemy enemy;
    private SuperWeapon weapon;
    private SuperSkill playerSkill1, playerSkill2, playerSkill3, playerSkill4;
    private ImageButton decisionButton, normalAttackButton,skillButton1, skillButton2, skillButton3;
    private ImageButton playerSkill1Button, playerSkill2Button, playerSkill3Button, playerSkill4Button;
    private int[] tempAllStatus;
    private int maxHp, hp, maxMp, mp, sp, atk, df, luk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk, breakNum, playerLevel, weaponAtk;
    private int turnCount = 0, tempTurnCount = 0;
    private int[] gradation;

    //skillButtonをfindViewByIdしてonClickにsetPlayerBehaviorを入れる、たぶん編集の必要なし
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        int[] colors = {
                ContextCompat.getColor(this, R.color.color_0),
                ContextCompat.getColor(this, R.color.color_10),
                ContextCompat.getColor(this, R.color.color_20),
                ContextCompat.getColor(this, R.color.color_30),
                ContextCompat.getColor(this, R.color.color_40),
                ContextCompat.getColor(this, R.color.color_50),
                ContextCompat.getColor(this, R.color.color_60),
                ContextCompat.getColor(this, R.color.color_70),
                ContextCompat.getColor(this, R.color.color_80),
                ContextCompat.getColor(this, R.color.color_90),
                ContextCompat.getColor(this, R.color.color_100)
        };
        gradation = colors;
        makeData = new MakeData();
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        weaponId = playerInfo.getWeaponId();
        weapon = makeData.makeWeaponFromId(weaponId);
        //一時的にサンプルスキルを使う本来は上に書いてあるweaponと同様の処理を行って自分の装備してあるスキルのインスタンスを取得する
        playerSkill1 = new SampleSkill();
        playerSkill2 = new SampleSkill();
        playerSkill3 = new SampleSkill();
        playerSkill4 = new SampleSkill();
        //一時的にサンプルボスを使う、本来はintentから受けとったidを使ってMakeDataクラスのメソッドでインスタンスを取得する
        enemy = new SampleBoss();
        tempAllStatus = new int[15];
        skillNameAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_list_item_1);
        hpBar = (ProgressBar) findViewById(R.id.hp_bar);
        mpBar = (ProgressBar) findViewById(R.id.mp_bar);
        spBar = (ProgressBar) findViewById(R.id.sp_bar);
        enemyHpBar = (ProgressBar) findViewById(R.id.enemy_hp_bar);
        breakGage = (GaugeView) findViewById(R.id.break_gage);
        battleText = (TextView) findViewById(R.id.battle_text);
        decisionButton = (ImageButton) findViewById(R.id.decision_button);
        normalAttackButton = (ImageButton) findViewById(R.id.normal_attack);
        skillButton1 = (ImageButton) findViewById(R.id.skill1);
        skillButton2 = (ImageButton) findViewById(R.id.skill2);
        skillButton3 = (ImageButton) findViewById(R.id.skill3);
        playerSkill1Button = (ImageButton) findViewById(R.id.player_skill1);
        playerSkill2Button = (ImageButton) findViewById(R.id.player_skill2);
        playerSkill3Button = (ImageButton) findViewById(R.id.player_skill3);
        playerSkill4Button = (ImageButton) findViewById(R.id.player_skill4);
        selectedSkillLists = (ListView) findViewById(R.id.selected_skills_list);
        selectedSkillLists.setAdapter(skillNameAdapter);
        decisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDecision();
                executeBattle();
            }
        });
        normalAttackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(0);
            }
        });
        skillButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(1);
            }
        });
        skillButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(2);
            }
        });
        skillButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(3);
            }
        });
        playerSkill1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(4);
            }
        });
        playerSkill2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(5);
            }
        });
        playerSkill3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(6);
            }
        });
        playerSkill4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(7);
            }
        });
        inputAllStatus();
    }

    //多分ここは編集の必要なし
    private void setPlayerBehavior(int num) {
        if(turnCount != tempTurnCount){
            startNewTurn();
            executeTempBattle(num);
            tempTurnCount = turnCount;
        }else{
            executeTempBattle(num);
        }
    }

    //tempを実際の値に代入、ターンを進める、後でspの処理を見直す
    private void onDecision(){
        tempAllStatus = enemy.setEnemyBehavior(tempAllStatus);
        hp = tempAllStatus[0];
        mp = tempAllStatus[1];
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                playerInfo = realm.where(PlayerInfo.class).findFirst();
                playerInfo.setMP(mp);
                playerInfo.setHP(hp);
            }
        });
        sp = tempAllStatus[12];
        atk = tempAllStatus[3];
        df = tempAllStatus[4];
        luk = tempAllStatus[5];
        enemyHp = tempAllStatus[6];
        enemySp = tempAllStatus[7];
        enemyAtk = tempAllStatus[8];
        enemyDf = tempAllStatus[9];
        enemyLuk = tempAllStatus[10];
        breakNum = tempAllStatus[11];
        turnCount++;
    }

    //どちらかのhpが0以下になったらリザルト画面を表示する処理
    //一回敵を倒すごとにどれだけ敵のレベルが上がるかどうかをsetAdditionalEnemyLevelの引数に代入してください
    private void executeBattle(){
        skillNameAdapter.clear();
        battleText.setText("自分のHPは" + String.valueOf(hp) + "敵のHPは" + String.valueOf(enemyHp));
        breakGage.setData(tempAllStatus[11], "%", gradation, 10, true);
        hpBar.setProgress(hp);
        enemyHpBar.setProgress(enemyHp);
        spBar.setProgress(0);
        mpBar.setProgress(maxMp-mp);
        if(hp<=0 ||enemyHp<=0){
            if(enemyHp <= 0){
                realm.beginTransaction();
                playerInfo.setAdditionalEnemyLevel(playerInfo.getAdditionalEnemyLevel() + 5);
                realm.commitTransaction();
            }
            finish();
        }
    }

    //通常攻撃のみブレイク値を定数にしオーバードライブできるようにする
    //このメソッドではPlayerSkillクラスとWeaponクラスからskillを受け取って実行し、tempに処理後のデータを保存します
    //mpが0未満になる場合の処理も追加する
    private void executeTempBattle(int num){
        switch (num){
            case 0:
                //通常攻撃はsp最大値の1/3を消費します
                if(weapon.skill0(tempAllStatus)[2] >= 0 && tempAllStatus[6] > weapon.skill0(tempAllStatus)[6]) {
                    tempAllStatus = weapon.skill0(tempAllStatus);
                    skillNameAdapter.add("通常攻撃");
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                    tempAllStatus[11] = tempAllStatus[11] + 5;
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 1:
                if(weapon.skill1(tempAllStatus)[2] >= 0 && tempAllStatus[6] > weapon.skill1(tempAllStatus)[6]) {
                    tempAllStatus = weapon.skill1(tempAllStatus);
                    skillNameAdapter.add(weapon.getSkill1Name());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                    calculateIncrementOfBreakGageFromBreakNum();
                }else if (weapon.skill1(tempAllStatus)[2] >= 0){
                    tempAllStatus = weapon.skill1(tempAllStatus);
                    skillNameAdapter.add(weapon.getSkill1Name());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 2:
                if(weapon.skill2(tempAllStatus)[2] >= 0 && tempAllStatus[6] > weapon.skill2(tempAllStatus)[6]) {
                    tempAllStatus = weapon.skill2(tempAllStatus);
                    skillNameAdapter.add(weapon.getSkill2Name());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                    calculateIncrementOfBreakGageFromBreakNum();
                }else if (weapon.skill2(tempAllStatus)[2] >= 0){
                    tempAllStatus = weapon.skill2(tempAllStatus);
                    skillNameAdapter.add(weapon.getSkill2Name());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 3:
                if(weapon.skill3(tempAllStatus)[2] >= 0 && tempAllStatus[6] > weapon.skill3(tempAllStatus)[6]) {
                    tempAllStatus = weapon.skill3(tempAllStatus);
                    skillNameAdapter.add(weapon.getSkill3Name());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                    calculateIncrementOfBreakGageFromBreakNum();
                }else if (weapon.skill3(tempAllStatus)[2] >= 0){
                    tempAllStatus = weapon.skill3(tempAllStatus);
                    skillNameAdapter.add(weapon.getSkill3Name());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 4:
                if(playerSkill1.skill(tempAllStatus)[2] >= 0 && playerSkill1.skill(tempAllStatus)[1] >= 0){
                    tempAllStatus = playerSkill1.skill(tempAllStatus);
                    skillNameAdapter.add(playerSkill1.getSkillName());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spまたはmpが足りません");
                }
                break;
            case 5:
                if(playerSkill2.skill(tempAllStatus)[2] >= 0 && playerSkill1.skill(tempAllStatus)[1] >= 0){
                    tempAllStatus = playerSkill2.skill(tempAllStatus);
                    skillNameAdapter.add(playerSkill2.getSkillName());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spまたはmpが足りません");
                }
                break;
            case 6:
                if(playerSkill3.skill(tempAllStatus)[2] >= 0 && playerSkill1.skill(tempAllStatus)[1] >= 0){
                    tempAllStatus = playerSkill3.skill(tempAllStatus);
                    skillNameAdapter.add(playerSkill3.getSkillName());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spまたはmpが足りません");
                }
                break;
            case 7:
                if(playerSkill4.skill(tempAllStatus)[2] >= 0 && playerSkill1.skill(tempAllStatus)[1] >= 0){
                    tempAllStatus = playerSkill4.skill(tempAllStatus);
                    skillNameAdapter.add(playerSkill4.getSkillName());
                    spBar.setMax(sp);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spまたはmpが足りません");
                }
                break;
        }
    }

    //mAtkを受け取り武器の攻撃力は戦闘処理の時に別で加算される
    //fAtkは装備中の武器のステータスです
    //防具の数値も作成する必要あり
    private void inputAllStatus(){
        maxHp = playerInfo.getFmaxHP();
        maxMp = playerInfo.getFmaxMP();
        tempAllStatus[0] = hp = playerInfo.getHP();
        tempAllStatus[1] = mp = playerInfo.getMP();
        tempAllStatus[2] = sp = playerInfo.getfSP();
        tempAllStatus[3] = atk = playerInfo.getmATK();
        tempAllStatus[4] = df = playerInfo.getfDF();
        tempAllStatus[5] = luk = playerInfo.getfLUK();
        tempAllStatus[6] = enemyHp = enemy.getHp();
        tempAllStatus[7] = enemySp = enemy.getSp();
        tempAllStatus[8] = enemyAtk = enemy.getAtk();
        tempAllStatus[9] = enemyDf = enemy.getDf();
        tempAllStatus[10] = enemyLuk = enemy.getLuk();
        tempAllStatus[11] = breakNum = 50;
        tempAllStatus[12] = playerInfo.getfSP();
        tempAllStatus[13] = playerLevel = playerInfo.getPlayerLevel();
        tempAllStatus[14] = weaponAtk = playerInfo.getfATK();
        breakGage.setData(breakNum, "%", gradation, 10, true);
        hpBar.setMax(maxHp);
        mpBar.setMax(maxMp);
        spBar.setMax(sp);
        enemyHpBar.setMax(enemyHp);
        spBar.setProgress(0);
        mpBar.setProgress(maxMp-mp);
        hpBar.setProgress(hp);
        enemyHpBar.setProgress(enemyHp);
    }

    //ここは編集の必要なし
    private void startNewTurn(){
        tempAllStatus[0] = hp;
        tempAllStatus[1] = mp;
        tempAllStatus[2] = sp;
        tempAllStatus[3] = atk;
        tempAllStatus[4] = df;
        tempAllStatus[5] = luk;
        tempAllStatus[6] = enemyHp;
        tempAllStatus[7] = enemySp;
        tempAllStatus[8] = enemyAtk;
        tempAllStatus[9] = enemyDf;
        tempAllStatus[10] = enemyLuk;
        tempAllStatus[11] = breakNum;
        tempAllStatus[12] = sp;
        tempAllStatus[13] = playerLevel;
        tempAllStatus[14] = weaponAtk;
    }

    //ブレイクゲージの増減式です、敵の攻撃による増減は敵クラスに任意の値を書いてください
    //スキルによってさらに増減させたい場合はここに書いてある値を考慮してください
    private void calculateIncrementOfBreakGageFromBreakNum(){
        if(tempAllStatus[11]>50){
            tempAllStatus[11] = tempAllStatus[11] + 4;
        }else if(tempAllStatus[11]<=50){
            tempAllStatus[11] = tempAllStatus[11] + 8;
            if (tempAllStatus[11] > 50){
                tempAllStatus[11] = 80;
            }
        }
        if(tempAllStatus[11] < 0){
            tempAllStatus[11] = 0;
        }
    }
}
