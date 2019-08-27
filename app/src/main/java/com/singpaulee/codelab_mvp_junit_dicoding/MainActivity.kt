package com.singpaulee.codelab_mvp_junit_dicoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.singpaulee.codelab_mvp_junit_dicoding.model.MainModel
import com.singpaulee.codelab_mvp_junit_dicoding.presenter.MainPresenter
import com.singpaulee.codelab_mvp_junit_dicoding.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.webView

class MainActivity : AppCompatActivity(), MainView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainPresenter: MainPresenter = MainPresenter(this)
        btn_calculate.onClick {
            toast("eaeaaa")
            val length = edt_length.text.toString()
            val height = edt_height.text.toString()
            val width = edt_width.text.toString()

            if (!validation()){
                return@onClick
            }

            val l = length.toDouble()
            val h = height.toDouble()
            val w = width.toDouble()
            mainPresenter.calculateVolume(l, w, h)
            toast("Oit")
        }
    }

    private fun validation(): Boolean {
        if (edt_length.text.isBlank()){
            edt_length.error = "Tidak boleh kosong"
            edt_length.requestFocus()
            return false
        }
        if (edt_height.text.isBlank()){
            edt_height.error = "Tidak boleh kosong"
            edt_height.requestFocus()
            return false
        }
        if (edt_width.text.isBlank()){
            edt_width.error = "Tidak boleh kosong"
            edt_width.requestFocus()
            return false
        }
        return true
    }

    override fun showVolume(model: MainModel) {
        tv_result.text = model.volume.toString()
    }
}
