package com.alivc.qrcodedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.pdf417.encoder.PDF417;
import com.google.zxing.qrcode.QRCodeReader;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {
    private ImageView inputImage1;
    private TextView resultTV1;
    private ImageView inputImage2;
    private TextView resultTV2;
    private Result result = null;
    Collection<BarcodeFormat> decodeFormats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputImage1 = (ImageView)findViewById(R.id.input_iv1);
        resultTV1 = (TextView)findViewById(R.id.result_tv1);
        inputImage2 = (ImageView)findViewById(R.id.input_iv2);
        resultTV2 = (TextView)findViewById(R.id.result_tv2);
        decodeFormats = EnumSet.noneOf(BarcodeFormat.class);
        decodeFormats.addAll(EnumSet.of(BarcodeFormat.PDF_417));
//        scanImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resultTV.setText(decodeBitmap());
//            }
//        });

    }

    public String decodeBitmap(){
        Bitmap inputBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test1);
        MultiFormatReader reader = new MultiFormatReader();
//        reader.decode()
        Hashtable<DecodeHintType,Object> hints = new Hashtable<DecodeHintType, Object>();
      //  hints.put(DecodeHintType.POSSIBLE_FORMATS, decodeFormats);
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        RGBLuminanceSource rgbLuminanceSource = new RGBLuminanceSource(inputBitmap);
        //将图片转换成二进制图片
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(rgbLuminanceSource));
        //初始化解析对象
        //开始解析
        Result result = null;
        try {
            result = reader.decode(binaryBitmap ,hints );
        } catch (Exception e) {
            // TODO: handle exception
           return e.toString();
        }
        return result.toString();

    }
}
