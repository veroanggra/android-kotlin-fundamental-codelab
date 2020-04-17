package com.veronica.idn.androidtriviafinalnavigation


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
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
            R.layout.fragment_won_game,
            container,
            false
        )
        binding.btnNextMatch.setOnClickListener {
            view:View -> view.findNavController().navigate(WonGameFragmentDirections.actionWonGameFragmentToGameFragment())
        }

        val args = WonGameFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context,"NumCorrect: ${args.numCorrect}, NumQuestions: ${args.numQuestions}", Toast.LENGTH_LONG).show()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun getShareIntent(): Intent{
        val args = WonGameFragmentArgs.fromBundle(arguments!!)
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
        return intent
    }

    private fun shareSuccess(){
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        if (null == getShareIntent().resolveActivity(activity!!.packageManager))
            menu.findItem(R.id.action_share)?.setVisible(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)

    }


}
