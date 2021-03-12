package ie.wit.models;

interface ReviewStore {
    fun findAll() : List<ReviewModel>
    fun findById(id: Long) : ReviewModel?
    fun create(review: ReviewModel)
    fun update(review: ReviewModel)
    fun delete(review: ReviewModel)
}