package com.example.myapplication.saathi

import com.example.myapplication.saathi.adapter.RvContactsAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.myapplication.saathi.adapter.RvContactsAdapter
import com.example.myapplication.saathi.databinding.FragmentHomeBinding
import com.example.myapplication.saathi.models.Contacts
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var contactsList: ArrayList<Contacts>
    private lateinit var firebaseRef : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater , container , false)

        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
        firebaseRef = FirebaseDatabase.getInstance().getReference("contacts")
        contactsList = arrayListOf()

        fetchData()

        binding.rvContacts.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
        }

        return binding.root
    }

    private fun fetchData() {
        firebaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                contactsList.clear()
                if(snapshot.exists()){
                    for(contactSnap in snapshot.children){
                        val contacts = contactSnap.getValue(Contacts ::class.java)
                        contactsList.add(contacts!!)
                    }
                }
                val rvAdapter = RvContactsAdapter(contactsList)
                binding.rvContacts.adapter = rvAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"error : $error",Toast.LENGTH_SHORT).show()
            }

        })
    }

}