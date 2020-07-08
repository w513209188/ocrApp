package com.wb.ocrlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.shouzhong.scanner.ScannerUtils;
import com.wb.ocrlib.thread.IdCardThread;

public class ImageOcrManger {
    private static ImageOcrManger imageOcrManger;
    //初始化
    public static ImageOcrManger getInstance(){
        synchronized (ImageOcrManger.class){
            if(imageOcrManger==null){
                imageOcrManger=new ImageOcrManger();
            }
        }
        return imageOcrManger;
    }
    public void getStringByImage(ImageConfig imageConfig){
        if(imageConfig==null){
           Log.e("imageConfig","imageConfig is not null");
           return;
        }
        if(imageConfig.getCall()==null){
            Log.e("imageConfig","imageConfig setcall is not null");
            return;
        }
        if(imageConfig.getBitmap()==null){
            imageConfig.getCall().getImageCall("bitmap不能为空",false);
            return;
        }
        if(imageConfig.getmContetx()==null){
            imageConfig.getCall().getImageCall("context不能为空",false);
            return;
        }
        if(imageConfig.getImageOcrType()==ImageOcrType.IDCORD){
            new Thread(new IdCardThread(imageConfig)).start();
        }else {
            imageConfig.getCall().getImageCall("无效的标识",false);
        }

    }
}
