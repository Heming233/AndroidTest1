package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : BaseActivity() {

    private lateinit var binding: FirstLayoutBinding

    //使用registerForActivityResult来注册一个变量用于监听Activity
    private val requestDataLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        result -> if(result.resultCode == RESULT_OK){
            val data = result.data?.getStringExtra("data")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity", "Task id is $taskId")
        setContentView(R.layout.first_layout)
//        val button1 : Button = findViewById(R.id.button1)
//        button1.setOnClickListener({
//            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
//        })
        //Toast是一个消息通知方法，一段时间后小时，不占用屏幕空间
        binding = FirstLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener({
            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()

            //intent组件实现不同组件之间交互，包括指明当前组件想要执行的动作，还可以在不同组件之间传递数据
            //intent显式用法
            //SecondActivity::class.java等于Java里的SecondActivity.class
//            val intent = Intent(this, SecondActivity::class.java)

            //intent隐式用法
//            val intent = Intent("com.example.activitytest.ACTION_START")
//            intent.addCategory("com.example.activitytest.MY_CATEGORY")
//            startActivity(intent)
//            val intent = Intent

            //使用隐式intent启动浏览器打开百度
            //Intent.ACTION_VIEW是Android内置的动作
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)

            //使用隐式intent拨打电话
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
//            startActivity(intent)

            //intent传递数据
//            val data = "Hello SecondActivity, I'm FirstActivity!"
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("extra_data", data)
//            startActivity(intent)

            //接收其他activity返回的数据
            //startActivityForResult已被弃用
//           startActivityForResult(intent, 1)
            //使用Activity Result API来代替startActivityResult()
//            val intent = Intent(this, SecondActivity::class.java)
//            requestDataLauncher.launch(intent)

            //标准启动activity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //创建一个menuInflater对象，并且赋值
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show()

        }
        return true
    }
}