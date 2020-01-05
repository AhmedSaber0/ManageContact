package com.app.managecontacts.contact.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepositoryImpl
import com.app.contact.usecase.AddContactUseCase
import com.app.contactpresentation.AddContactViewModel
import com.app.local.contact.ContactDaoImpl
import com.app.local.contact.ContactLocalDataSource
import com.app.managecontacts.R
import com.app.managecontacts.databinding.AddContactFragmentBinding
import com.app.models.local.ContactLocal
import io.realm.Realm

class AddContactFragment : Fragment() {

    lateinit var addContactBinding: AddContactFragmentBinding

    private lateinit var addContactViewModel: AddContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addContactBinding = AddContactFragmentBinding.inflate(inflater, container, false)

        setupDependency()
        setupAddNewContactObserver()

        return addContactBinding.root
    }

    private fun setupAddNewContactObserver() {
        addContactViewModel.newContactEvent.observe(this, Observer {
            val contactsAction =
                AddContactFragmentDirections.actionAddContactFragmentToContactsFragment()
            findNavController().navigate(contactsAction)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_contact -> {
                val name = addContactBinding.nameEditText.text.toString()
                val mobile = addContactBinding.mobileEditText.text.toString()
                addContactViewModel.addContact(ContactLocal(name, mobile))
                true
            }
            else -> false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_contact_menu, menu)
    }

    private fun setupDependency() {
        val entityMapper = EntityContactMapper()
        val contactDao = ContactDaoImpl(Realm.getDefaultInstance())
        val contactLocalDataSource = ContactLocalDataSource(contactDao)
        val repository = ContactRepositoryImpl(contactLocalDataSource)
        val contactUseCase = AddContactUseCase(repository, entityMapper)
        addContactViewModel = AddContactViewModel(contactUseCase)
    }
}
