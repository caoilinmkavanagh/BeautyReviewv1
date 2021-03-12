/*
package ie.wit.main

import android.app.Application
import android.util.Log
import ie.wit.models.ReviewMemStore
import ie.wit.models.ReviewStore

class ReviewApp : Application() {

    lateinit var reviewsStore: ReviewStore

    override fun onCreate() {
        super.onCreate()
        reviewsStore = ReviewMemStore()
        Log.v("Donate","Review App started")
    }
}*/
package ie.wit.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import ie.wit.models.ReviewJSONStore
import ie.wit.models.ReviewMemStore
import ie.wit.models.ReviewStore

class ReviewApp : Application(), AnkoLogger {

    lateinit var reviewsStore: ReviewStore

    override fun onCreate() {
        super.onCreate()
        reviewsStore = ReviewJSONStore(applicationContext)
        info("Review started")
    }
}