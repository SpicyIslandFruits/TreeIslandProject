package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

//ダンジョンのコメントを参照
public class OnClickTownButton extends SuperOnClickMapButton{

    @Override
    public void onClick(View v) {
        createMap();
    }
    public void createMap(){
        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton1.setOnClickListener(onClickDungeonButton);
        OnClickInnButton onClickInnButton = new OnClickInnButton();
        imageButton2.setOnClickListener(onClickInnButton);
        mainText.setText("ここは街です");
        position = 1;
        savePosition();
    }
}
