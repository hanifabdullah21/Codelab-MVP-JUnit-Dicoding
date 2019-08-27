package com.singpaulee.codelab_mvp_junit_dicoding

import com.singpaulee.codelab_mvp_junit_dicoding.presenter.MainPresenter
import com.singpaulee.codelab_mvp_junit_dicoding.view.MainView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class MainPresenterTest {
    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T

    @Mock
    private var presenter: MainPresenter? = null
    private var view: MainView? = null

    @Before
    fun setUp() {
        view = mock(MainView::class.java)
        presenter = MainPresenter(view!!)
    }


    @Test
    fun testVolumeWithIntegerInput() {
        val volume: Double? = presenter?.volume(2.0, 8.0, 1.0)
        assertEquals(16.0, volume!!, 0.0001)
    }

    @Test
    fun testVolumeWithDoubleInput() {
        val volume = presenter?.volume(2.3, 8.1, 2.9)
        assertEquals(54.026999999999994, volume!!, 0.0001)
    }

    @Test
    fun testVolumeWithZeroInput() {
        val volume = presenter?.volume(0.0, 0.0, 0.0)
        assertEquals(0.0, volume!!, 0.0001)
    }

    @Test
    fun testCalculateVolume() {
        presenter!!.calculateVolume(11.1, 2.2, 1.0)
        verify(view!!).showVolume(any())
    }
}
