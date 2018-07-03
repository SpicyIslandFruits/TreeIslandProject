package com.example.minor.prototype10.OnClickMapButtons.TownMaps;

import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;

public class OnClickTown1FObservatoryMapButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 10003;
        onInit();
        resetAllButtons();
        MainActivity.soundPool.play(MainActivity.walkingSound, 1.0f, 1.0f, 1, 0, 1);
        mainText.setText("【展望台】\n街1の展望台です。文章未定。チュートリアル又は街の雰囲気を書きます。おっさんを用意して会話させる。街はとても入り組んだ構造になっています。");
        //おっさんを立たせて会話させる。
        OnClickTown1FStreetAButton onClickTown1FStreetAButton = new OnClickTown1FStreetAButton();
        imageButton8.setOnClickListener(onClickTown1FStreetAButton);
        imageButton8Text.setText("戻る");
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
