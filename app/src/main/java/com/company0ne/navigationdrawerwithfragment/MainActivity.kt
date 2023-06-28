package com.company0ne.navigationdrawerwithfragment


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            //now i want to highLight the particular item that is clicked
            it.isChecked =true

            when (it.itemId) {

                R.id.nav_home -> replaceFragment(HomeFragment(),it.title.toString())

                R.id.nav_message ->  replaceFragment(MessageFragment(),it.title.toString())

                R.id.nav_sync -> replaceFragment(SyncFragment(),it.title.toString())

                R.id.nav_trash -> replaceFragment(TrashFragment(),it.title.toString())

                R.id.nav_settings ->  replaceFragment(SettingsFragment(),it.title.toString())

                R.id.nav_login ->  replaceFragment(LoginFragment(),it.title.toString())

                R.id.nav_share ->  replaceFragment(ShareFragment(),it.title.toString())

                R.id.nav_rate_us ->  replaceFragment(RateUsFragment(),it.title.toString())
            }
            true
        }
    }
    //when user tab the any icons the fragment will open.So, we create an Method
    private fun replaceFragment(fragment : Fragment, title: String)
    {
        //get reference from the FragmentManager
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        //whenEver user click on the drawer the drawer is closed
        drawerLayout.closeDrawers()
        setTitle(title)

    }

    //override method
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}