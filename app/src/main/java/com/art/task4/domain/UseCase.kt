package com.art.task4.domain

import java.util.concurrent.Executors
import java.util.concurrent.Future

open class UseCase {
    private val threadsNumber = Runtime.getRuntime().availableProcessors()
    private val executorService = Executors.newFixedThreadPool(threadsNumber)
    private var future: Future<*>? = null

    protected fun execute(block: () -> Unit) {
        future?.cancel(true)
        future = executorService.submit(block)
    }
}