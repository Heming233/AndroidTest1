package com.example.activitytest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.window.OnBackInvokedDispatcher
import com.example.activitytest.databinding.SecondLayoutBinding

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SecondActivity", "Task is $taskId")
        setContentView(R.layout.second_layout)

        //接收FirstActivity传递的数据并打印
//        val extraData = intent.getStringExtra("data")
//        Log.d("SecondActivity", "extra data is $extraData")

        //使用ViewBinding调用组件
        val binding = SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener({
//            val intent = Intent()
//            intent.putExtra("data", "data from SecondActivity")
//            setResult(RESULT_OK, intent)
//
//            //销毁activity
//            finish()

            //启动FirstActivity，standard模式
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        })

    }

    //重写onBackPressed方法，应对用户直接按返回键返回上一个activity
    //最新安卓版本，onBackPressed已被弃用
    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        val intent = Intent()
        intent.putExtra("data_return", "Hello FirstActivity")
        setResult(RESULT_OK, intent)
        return super.getOnBackInvokedDispatcher()
    }

    companion object{
        fun actionStart(context : Context, data1 : String, data2 : String) {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("param1", data1)
            intent.putExtra("param2", data2)
            context.startActivity(intent)
        }
    }
}