package com.omega.ioc.di

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import com.omega.ioc.di.annotation.BindLayout
import com.omega.ioc.di.annotation.BindView
import com.omega.ioc.di.annotation.OnClick

@BindLayout(R.layout.activity_main)
class MainActivity :BaseActivity() {
    @BindView(R.id.di_tx)
    private lateinit var diTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diTextView.setTextColor(Color.parseColor("#0f0f0f"))
      //  diTextView.setOnClickListener(View.OnClickListener {  })
    }

    @OnClick
    fun onClick(){

    }


}
