package com.app.managecontacts.contact.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepositoryImpl
import com.app.contact.usecase.AddContactUseCase
import com.app.contact.usecase.ContactsUseCase
import com.app.contactpresentation.AddContactViewModel
import com.app.local.contact.ContactDaoImpl
import com.app.local.contact.ContactLocalDataSource
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
        val contactLocalDataSource = ContactLocalDataSource(contactDao)
        val repository = ContactRepositoryImpl(contactLocalDataSource)
        val contactUseCase = AddContactUseCase(repository, entityMapper)
        addContactViewModel = AddContactViewModel(contactUseCase)

        addContactViewModel.addContact(ContactLocal("Ali", "1212121"))

        return addContactBinding.root
    }
}
