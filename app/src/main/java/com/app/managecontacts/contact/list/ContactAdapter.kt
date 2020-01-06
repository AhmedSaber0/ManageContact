package com.app.managecontacts.contact.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.contactpresentation.uimodel.ContactUi
import com.app.managecontacts.R
import kotlinx.android.synthetic.main.contact_row.view.*

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private lateinit var contacts: MutableList<ContactUi>
    lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        setOnItemClickListener(listener)
        return ContactViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.contact_row,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount() = if (::contacts.isInitialized) contacts.size else 0

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) =
        holder.bind(contacts[position], listener, position)

    fun removeItem(position: Int) {
        contacts.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, contacts.size)
    }

    fun swapData(data: List<ContactUi>) {
        if (data.isNotEmpty()) {
            this.contacts = data as MutableList<ContactUi>
            notifyDataSetChanged()
        }
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: ContactUi,
            listener: OnItemClickListener,
            position: Int
        ) {
            with(itemView) {
                nameTextView.text = item.name
                mobileTextView.text = item.mobile
                contactIconImageView.text = item.name[0].toString()
                callImageView.setOnClickListener {
                    click(listener, it, item, position)
                }
                deleteImageView.setOnClickListener {
                    click(listener, it, item, position)
                }
                rootLayout.setOnClickListener {
                    click(listener, it, item, position)
                }
            }
        }

        private fun click(
            listener: OnItemClickListener,
            it: View,
            item: ContactUi,
            position: Int
        ) {
            listener.onClick(
                it,
                item,
                position
            )
        }
    }

    interface OnItemClickListener {
        fun onClick(
            view: View,
            contact: ContactUi,
            position: Int
        )
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


}