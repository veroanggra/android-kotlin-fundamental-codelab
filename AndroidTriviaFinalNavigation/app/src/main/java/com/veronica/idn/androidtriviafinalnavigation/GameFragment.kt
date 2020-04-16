package com.veronica.idn.androidtriviafinalnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.veronica.idn.androidtriviafinalnavigation.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private val questions: MutableList<Questions> = mutableListOf(
        Questions(
            text = "What is Android Jetpack?",
            answers = listOf("All of these", "Tools", "Documentation", "Libraries")
        ),
        Questions(
            text = "What is the base class for layouts?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Questions(
            text = "What layout do you use for complex screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Questions(
            text = "What do you use to push structured data into a layout?",
            answers = listOf("Data binding", "Data pushing", "Set text", "An OnClick method")
        ),
        Questions(
            text = "What method do you use to inflate layouts in fragments?",
            answers = listOf(
                "onCreateView()",
                "onActivityCreated()",
                "onCreateLayout()",
                "onInflateLayout()"
            )
        ),
        Questions(
            text = "What's the build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Questions(
            text = "Which class do you use to create a vector drawable?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"
            )
        ),
        Questions(
            text = "Which one of these is an Android navigation component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Questions(
            text = "Which XML element lets you register an activity with the launcher activity?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Questions(
            text = "What do you use to mark a layout for data binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        )
    )

    lateinit var currentQuestions: Questions
    lateinit var answer: MutableList<String>
    private var questionsIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        randomizeQuiz()
        binding.game = this
        binding.btnSubmit.setOnClickListener { view: View ->
            val checkedId = binding.rgQuestion.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.rb_second_answer -> answerIndex = 1
                    R.id.rb_third_answer -> answerIndex = 2
                    R.id.rb_fourth_answer -> answerIndex = 3
                }
                if (answer[answerIndex] == currentQuestions.answers[0]) {
                    questionsIndex++

                    if (questionsIndex < numQuestions) {
                        currentQuestions = questions[questionsIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController()
                            .navigate(GameFragmentDirections.actionGameFragmentToWonGameFragment(numQuestions, questionsIndex))
                    }
                } else {
                    view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment())
                }
            }
        }
        return binding.root


    }

    private fun setQuestion() {
        currentQuestions = questions[questionsIndex]
        answer = currentQuestions.answers.toMutableList()
        answer.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_android_trivia_question, questionsIndex + 1, numQuestions)
    }

    private fun randomizeQuiz() {
        questions.shuffle()
        questionsIndex = 0
        setQuestion()
    }
}
