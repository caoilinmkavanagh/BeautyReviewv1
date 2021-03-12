package ie.wit.models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class ReviewMemStore : ReviewStore {

        val reviews = ArrayList<ReviewModel>()

        override fun findAll(): List<ReviewModel> {
            return reviews
        }

        override fun findById(id:Long) : ReviewModel? {
            val foundReview: ReviewModel? = reviews.find { it.id == id }
            return foundReview
        }

        override fun create(review: ReviewModel) {
            review.id = getId()
            reviews.add(review)
            logAll()
        }


    override fun update(review: ReviewModel) {
        var foundReview: ReviewModel? = reviews.find { p -> p.id == review.id }
        if (foundReview != null) {
            foundReview.name = review.name
            foundReview.location = review.location
            foundReview.service = review.service
            logAll()
        }
    }

    override fun delete(review: ReviewModel) {
        reviews.remove(review)
    }

    fun logAll() {
            Log.v("Donate","** Reviews List **")
            reviews.forEach { Log.v("Donate","${it}") }
        }
    }
