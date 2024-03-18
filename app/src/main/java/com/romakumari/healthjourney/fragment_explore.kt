package com.romakumari.healthjourney

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.romakumari.healthjourney.databinding.FragmentExploreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_explore.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_explore : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    private lateinit var mainActivity: MainActivity
    private lateinit var searchList: MutableList<String>


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivity = activity as MainActivity

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
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchlist = arrayListOf(
            "Adho Mukha Svanasana (Downward-Facing Dog)",
            "Balasana (Child's Pose)",
            "Baddha Konasana (Bound Angle Pose)",
            "Cow Face Pose (Gomukhasana)",
            " Crescent Moon Pose (Anjaneyasana)",
            "Downward-Facing Dog (Adho Mukha Svanasana)",
            "Extended Hand-to-Big-Toe Pose (Utthita Hasta Padangusthasana)",
            "Extended Side Angle Pose (Utthita Parsvakonasana)",
            "Gomukhasana (Cow Face Pose)",
            "Half Lord of the Fishes Pose (Ardha Matsyendrasana)",
            "Janu Sirsasana (Head-to-Knee Pose)",
            "King Pigeon Pose (Eka Pada Rajakapotasana)",
            "Lord of the Dance Pose (Natarajasana)",
            "Mountain Pose (Tadasana)",
            "Navasana (Boat Pose)",
            "Paschimottanasana (Seated Forward Bend)",
            "Reclining Hero Pose (Supta Virasana)",
            "Salamba Sarvangasana (Supported Shoulderstand)",
            "Sarpasana (Snake Pose)",
            "Supta Virasana (Reclining Hero Pose)",
            "Tadasana (Mountain Pose)",
            "Utthita Parsvakonasana (Extended Side Angle Pose)",
            "Virasana (Hero Pose)",
            "Wide-Legged Standing Forward Bend (Prasarita Padottanasana)",
        )
        val searchadapter: ArrayAdapter<String> = ArrayAdapter(
            mainActivity, android.R.layout.simple_list_item_1,
            searchlist

        )
        binding.recyclerView.adapter = searchadapter


        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.search.clearFocus()
                if (searchlist.contains(query)) {
                    searchadapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchadapter.filter.filter(newText)
                return false
            }

        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_explore.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_explore().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}



