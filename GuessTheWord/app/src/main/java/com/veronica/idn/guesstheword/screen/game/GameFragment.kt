package com.veronica.idn.guesstheword.screen.game


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.veronica.idn.guesstheword.R
import com.veronica.idn.guesstheword.databinding.FragmentGameBinding
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        Timber.i("Called ViewModelProviders.of")
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.btnGotIt.setOnClickListener { onCorrect() }
        binding.btnSkip.setOnClickListener { onSkip() }
        binding.btnEndGame.setOnClickListener { onEndGame() }
        updateScoreText()
        updateWordText()
        return binding.root
    }

    private fun updateWordText() {
        binding.tvWord.text = viewModel.word
    }

    private fun updateScoreText() {
        binding.tvScore.text = viewModel.score.toString()
    }

    private fun onEndGame() {
        gameFinished()
    }

    private fun gameFinished() {
        Toast.makeText(activity, "Game has finished", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameFragmentToScoreFragment()
        action.score = viewModel.score
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun onSkip() {
        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }

    private fun onCorrect() {
        viewModel.onCorrect()
        updateScoreText()
        updateWordText()
    }


}
