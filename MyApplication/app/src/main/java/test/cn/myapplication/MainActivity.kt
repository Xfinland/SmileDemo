package test.cn.myapplication

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test.text ="success";
        test.background.alpha = 1;
        test.text ="successaaaaa";

    }
}
