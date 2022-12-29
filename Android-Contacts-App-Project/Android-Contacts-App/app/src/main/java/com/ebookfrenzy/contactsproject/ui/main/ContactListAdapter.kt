package com.ebookfrenzy.contactsproject.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.contactsproject.Contact
import com.ebookfrenzy.contactsproject.R

class ContactListAdapter(private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null
    private val LOG_TAG = "Contacts"


    var listener: OnTextClickListener? = null

    fun settingListener(listener: OnTextClickListener?) {
        this.listener = listener
    }

    interface OnTextClickListener {
        fun onTextClick(str: String)
    }


    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val contact = holder.contactTextView
        val phone = holder.phoneNumberTextView
        val delB = holder.deleteView
        val contactId= holder.textView




        /*delB.setOnClickListener {
        var id = contactId.text.toString()
            listener?.onTextClick(id)
            Log.i(LOG_TAG, id)
        }*/


       // setupClickListener(delB, contactId.text.toString())


        contactList.let {
            contact.text = it!![listPosition].contactName
            phone.text = it!![listPosition].quantity.toString()
            contactId.text = it!![listPosition].contactId.toString()

            delB.setOnClickListener(View.OnClickListener {
                var id = contactId.text.toString()
                listener?.onTextClick(id)
            })



        }

    }
    /*fun setupClickListener(delB: ImageButton, id: String) {
        delB.setOnClickListener {
            listener?.onTextClick(id)
            Log.i(LOG_TAG, id)

        }
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.contact_list_item, parent, false)
        return ViewHolder(view)
    }
    //contactItemLayout


    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contactTextView: TextView = itemView.findViewById(R.id.contact_name)
        var phoneNumberTextView: TextView = itemView.findViewById(R.id.phone_number)
        var deleteView: ImageButton = itemView.findViewById(R.id.deleteButton)
        var textView: TextView = itemView.findViewById(R.id.textView5)

    }
    fun ascSort(contacts: List<Contact>?){
        contactList = contacts
        contactList = contactList?.sortedBy { it.contactName }
        notifyDataSetChanged()
    }
    fun descSort(contacts: List<Contact>?){
        contactList = contacts
        contactList = contactList?.sortedByDescending { it.contactName }
        notifyDataSetChanged()
    }


}