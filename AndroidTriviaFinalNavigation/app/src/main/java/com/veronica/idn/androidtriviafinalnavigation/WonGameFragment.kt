package com.veronica.idn.androidtriviafinalnavigation


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.veronica.idn.androidtriviafinalnavigation.databinding.FragmentWonGameBinding

/**
 * A simple [Fragment] subclass.
 */
class WonGameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWonGameBinding = DataBindingUtil.inflate(
            inflater,
            R.id.action_wonGameFragment_to_gameFragment,
            container,
            false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

//    private fun getShareIntent(): Intent{
//        return
//    }


}
