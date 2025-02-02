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
 * Use the [gallery.newInstance] factory method to
 * create an instance of this fragment.
 */
class gallery : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: galleryadapter
    private  lateinit var recyclerView: RecyclerView
    private lateinit var arrayList: ArrayList<gallery_model>

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
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment gallery.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            gallery().apply {
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

        recyclerView = view.findViewById(R.id.idGVcourses)

        // this creates a vertical layout Manager
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = galleryadapter(arrayList)
        recyclerView.adapter=adapter

    }
    private  fun dataint(){
        arrayList = arrayListOf<gallery_model>()
        arrayList.add(gallery_model(R.drawable.x,"Good actions give strength to ourselves and inspire good actions in others\n"))
        arrayList.add(gallery_model(R.drawable.y,"An effort made for the happiness of others lifts us above ourselves"))
        arrayList.add(gallery_model(R.drawable.z,"As one person I cannot change the world, but I can change the world of one person"))
        arrayList.add(gallery_model(R.drawable.xo,"The best way to find yourself is to lose yourself in the service of others"))
        arrayList.add(gallery_model(R.drawable.xv,"We have rescued little baby girls, dontions for their upbringing will be welcomed"))

    }
}