package com.veronica.idn.androidtrivianavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.veronica.idn.androidtrivianavigation.databinding.FragmentWonBinding

/**
 * A simple [Fragment] subclass.
 */
class WonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentWonBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_won, container, false)
        binding.btnNextMatch.setOnClickListener {
            view:View -> view.findNavController().navigate(R.id.action_wonFragment_to_gameFragment)
        }
        return binding.root
    }


}
