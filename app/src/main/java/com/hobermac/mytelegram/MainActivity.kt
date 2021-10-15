package com.hobermac.mytelegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.hobermac.mytelegram.databinding.ActivityMainBinding
import com.hobermac.mytelegram.ui.fragments.ChatsFragment
import com.hobermac.mytelegram.ui.objects.AppDrawer

class MainActivity : AppCompatActivity()
{
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAopDrawer:AppDrawer
    private  lateinit var mToolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart()
    {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc()
    {
        setSupportActionBar(mToolBar)
        mAopDrawer.create()
        supportFragmentManager.beginTransaction().replace(R.id.dataContainer, ChatsFragment()).commit() //Add chats fragment to main activity
    }

    private fun initFields()
    {
        mToolBar = mBinding.mainToolBar
        mAopDrawer = AppDrawer(this, mToolBar)
    }
}