package com.veronica.idn.guesstheword.screen.score


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.veronica.idn.guesstheword.R
import com.veronica.idn.guesstheword.databinding.FragmentScoreBinding

/**
 * A simple [Fragment] subclass.
 */
class ScoreFragment : Fragment() {
    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentScoreBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)
        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).score)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ScoreViewModel::class.java)
        binding.tvScoreValue.text = viewModel.score.toString()
        return binding.root
    }


}
