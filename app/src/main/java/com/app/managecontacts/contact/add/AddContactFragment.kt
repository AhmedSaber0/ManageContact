package com.app.managecontacts.contact.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.app.contactpresentation.AddContactViewModel
import com.app.managecontacts.R
import com.app.managecontacts.databinding.AddContactFragmentBinding
import com.app.models.local.ContactLocal
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddContactFragment : Fragment() {

    lateinit var addContactBinding: AddContactFragmentBinding

    private val addContactViewModel: AddContactViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addContactBinding = AddContactFragmentBinding.inflate(inflater, container, false)

        setupAddNewContactObserver()

        return addContactBinding.root
    }

    private fun setupAddNewContactObserver() {
        addContactViewModel.addContactErrorVisible.observe(this, Observer {
            if (it) openContactsFragment() else showErrorDuplicateRecord()
        })
    }

    private fun showErrorDuplicateRecord() {
        addContactBinding.mobileEditText.error = getString(R.string.dublicate_entry_error)
    }

    private fun openContactsFragment() {
        val contactsAction =
            AddContactFragmentDirections.actionAddContactFragmentToContactsFragment()
        findNavController().navigate(contactsAction)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_contact -> {
                addNewContactClick()
                true
            }
            else -> false
        }
    }

    private fun addNewContactClick() {
        val name = addContactBinding.nameEditText.text.toString()
        val mobile = addContactBinding.mobileEditText.text.toString()
        if (isValidParams(name, mobile))
            addContactViewModel.addContact(ContactLocal(name, mobile))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_contact_menu, menu)
    }

    private fun isValidParams(name: String, mobile: String): Boolean {
        if (name.isEmpty()) {
            addContactBinding.nameEditText.error = getString(R.string.required_field)
            return false
        }
        if (mobile.isEmpty()) {
            addContactBinding.mobileEditText.error = getString(R.string.required_field)
            return false
        }
        return true
    }

}
