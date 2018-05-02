package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

import com.example.minor.prototype10.MainActivity;

/**
 * positionの定義savePositionを一番最初に絶対実行せなあかん
 * resetAllButtonsを一番最初に絶対実行せなあかん
 * mainText.setTextを変える
 * map遷移時のsoundを。
 * onClickの中身は三段階（stopAllButtons,createMap,1秒後にstartAllButtons)
 * obtainItem,obtainArmorを追加
 * OnClickMapButton onClickMapButton = new OnClickMapButton();
 * imageButton.setOnClickListener(onClickMapButton);
 * imageButtonText.setText("");
 * をやる
 * encounter, obtainWeapon, changeBaseEnemyLevel, changeAdditionalEnemyLevel
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
        mainText.setText("未実装です.to touge");
        MainActivity.soundPool.play(MainActivity.sampleSound1, 1.0f, 1.0f, 1, 0, 1);
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
