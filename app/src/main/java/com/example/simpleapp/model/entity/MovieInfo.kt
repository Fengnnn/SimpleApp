package com.example.simpleapp.model.entity


data class MovieInfo(val vote_count: String,
                     val id: String,
                     val vote_average: String,
                     val title: String,
                     val popularity: String,
                     val poster_path: String,
                     val original_language: String,
                     val original_title: String,
                     val genre_ids :List<Int>,
                     val backdrop_path:String,
                     val adult: Boolean,
                     val overview:String,
                     val release_date:String,
                     val video:Boolean

)
/**
class MovieInfo {
    @SerializedName("vote_count")
    @Expose
    private var voteCount: String? = null
    @SerializedName("id")
    @Expose
    private var id: String? = null
    @SerializedName("vote_average")
    @Expose
    private var voteAverage: String? = null
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("popularity")
    @Expose
    private var popularity: String? = null
    @SerializedName("poster_path")
    @Expose
    private lateinit var posterPath: String
    @SerializedName("original_language")
    @Expose
    private var originalLanguage: String? = null
    @SerializedName("original_title")
    @Expose
    private var originalTitle: String? = null
    @SerializedName("genre_ids")
    @Expose
    private var genreIds: List<String>? = null
    @SerializedName("backdrop_path")
    @Expose
    private var backdropPath: String? = null
    @SerializedName("adult")
    @Expose
    private var adult: Boolean? = null
    @SerializedName("overview")
    @Expose
    private var overview: String? = null
    @SerializedName("release_date")
    @Expose
    private var releaseDate: String? = null
    @SerializedName("video")
    @Expose
    private var video: Boolean? = null

    fun getVoteCount(): String? {
        return voteCount
    }

    fun setVoteCount(voteCount: String) {
        this.voteCount = voteCount
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getVoteAverage(): String? {
        return voteAverage
    }

    fun setVoteAverage(voteAverage: String) {
        this.voteAverage = voteAverage
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getPopularity(): String? {
        return popularity
    }

    fun setPopularity(popularity: String) {
        this.popularity = popularity
    }

    fun getPosterPath(): String {
        return posterPath
    }

    fun setPosterPath(posterPath: String) {
        this.posterPath = posterPath
    }

    fun getOriginalLanguage(): String? {
        return originalLanguage
    }

    fun setOriginalLanguage(originalLanguage: String) {
        this.originalLanguage = originalLanguage
    }

    fun getOriginalTitle(): String? {
        return originalTitle
    }

    fun setOriginalTitle(originalTitle: String) {
        this.originalTitle = originalTitle
    }

    fun getGenreIds(): List<String>? {
        return genreIds
    }

    fun setGenreIds(genreIds: List<String>) {
        this.genreIds = genreIds
    }

    fun getBackdropPath(): String? {
        return backdropPath
    }

    fun setBackdropPath(backdropPath: String) {
        this.backdropPath = backdropPath
    }

    fun getAdult(): Boolean? {
        return adult
    }

    fun setAdult(adult: Boolean?) {
        this.adult = adult
    }

    fun getOverview(): String? {
        return overview
    }

    fun setOverview(overview: String) {
        this.overview = overview
    }

    fun getReleaseDate(): String? {
        return releaseDate
    }

    fun setReleaseDate(releaseDate: String) {
        this.releaseDate = releaseDate
    }

    fun getVideo(): Boolean? {
        return video
    }

    fun setVideo(video: Boolean?) {
        this.video = video
    }

}

        **/