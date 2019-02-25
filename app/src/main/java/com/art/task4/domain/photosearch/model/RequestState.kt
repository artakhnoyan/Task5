package com.art.task4.domain.photosearch.model

class RequestState private constructor(
		val state: State,
		val msg: String? = null) {
	companion object {
		val LOADED = RequestState(State.SUCCESS)
		val LOADING = RequestState(State.WAITING)
		fun failure(msg: String?) = RequestState(State.FAILURE, msg)
	}
}

enum class State {
	WAITING,
	SUCCESS,
	FAILURE
}
