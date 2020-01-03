package com.app.managecontacts.contact.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.managecontacts.databinding.ContactDetailsFragmentBinding

class ContactDetailsFragment : Fragment() {

    private lateinit var mobile: String
    private lateinit var name: String
    lateinit var contactDetailsBinding: ContactDetailsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val contactDetailsArgs = ContactDetailsFragmentArgs.fromBundle(it)
            name = contactDetailsArgs.name
            mobile = contactDetailsArgs.mobile
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactDetailsBinding =
            ContactDetailsFragmentBinding.inflate(inflater, container, false)

        contactDetailsBinding.nameTextView.text = name
        contactDetailsBinding.mobileTextView.text = mobile

        return contactDetailsBinding.root
    }
}
