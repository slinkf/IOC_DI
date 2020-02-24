package com.omega.ioc.di

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.omega.ioc.di.annotation.BindLayout
import com.omega.ioc.di.annotation.BindView
import com.omega.ioc.di.annotation.OnClick
import com.omega.ioc.di.annotation.OnClickByJava

@BindLayout(R.layout.activity_main)
class MainActivity :BaseActivity() {
    @BindView(R.id.di_tx)
    private lateinit var diTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diTextView.setTextColor(Color.parseColor("#0f0f0f"))
    }

    //由于kotlin注解的问题 参数
    @OnClickByJava(R.id.di_tx,R.id.di_tx2)
    fun onClick(view:View){
       Toast.makeText(this,"balabala ${view.id == R.id.di_tx}",Toast.LENGTH_LONG).show()
    }


}
