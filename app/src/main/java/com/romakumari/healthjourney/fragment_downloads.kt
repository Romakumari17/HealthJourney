package com.romakumari.healthjourney


import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.romakumari.healthjourney.databinding.FragmentDownloadsBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_downloads.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_downloads :Fragment() {
     lateinit var mainActivity: MainActivity
     lateinit var binding: FragmentDownloadsBinding
     var type = 0
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         mainActivity= activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            type = it.getInt("type", 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDownloadsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.video1.setOnClickListener {
            val url = "C:\\Users\\Roma\\OneDrive\\Documents\\yoga app v1.jpg"
            val fragment = fragment_mediaplayer()
            val args = Bundle()
            args.putString("url", url) // Put any data you want to pass here
            fragment.arguments=args
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.nav_Host, fragment).commit()
            args.putInt("type", 0)
            findNavController().navigate(R.id.action_fragment_downloads2_to_fragment_mediaplayer, args)
        }
        binding.video2.setOnClickListener {
            val url = "C:\\Users\\Roma\\OneDrive\\Documents\\yoga app v2.mp4"
            val fragment = fragment_mediaplayer()
            val args = Bundle()
            args.putString("url", url) // Put any data you want to pass here
            fragment.arguments=args
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.nav_Host, fragment).commit()
            args.putInt("type", 1)
            findNavController().navigate(R.id.action_fragment_downloads2_to_fragment_mediaplayer, args)
         }
    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_downloads.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_downloads().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

