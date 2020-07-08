package com.wb.ocrlib.thread;

import android.util.Log;

import com.shouzhong.scanner.ScannerUtils;
import com.wb.ocrlib.ImageConfig;

public class IdCardThread extends Thread {
    ImageConfig imageConfig;
    public IdCardThread(ImageConfig imageConfig) {
        this.imageConfig = imageConfig;
    }
    @Override
    public void run() {
        super.run();
        com.shouzhong.scanner.Result result = null;
        try {
            result = ScannerUtils.decodeIdCard(imageConfig.getmContetx(),imageConfig.getBitmap());
        } catch (Exception e) {
            imageConfig.getCall().getImageCall(e.getMessage(),false);
        }
        if(result==null){
            imageConfig.getCall().getImageCall("识别失败",false);
        }else {
            imageConfig.getCall().getImageCall(result.data,true);
        }
    }
}
