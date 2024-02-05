package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytest.databinding.ThirdLayoutBinding

class ThirdActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ThirdActivity", "Task is $taskId")
        setContentView(R.layout.third_layout)

        val binding = ThirdLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button3.setOnClickListener({
            //退出程序
            ActivityCollector.finishAll()
            //杀死进程
            android.os.Process.killProcess(android.os.Process.myPid())
        })
    }
}