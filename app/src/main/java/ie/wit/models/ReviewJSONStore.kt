package ie.wit.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.AnkoLogger
import ie.wit.helpers.*
import java.util.*

val JSON_FILE = "reviews.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<ReviewModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class ReviewJSONStore : ReviewStore, AnkoLogger {

    val context: Context
    var reviews = mutableListOf<ReviewModel>()

    constructor (context: Context) {
        this.context = context
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<ReviewModel> {
        return reviews
    }

    override fun findById(id: Long): ReviewModel? {
        TODO("Not yet implemented")
    }

    override fun create(review: ReviewModel) {
        review.id = generateRandomId()
        reviews.add(review)
        serialize()
    }
    
    /*  override fun create(review: ReviewModel) {
          review.id = generateRandomId()
          reviews.add(review)
          serialize()
      }*/

    override fun delete(review: ReviewModel) {
        reviews.remove(review)
        serialize()
    }


    override fun update(review: ReviewModel) {
        val reviewsList = findAll() as ArrayList<ReviewModel>
        var foundReview: ReviewModel? = reviewsList.find { p -> p.id == review.id }
        if (foundReview != null) {
            foundReview.name = review.name
            foundReview.location = review.location
            foundReview.service = review.service
            foundReview.amount = review.amount
            foundReview.id = review.id
            foundReview.ratingmethod = review.ratingmethod
           // foundReview.price = review.price

        }
        serialize()
    }
    

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(reviews, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        reviews = Gson().fromJson(jsonString, listType)
    }
}
