package com.ebookfrenzy.contactsproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ebookfrenzy.contactsproject.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.contactsproject.Contact
import androidx.fragment.app.viewModels
import com.ebookfrenzy.contactsproject.databinding.MainFragmentBinding
import android.util.Log
import java.lang.Integer.parseInt


class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null
    private val LOG_TAG = "Contacts"

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun clearFields() {
        //binding.contactID.text = ""
        binding.contactName.setText("")
        binding.contactQuantity.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val quantity = binding.contactQuantity.text.toString()
            if (name != "" && quantity != "") {
                val product = Contact(name, Integer.parseInt(quantity))
                viewModel.insertContact(product)
                clearFields()
            } else {
                //binding.contactID.text = "Incomplete information"
                Toast.makeText(activity?.applicationContext, "Enter a Name and Phone Number", Toast.LENGTH_SHORT).show()


            }
        }
        binding.findButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val quantity = binding.contactQuantity.text.toString()
            if (name != "") {
                viewModel.findContact(
                    binding.contactName.text.toString()
                )
            } else {
                Toast.makeText(activity?.applicationContext, "Enter Search Criteria", Toast.LENGTH_SHORT).show()
            }

        }

        binding.ascButton.setOnClickListener {
            var contacts = viewModel.getAllContacts()?.value
            adapter?.ascSort(contacts)

        }

        binding.descButton.setOnClickListener {
            var contacts = viewModel.getAllContacts()?.value
            adapter?.descSort(contacts)
        }

        /*binding.deleteButton.setOnClickListener {
            viewModel.deleteContact(binding.contactName.text.toString())
            clearFields()
        }*/
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(this, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    //binding.contactID.text = String.format(Locale.US, "%d", it[0].contactId)
                    //binding.contactName.setText(it[0].contactName)
                    //binding.contactQuantity.setText(String.format(Locale.US, "%d", it[0].quantity))
                    adapter?.setContactList(it)
                } else {
                    //binding.contactID.text = "No Match"
                    Toast.makeText(activity?.applicationContext, "No Match", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.OnTextClickListener{
            override fun onTextClick(id: String) {
                var contactId: Int = parseInt(id)
                viewModel.deleteContact(contactId)

            }
        })

    }





}