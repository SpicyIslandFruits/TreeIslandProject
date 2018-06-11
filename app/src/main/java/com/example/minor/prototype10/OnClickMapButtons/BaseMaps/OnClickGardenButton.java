package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

/**
 * Created by nishiokakota on 2018/05/06.
 */

public class OnClickGardenButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 19;
        savePosition();
        resetAllButtons();
        mainText.setText("お前は庭に出た...。\n小さなブランコが置いてある、家族で住んでいたのだろうか。");
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        String bgmName = "oldMansionBgm";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.old_mansion_bgm);
        audioPlay(mediaPlayer, bgmName);

        //街で木材を買ってきて修理すると使えるようになる。データはsharedPreferenceに保存
        OnClickBenchButton onClickBenchButton = new OnClickBenchButton();
        imageButton1.setOnClickListener(onClickBenchButton);
        imageButton1Text.setText("ベンチ");

        OnClickIdoButton onClickIdoButton = new OnClickIdoButton();
        imageButton2.setOnClickListener(onClickIdoButton);
        imageButton2Text.setText("井戸");

        //ブランコと同様、修理した後に現れるイベントを考える、ブランコを直すと、ひとりでにブランコが動き出し、笑い声が聞こえる。幽霊が成仏する設定。幽霊はラスボスの娘。
        OnClickBurankoButton onClickBurankoButton = new OnClickBurankoButton();
        imageButton3.setOnClickListener(onClickBurankoButton);
        imageButton3Text.setText("ブランコ");

        OnClickGardenCornerButton onClickGardenCornerButton = new OnClickGardenCornerButton();
        imageButton7.setOnClickListener(onClickGardenCornerButton);
        imageButton7Text.setText("庭の隅");

        OnClickOldMansion1FButton onClickOldMansion1FButton = new OnClickOldMansion1FButton();
        imageButton8.setOnClickListener(onClickOldMansion1FButton);
        imageButton8Text.setText("屋敷に戻る");
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
