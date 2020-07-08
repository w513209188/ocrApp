package com.wb.ocrlib;

import android.content.Context;
import android.graphics.Bitmap;

import com.wb.ocrlib.call.ImageCall;

public class ImageConfig {
    private Bitmap bitmap=null;
    private int imageOcrType=ImageOcrType.IDCORD;
    private Context mContetx;
    private ImageCall call;
    public Bitmap getBitmap() {
        return bitmap;
    }
    public int getImageOcrType() {
        return imageOcrType;
    }
    public Context getmContetx() {
        return mContetx;
    }

    public ImageCall getCall() {
        return call;
    }

    public static class Builder{
        private Bitmap bitmap;
        private int imageOcrType;
        private Context mContetx;
        private ImageCall call;

        public Builder setCall(ImageCall call) {
            this.call = call;
            return this;
        }

        public Builder setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public Builder setImageOcrType(int imageOcrType) {
            this.imageOcrType = imageOcrType;
            return this;
        }

        public Builder with(Context mContetx) {
            this.mContetx = mContetx;
            return this;
        }
        public ImageConfig builder(){
            ImageConfig imageConfig=new ImageConfig();
            imageConfig.bitmap=this.bitmap;
            imageConfig.imageOcrType=this.imageOcrType;
            imageConfig.mContetx=this.mContetx;
            imageConfig.call=this.call;
            return imageConfig;
        }
    }
}
