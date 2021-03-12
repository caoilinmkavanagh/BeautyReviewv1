package ie.wit.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import ie.wit.R
import ie.wit.adapters.ReviewAdapter
import ie.wit.main.ReviewApp
import ie.wit.models.ReviewModel
import kotlinx.android.synthetic.main.fragment_report.view.*

class ReportFragment : Fragment() {

    lateinit var app: ReviewApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as ReviewApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_report, container, false)

        root.recyclerView.setLayoutManager(LinearLayoutManager(activity))
        root.recyclerView.adapter = ReviewAdapter(app.reviewsStore.findAll())

        return root
    }
    
    companion object {
        @JvmStatic
        fun newInstance() =
            ReportFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}
