package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: FirstLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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