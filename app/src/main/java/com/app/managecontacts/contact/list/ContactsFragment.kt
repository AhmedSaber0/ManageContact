package com.app.managecontacts.contact.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepositoryImpl
import com.app.contact.usecase.ContactUseCase
import com.app.contactpresentation.ContactViewModel
import com.app.contactpresentation.mapper.UiContactMapper
import com.app.contactpresentation.uimodel.ContactUi
import com.app.local.contact.ContactDaoImpl
import com.app.managecontacts.databinding.FragmentContactsBinding
import io.realm.Realm

class ContactsFragment : Fragment() {

    lateinit var contactsBinding: FragmentContactsBinding
    lateinit var contactViewModel: ContactViewModel
    lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactsBinding = FragmentContactsBinding.inflate(inflater, container, false)

        setupRecyclerView()
        val uiMapper = UiContactMapper()
        val entityMapper = EntityContactMapper()
        val contactDao = ContactDaoImpl(Realm.getDefaultInstance())
        val repository = ContactRepositoryImpl(contactDao)
        val contactUseCase = ContactUseCase(repository, entityMapper)
        contactViewModel = ContactViewModel(contactUseCase, uiMapper)

        contactViewModel.getAllContacts().observe(this, Observer {
            contactAdapter.swapData(it)
        })

        contactsBinding.fab.setOnClickListener {
            val addContactAction =
                ContactsFragmentDirections.actionContactsFragmentToAddContactFragment()
            findNavController().navigate(addContactAction)
        }
        return contactsBinding.root
    }


    private fun setupRecyclerView() {
        contactAdapter = ContactAdapter()
        contactsBinding.mainLayout.recyclerView.adapter = contactAdapter
        contactAdapter.setOnItemClickListener(object : ContactAdapter.OnItemClickListener {
            override fun onClick(view: View, contact: ContactUi) {
                val contactDetailsAction =
                    ContactsFragmentDirections.actionContactsFragmentToContactDetailsFragment(
                        contact.name,
                        contact.mobile
                    )
                findNavController().navigate(contactDetailsAction)
            }

        })
    }
}
