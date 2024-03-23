package com.romakumari.healthjourney


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.romakumari.healthjourney.databinding.FragmentMediaplayerBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_mediaplayer.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_mediaplayer : Fragment() {
    lateinit var binding: FragmentMediaplayerBinding
    lateinit var player:ExoPlayer
    lateinit var mainActivity: MainActivity

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
        binding = FragmentMediaplayerBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = this.arguments
        val url1 = args?.getString("url")
        binding.textUrl.text = url1
        ExoPlayerplay()
        val mediaItem =MediaItem.fromUri(Uri.parse("android.resource://"+mainActivity.packageName+"/"+R.raw.yoga))
        player.setMediaItem(mediaItem)
        //second video
        val args1 = this.arguments
        val url2 = args1?.getString("url")
        binding.textUrl.text = url2
        val mediaItem2 =MediaItem.fromUri(Uri.parse("android.resource://"+mainActivity.packageName+"/"+R.raw.yoga))
        player.setMediaItem(mediaItem2)

        }
     fun ExoPlayerplay(){
         player = ExoPlayer.Builder(requireContext()).build()
         binding.playerview.player = player
         player.prepare()
         player.play()
     }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_mediaplayer.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_mediaplayer().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onStart() {
        super.onStart()
        player.playWhenReady=true
    }

    override fun onStop() {
        super.onStop()
        player.playWhenReady=false
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}