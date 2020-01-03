package com.app.managecontacts.contact.add

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepositoryImpl
import com.app.contact.usecase.ContactUseCase
import com.app.contactpresentation.AddContactViewModel
import com.app.contactpresentation.ContactViewModel
import com.app.contactpresentation.mapper.UiContactMapper
import com.app.local.contact.ContactDaoImpl

import com.app.managecontacts.R
import com.app.managecontacts.databinding.AddContactFragmentBinding
import com.app.models.local.ContactLocal
import io.realm.Realm

class AddContactFragment : Fragment() {

    lateinit var addContactBinding: AddContactFragmentBinding

    private lateinit var addContactViewModel: AddContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addContactBinding = AddContactFragmentBinding.inflate(inflater, container, false)

        val entityMapper = EntityContactMapper()
        val contactDao = ContactDaoImpl(Realm.getDefaultInstance())
        val repository = ContactRepositoryImpl(contactDao)
        val contactUseCase = ContactUseCase(repository, entityMapper)
        addContactViewModel = AddContactViewModel(contactUseCase)

        addContactViewModel.addContact(ContactLocal("Ali", "1212121"))

        return addContactBinding.root
    }
}
