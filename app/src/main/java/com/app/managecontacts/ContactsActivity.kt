package com.app.managecontacts

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.app.managecontacts.base.BaseActivity
import com.app.managecontacts.databinding.ActivityContactsBinding
import kotlinx.android.synthetic.main.activity_contacts.*

class ContactsActivity : BaseActivity<ActivityContactsBinding>() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
        navController = findNavController(this, R.id.nav_host_fragment)
        setupActionBarWithNavController(this, navController)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_contacts
    }

    override fun onSupportNavigateUp() =
        findNavController(this, R.id.nav_host_fragment).navigateUp()

}
