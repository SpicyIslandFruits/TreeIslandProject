package com.example.minor.prototype10.OnClickMapButtons.BaseMaps;

import android.media.MediaPlayer;
import android.view.View;

import com.example.minor.prototype10.MainActivity;
import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.R;

public class OnClickOldMansionInBasementButton extends SuperOnClickMapButton {
    @Override
    public void createMap() {
        position = 45;
        onInit();
        resetAllButtons();
        startAllButtons();
        String bgmName = "basementSound";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.basement_sound);
        audioPlay(mediaPlayer, bgmName);
        mainText.setText("重要そうな資料がある。");
        //日記、卵についての資料、悪魔についての研究資料、嵐についての研究資料
        imageButton1Text.setText("研究資料");
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("我々アメルーン一族とバルト族の間に子供が生まれることはない。\n(正確には、生まれてくるのは人ではない。見たものにしか分からない忌まわしいものだ。)");
                        imageButton1.setEnabled(true);
                        imageButton1Text.setText("次のページ");
                        imageButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mainText.setText("");
                                imageButton8Text.setText("");
                                imageButton8.setEnabled(false);
                                imageButton1Text.setText("");
                                imageButton1.setEnabled(false);
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageButton8Text.setText("閉じる");
                                        imageButton8.setEnabled(true);
                                        mainText.setText("私はその理由について研究を重ねたが、遺伝的な原因は一切見つからなかった。");
                                    }
                                }, 800);
                            }
                        });
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("閉じる");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                stopAllButtons();
                                mainText.setText("");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createMap();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 800);
            }
        });

        imageButton2Text.setText("社会学の本");
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("我々とバルト族の関係は、ますます悪化している。\nバルト族は、際立った人種主義と群集暗示の魔術的な力に翻弄されている。");
                        imageButton1.setEnabled(true);
                        imageButton1Text.setText("次のページ");
                        imageButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mainText.setText("");
                                imageButton8Text.setText("");
                                imageButton8.setEnabled(false);
                                imageButton1Text.setText("");
                                imageButton1.setEnabled(false);
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageButton8Text.setText("閉じる");
                                        imageButton8.setEnabled(true);
                                        mainText.setText("彼らは過去の我々と同じ過ちを繰り返そうとしている。\nこれから我々アメルーン一族には、確実に暗い未来が訪れるだろう。");
                                    }
                                }, 800);
                            }
                        });
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("閉じる");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                stopAllButtons();
                                mainText.setText("");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createMap();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 800);
            }
        });

        imageButton3Text.setText("日記");
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                stopAllButtons();
                mainText.setText("");
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mainText.setText("パトローナムが破られた。跡形も残っていなかった。私には、見たものすべてを物語る勇気がない。すべて作り話のはずだったのに......。");
                        imageButton1.setEnabled(true);
                        imageButton1Text.setText("次のページ");
                        imageButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mainText.setText("");
                                imageButton8Text.setText("");
                                imageButton8.setEnabled(false);
                                imageButton1Text.setText("");
                                imageButton1.setEnabled(false);
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        imageButton8Text.setText("閉じる");
                                        imageButton8.setEnabled(true);
                                        mainText.setText("やつがここに辿り着くのも時間の問題だろう。このままでは間に合わない、せめて家族だけでも救うことができたら......");
                                    }
                                }, 800);
                            }
                        });
                        imageButton8.setEnabled(true);
                        imageButton8Text.setText("閉じる");
                        imageButton8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.soundPool.play(MainActivity.oldMansionOshiireSound, 1.0f, 1.0f, 1, 0, 1);
                                stopAllButtons();
                                mainText.setText("");
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        createMap();
                                    }
                                }, 1000);
                            }
                        });
                    }
                }, 800);
            }
        });
        OnClickGardenButton onClickGardenButton = new OnClickGardenButton();
        imageButton8.setOnClickListener(onClickGardenButton);
        imageButton8Text.setText("出る");
    }

    @Override
    public void onClick(View v) {
        position = 45;
        onInit();
        resetAllButtons();
        stopAllButtons();
        String bgmName = "noise";
        mediaPlayer = MediaPlayer.create(mMain, R.raw.noise);
        audioPlay(mediaPlayer, bgmName);
        MainActivity.soundPool.play(MainActivity.walkGymnasiumSound, 5.0f, 5.0f, 1, 0, 0.8f);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.soundPool.play(MainActivity.doorOpenSound, 1.0f, 1.0f, 1, 0, 0.8f);
            }
        }, 4500);
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createMap();
            }
        }, 5500);
    }
}
