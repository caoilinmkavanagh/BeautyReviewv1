package ie.wit.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import ie.wit.R
import ie.wit.main.ReviewApp
import ie.wit.models.ReviewModel
import kotlinx.android.synthetic.main.card_review.*
import kotlinx.android.synthetic.main.fragment_re.thename
import kotlinx.android.synthetic.main.fragment_re.view.*
import org.jetbrains.anko.toast


class ReFragment : Fragment(){

    //var review = ReviewModel()
    lateinit var app: ReviewApp
    var totalRed = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as ReviewApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_re, container, false)
        activity?.title = getString(R.string.action_re)

        root.progressBar.max = 5
        root.amountPicker.minValue = 1
        root.amountPicker.maxValue = 5

        root.amountPicker.setOnValueChangedListener { _, _, newVal ->
            //Display the newly selected number to paymentAmount
            root.ratingAmount.setText("$newVal")
        }
        setButtonListener(root)
        return root;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ReFragment().apply {
                arguments = Bundle().apply {}
            }
    }


    fun setButtonListener( layout: View) {
        layout.reButton.setOnClickListener {
            val amount = if (layout.ratingAmount.text.isNotEmpty())
                layout.ratingAmount.text.toString().toInt()
            else layout.amountPicker.value
            if(totalRed >= layout.progressBar.max)
                activity?.toast("Wow they must be great!")
            else {
                val ratingmethod = if(layout.ratingMethod.checkedRadioButtonId == R.id.Direct) "No Home Visit" else "Home Visits"
                totalRed += amount
                layout.totalSoFar.text = "$totalRed"
                layout.progressBar.progress = totalRed
                app.reviewsStore.create(ReviewModel(
                    ratingmethod = ratingmethod,
                    amount = amount))
            }
        }
    }
    //}
}