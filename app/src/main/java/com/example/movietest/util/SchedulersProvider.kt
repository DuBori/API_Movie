package com.example.movietest.util

import io.reactivex.Scheduler

interface SchedulersProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}
