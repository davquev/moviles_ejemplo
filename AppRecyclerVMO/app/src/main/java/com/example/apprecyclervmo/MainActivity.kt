package com.example.apprecyclervmo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 1
    var contacts = ArrayList<Contact>()

    //creo el adapter
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()
    }

    private fun initView() {
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    fun loadContacts() {
        contacts.add(Contact("Luis Alberto", "999955568"))
        contacts.add(Contact("Mario Alberto", "999955567"))
        contacts.add(Contact("Larazo", "999955566"))
        contacts.add(Contact("Linconl", "999955565"))
        contacts.add(Contact("Lucas", "123456"))
        contacts.add(Contact("Sandro", "456789"))
    }

    //ctrl + o
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, ContactActivity::class.java)
        //startActivity(intent)
        startActivityForResult(intent, REQUEST_CODE)

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                val name = data!!.getStringExtra("KeyName")
                val telephone = data!!.getStringExtra("KeyTelephone")

                val contact = Contact(name, telephone)

                contacts.add(contact)
            }
        }
    }
}