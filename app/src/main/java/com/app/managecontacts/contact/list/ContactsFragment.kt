package com.app.managecontacts.contact.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.app.contactpresentation.ContactViewModel
import com.app.contactpresentation.uimodel.ContactUi
import com.app.managecontacts.R
import com.app.managecontacts.databinding.FragmentContactsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactsFragment : Fragment() {

    private lateinit var contactsBinding: FragmentContactsBinding
    private val contactViewModel: ContactViewModel by viewModel()
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactsBinding = FragmentContactsBinding.inflate(inflater, container, false)

        setupRecyclerView()
        setupFab()

        // i don't prefer to use data binding just use view binding
        setupLoadingDataObserver()
        setupEmptyListObserver()

        setupGetAllContactsObserver()

        return contactsBinding.root
    }

    private fun setupEmptyListObserver() {
        contactViewModel.emptyList.observe(this, Observer {
            val visibleGone = if (it) View.VISIBLE else View.GONE
            contactsBinding.mainLayout.noContactsTextView.visibility = visibleGone
        })
    }

    private fun setupLoadingDataObserver() {
        contactViewModel.dataLoading.observe(this, Observer {
            val visibleGone = if (it) View.VISIBLE else View.GONE
            contactsBinding.mainLayout.progressBar.visibility = visibleGone
        })
    }

    private fun setupGetAllContactsObserver() {
        contactViewModel.contacts.observe(this, Observer {
            contactAdapter.swapData(it)
        })
    }

    private fun setupFab() {
        contactsBinding.fab.setOnClickListener {
            val addContactAction =
                ContactsFragmentDirections.actionContactsFragmentToAddContactFragment()
            findNavController().navigate(addContactAction)
        }
    }

    private fun setupRecyclerView() {
        contactAdapter = ContactAdapter()
        contactsBinding.mainLayout.recyclerView.adapter = contactAdapter
        contactsBinding.mainLayout.recyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        contactAdapter.setOnItemClickListener(object :
            ContactAdapter.OnItemClickListener {
            override fun onClick(
                view: View,
                contact: ContactUi,
                position: Int
            ) {
                when (view.id) {
                    R.id.rootLayout -> openContactDetails(contact)
                    R.id.callImageView -> call(contact.mobile)
                    R.id.deleteImageView -> deleteContact(contact, position)
                }
            }
        })
    }

    private fun call(mobile: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$mobile")
        startActivity(intent)
    }

    private fun deleteContact(contact: ContactUi, position: Int) {
        contactAdapter.removeItem(position)
        contactViewModel.deleteContact(contact.mobile)
    }

    private fun openContactDetails(contact: ContactUi) {
        val contactDetailsAction =
            ContactsFragmentDirections.actionContactsFragmentToContactDetailsFragment(
                contact.name,
                contact.mobile
            )
        findNavController().navigate(contactDetailsAction)
    }
}
