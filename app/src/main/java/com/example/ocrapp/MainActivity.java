package com.example.ocrapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wb.ocrlib.ImageConfig;
import com.wb.ocrlib.ImageOcrManger;
import com.wb.ocrlib.ImageOcrType;
import com.wb.ocrlib.call.ImageCall;

public class MainActivity extends AppCompatActivity  implements ImageOcrType{
    private TextView sb_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb_tv=findViewById(R.id.sb_tv);
        final Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.sfz_img);
        sb_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageConfig imageConfig=new ImageConfig.Builder().with(MainActivity.this).setBitmap(bitmap).setCall(new ImageCall() {
                    @Override
                    public void getImageCall(String msg, boolean isSuccess) {
                        Log.e("获取图片信息",msg+"-----"+isSuccess);
                    }
                }).setImageOcrType(ImageOcrType.IDCORD).builder();
                ImageOcrManger.getInstance().getStringByImage(imageConfig);
            }
        });
    }
}
