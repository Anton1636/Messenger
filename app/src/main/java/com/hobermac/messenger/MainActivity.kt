package com.hobermac.messenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.hobermac.messenger.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem

class MainActivity : AppCompatActivity()
{
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private  lateinit var mToolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

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
        createHeader()
        createDrewer()
    }

    private fun createDrewer()
    {
        mDrawer = DrawerBuilder().withActivity(this)
                                 .withToolbar(mToolBar)
                                 .withActionBarDrawerToggle(true)
                                 .withSelectedItem(-1)
                                 .withAccountHeader(mHeader)
                                 .addDrawerItems(PrimaryDrawerItem().withIdentifier(100)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Create group")
                                                                    .withSelectable(false)).build()
    }

    private fun createHeader()
    {
        mHeader = AccountHeaderBuilder().withActivity(this)
                                        .withHeaderBackground(R.drawable.header)
                                        .addProfiles(ProfileDrawerItem().withName("Test Testov")
                                                                        .withEmail("+380999999999")).build()
    }

    private fun initFields()
    {
        mToolBar = mBinding.mainToolBar

    }
}