package com.hobermac.mytelegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.hobermac.mytelegram.databinding.ActivityMainBinding
import com.hobermac.mytelegram.ui.ChatsFragment
import com.hobermac.mytelegram.ui.SettingsFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class MainActivity : AppCompatActivity()
{
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
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
        supportFragmentManager.beginTransaction().replace(R.id.dataContainer, ChatsFragment()).commit() //Add chats fragment to main activity
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder().withActivity(this)
                                 .withToolbar(mToolBar)
                                 .withActionBarDrawerToggle(true)
                                 .withSelectedItem(-1)
                                 .withAccountHeader(mHeader)
                                 .addDrawerItems(PrimaryDrawerItem().withIdentifier(100)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Create Group")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_create_groups),
                                                 PrimaryDrawerItem().withIdentifier(101)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Create Secret Chat")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_secret_chat),
                                                 PrimaryDrawerItem().withIdentifier(102)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Create Channel")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_create_channel),
                                                 PrimaryDrawerItem().withIdentifier(103)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Contacts")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_contacts),
                                                 PrimaryDrawerItem().withIdentifier(104)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Calls")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_phone),
                                                 PrimaryDrawerItem().withIdentifier(105)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Favorites")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_favorites),
                                                 PrimaryDrawerItem().withIdentifier(106)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Settings")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_settings),
                                                 PrimaryDrawerItem().withIdentifier(107)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Create Group")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_create_groups),
                                                DividerDrawerItem(),
                                                 PrimaryDrawerItem().withIdentifier(108)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Invite friends")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_invate),
                                                 PrimaryDrawerItem().withIdentifier(109)
                                                                    .withIconTintingEnabled(true)
                                                                    .withName("Help")
                                                                    .withSelectable(false)
                                                                    .withIcon(R.drawable.ic_menu_help)
                                 ).withOnDrawerItemClickListener(object :Drawer.OnDrawerItemClickListener
                                  {
                                        override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean
                                        {
                                            when(position)
                                            {
                                                7 -> supportFragmentManager.beginTransaction()
                                                                             .addToBackStack(null)
                                                                             .replace(R.id.dataContainer, SettingsFragment())
                                                                             .commit() //Add chats fragment to main activity
                                            }
                                            return false
                                        }
                                  }).build()
    }

    private fun createHeader()
    {
        mHeader = AccountHeaderBuilder().withActivity(this)
                                        .withHeaderBackground(R.drawable.header)
                                        .addProfiles(ProfileDrawerItem().withName("Admin Admin")
                                                                        .withEmail("+380123456789")).build()
    }

    private fun initFields()
    {
        mToolBar = mBinding.mainToolBar
    }
}