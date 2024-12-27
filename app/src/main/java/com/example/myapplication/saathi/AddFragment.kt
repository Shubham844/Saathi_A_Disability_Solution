package com.example.myapplication.saathi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.saathi.databinding.FragmentAddBinding
import com.example.myapplication.saathi.models.Contacts
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var firebaseRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        firebaseRef = FirebaseDatabase.getInstance().getReference("contacts")

        binding.btnSend.setOnClickListener {
            saveData()
        }

        return binding.root
    }

    private fun saveData() {
        val name = binding.edtName.text.toString()
        val review = binding.edtPhone.text.toString()
        val fullName = binding.edtFullName.text.toString()

        if (name.isEmpty()) binding.edtName.error = "write a place"
        if (review.isEmpty()) binding.edtPhone.error = "write a review"
        if (fullName.isEmpty()) binding.edtFullName.error = "write your Name"

        val contactId = firebaseRef.push().key!!
        val contacts = Contacts(contactId, name, review, fullName)

        firebaseRef.child(contactId).setValue(contacts)
            .addOnCompleteListener {
                Toast.makeText(context, "Review is stored successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
