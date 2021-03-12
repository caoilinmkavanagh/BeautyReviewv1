package ie.wit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.R
import ie.wit.models.ReviewModel
import kotlinx.android.synthetic.main.card_review.view.*

class ReviewAdapter constructor(private var reviews: List<ReviewModel>)
    : RecyclerView.Adapter<ReviewAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_review,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val review = reviews[holder.adapterPosition]
        holder.bind(review)
    }

    override fun getItemCount(): Int = reviews.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(review: ReviewModel) {
            //itemView.reviewLocation.text = review.location.toString()
            //itemView.reviewService.text = review.service
            itemView.ratingamount.text = review.amount2.toString()
            itemView.ratingamount.text = review.amount.toString()
            itemView.ratingmethod.text = review.ratingmethod
            //itemView.reviewService = review.service.toString()

            itemView.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
        }
    }
}