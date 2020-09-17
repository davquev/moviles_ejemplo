package com.example.apprecyclervmo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_contact.view.*

class ContactAdapter(var contacts: ArrayList<Contact>): RecyclerView.Adapter<ContactPrototype>() {
    //crear el prototipe (ViewHolder) para cada elemento/fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_contact, parent, false)

        return  ContactPrototype(view)
    }

    //tamaño
    override fun getItemCount(): Int {
        return contacts.size
    }

    //Conecta la información con la vista
    override fun onBindViewHolder(contactPrototype: ContactPrototype, position: Int) {
        contactPrototype.bind(contacts.get(position))
    }
}

class ContactPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.tvName
    val tvTelephone = itemView.tvTelephone

    fun bind(contact: Contact){
        tvName.text = contact.name
        tvTelephone.text = contact.telephone
    }
}