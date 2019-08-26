package com.singpaulee.codelab_mvp_junit_dicoding.presenter

import com.singpaulee.codelab_mvp_junit_dicoding.model.MainModel
import com.singpaulee.codelab_mvp_junit_dicoding.view.MainView

class MainPresenter {
    private lateinit var view: MainView

    fun MainPresenter(view: MainView){
        this.view = view
    }

    fun volume(length: Double, width: Double, height: Double): Double {
        return length / width * height
    }

    fun calculateVolume(length: Double, width: Double, height: Double) {
        val volume = volume(length, width, height)
        val model = MainModel(volume)
        view.showVolume(model)
    }
}