package com.example.myapplication.saathi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [donation.newInstance] factory method to
 * create an instance of this fragment.
 */
class donation : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: DonationAdapter
    private  lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<Donation_model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donation, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment donation.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            donation().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataint()
        val layoutManager = LinearLayoutManager(context)

        recyclerView = view.findViewById(R.id.rec2)

        // this creates a vertical layout Manager
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = DonationAdapter(arrayList)
        recyclerView.adapter=adapter

    }
    private  fun dataint(){
        arrayList = arrayListOf<Donation_model>()
        arrayList.add(Donation_model(R.drawable.a,"Samarthanam","Samarthanam,one of the biggest NGOs in India, works for the empowerment of persons with disabilities and the underserved through its diverse initiatives focused on providing quality education, accommodation, nutritious food, vocational training and placement based rehabilitation. It facilitates opportunities to enable persons with disabilities and the underserved to keep pace with the rest of the society", url = "https://samarthanam.org/"))
        arrayList.add(Donation_model(R.drawable.b,"Diya Foundation","Diya Foundation (DIYA) is a Vocational Training Center providing education in life skills and employability skills to differently abled adults. Founded in 1999, DIYA is a registered charitable Trust. The need was for vocational training once basic schooling was completed thus preparing a potential workforce that has so far been greatly ignored.", url = "https://www.diyafoundation-india.org/"))
        arrayList.add(Donation_model(R.drawable.c,"Narayan Seva Sansthan","Narayan Seva Sansthan’ is a non-governmental and non-profit organization based in Udaipur (Rajasthan). It has more than 480 branches across the country. Over the past several years, the institute has changed people's lives in every dimension. it works to improve the lives of deaf and mute and destitute children by providing them free education and food. Along with this, the institute works for the skill development of the disabled and blind so that like other people, these people can also move ahead in life.", url = "https://www.narayanseva.org/"))
        arrayList.add(Donation_model(R.drawable.d,"Cheshire Disability Trust","Cheshire Disability Trust (CDT) is a member of the Leonard Cheshire Disability Global Alliance, a worldwide organization striving to better the lives of Persons with Disabilities (PWDs) through economic independence and self-reliance. From the time of its inception, CDT has impacted the lives of over 3,807 people by helping them earn a living and reintegrating them into society. To achieve this, CDT focuses on employability training and placement for PWDs aged 19 to 35", url = "cheshiredisability.org"))
        arrayList.add(Donation_model(R.drawable.e,"Care Foundation Trust","Care Foundation Trust is a non-profit organisation committed to promoting compassion and empathy. Our goal is to address critical social issues and implement sustainable solutions, focusing on uplifting underprivileged and marginalised communities.", url = "https://www.carefoundationtrust.org/"))

    }
}