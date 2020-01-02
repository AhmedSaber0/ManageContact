package com.app.managecontacts.contact

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.app.contact.mapper.ContactMapper
import com.app.contact.repository.ContactRepository
import com.app.contact.usecase.ContactUseCase
import com.app.contactpresentation.ContactViewModel
import com.app.local.ContactDaoImpl
import com.app.managecontacts.R
import com.app.managecontacts.base.BaseActivity
import com.app.managecontacts.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class ContactsActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var contactViewModel: ContactViewModel
    lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        setupRecyclerView()
        val uiMapper = com.app.contactpresentation.mapper.ContactMapper()
        val entityMapper = ContactMapper()
        val contactDao = ContactDaoImpl(Realm.getDefaultInstance())
        val repository = ContactRepository(contactDao)
        val contactUseCase = ContactUseCase(repository, entityMapper)
        contactViewModel = ContactViewModel(contactUseCase, uiMapper)


//        contactViewModel.addContact(ContactLocal("Ahmed", "0101645151"))
        contactViewModel.getAllContacts().observe(this, Observer {
            contactAdapter.swapData(it)
        })

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setupRecyclerView() {
        contactAdapter = ContactAdapter()
        mViewDataBinding.mainLayout.recyclerView.adapter = contactAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
