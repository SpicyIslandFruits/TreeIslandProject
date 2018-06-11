package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.OnClickPassButton;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

/**
 * 作成中のマップで未実装のマップを使う必要が出た場合はとりあえずここにつなげてください
 * positionの定義savePositionを一番最初に絶対実行せなあかん
 * resetAllButtonsを一番最初に絶対実行せなあかん
 * mainText.setTextを変える
 * map遷移時のsoundを。
 * onClickの中身は三段階（stopAllButtons,createMap,1秒後にstartAllButtons)
 * OnClickMapButton onClickMapButton = new OnClickMapButton();
 * imageButton.setOnClickListener(onClickMapButton);
 * imageButtonText.setText("");
 * をやる
 * makeDataにswitchを追加
 * encounter, obtainWeapon, changeBaseEnemyLevel, changeAdditionalEnemyLevel, obtainArmor, obtainAmulet, obtainImportantItem, obtainRecoveryItem
 * マップの階層が深くなる時はbaseEnemyLevelを編集してください
 * 敵とのエンカウントをさせたい場合はencounterメソッドを実行してください、エンカウントする敵のidと確率を引数に入れてください
 * changeBaseEnemyLevelをするときはsavePositionの後に実行してください
 * changeBaseEnemyLevelとobtainWeaponまたはencounterを同じマップでどちらも実行するときはchangeBaseEnemyLevelの後に実行してください
 */
public class OnClickEmptyButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 7;
        savePosition();
        resetAllButtons();
        mainText.setText("ここは空のマップです。");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        OnClickPassButton onClickPassButton = new OnClickPassButton();
        imageButton8.setOnClickListener(onClickPassButton);
        imageButton8Text.setText("峠に戻る");
    }

    @Override
    public void onClick(View v) {
        stopAllButtons();
        createMap();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAllButtons();
            }
        }, 1000);
    }
}
