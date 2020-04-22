package com.veronica.idn.guesstheword.screen.title


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.veronica.idn.guesstheword.R
import com.veronica.idn.guesstheword.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTitleBinding =
            DataBindingUtil.inflate(inflater,
                R.layout.fragment_title, container, false)
        binding.btnPlay.setOnClickListener {
            findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }
        return binding.root
    }


}
