package com.veronica.idn.guessthewordlivedata.screen.game


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.veronica.idn.guessthewordlivedata.R
import com.veronica.idn.guessthewordlivedata.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private lateinit var viewModel: GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )
        Log.i("Game Fragment", "Called ViewModelProviders.of")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
            binding.tvWord.text = newWord
        })
        viewModel.score.observe(viewLifecycleOwner, Observer { newScore ->
            binding.tvScore.text = newScore.toString()
        })

        viewModel.eventGameFinish.observe(
            viewLifecycleOwner,
            Observer { hasFinished -> if (hasFinished) gameFinished() })
        binding.btnGotIt.setOnClickListener { viewModel.onCorrect() }
        binding.btnSkip.setOnClickListener { viewModel.onSkip() }
        binding.btnEndGame.setOnClickListener { gameFinished() }
        // Inflate the layout for this fragment
        return binding.root
    }


    private fun gameFinished() {
        Toast.makeText(activity, "Game has just finshed", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameFragmentToScoreFragment()
        action.score = viewModel.score.value ?: 0
        findNavController().navigate(action)
        viewModel.onGameFinishedComplete()
    }


}
