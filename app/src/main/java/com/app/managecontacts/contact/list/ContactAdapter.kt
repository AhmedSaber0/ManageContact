package com.app.managecontacts.contact.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.contactpresentation.uimodel.ContactUi
import com.app.managecontacts.R
import kotlinx.android.synthetic.main.contact_row.view.*
import java.util.*

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private var data: List<ContactUi> = ArrayList()
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

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) =
        holder.bind(data[position], listener)

    fun swapData(data: List<ContactUi>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ContactViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(item: ContactUi, listener: OnItemClickListener) = with(itemView) {
            nameTextView.text = item.name
            mobileTextView.text = item.mobile
            setOnClickListener {
                listener.onClick(
                    it,
                    item
                )
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(
            view: View,
            contact: ContactUi
        )
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


}