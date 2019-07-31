package com.example.simpleapp.view.fragment

import com.example.simpleapp.mockModule.RetrofitMock
import com.example.simpleapp.mockModule.ViewModuleMock
import com.example.simpleapp.mockModule.dataObjectMock.MovieResponseMock
import com.example.simpleapp.mockModule.dataObjectMock.ObserverObjectMock
import com.example.simpleapp.model.data.retrofit.TMDbObservableBuilder
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.view.Fragment.FragmentAction
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import setUpRxSchedulers


class FragmentActionTest {
    @Before
    fun setUp() {
        setUpRxSchedulers()
    }

    @Test
    fun testGetMoviesWithValidResponse() {
        System.out.println("Test Handle  valid move list response")
        val observer = run(MovieResponseMock.Standar_Movies_Response)

        assertEquals(true, observer.completed)
        assertEquals(true, observer.subScribed)
        assertEquals(20, observer.resultList.size)
    }

    @Test
    fun testGetMovieWith_ExtraField() {
        System.out.println("testGetMovieWith_ExtraField")

        val observer = run(MovieResponseMock.Movies_Response_ExtraFields)

        //assert
        assertEquals(true, observer.completed)
        assertEquals(true, observer.subScribed)
        assertEquals(20, observer.resultList.size)
    }

    @Test
    fun testGetMovieWithResponse_MissingField() {
        System.out.println("testGetMovieWithResponse_MissingField")

        val observer = run(MovieResponseMock.Movie_Response_MissingFieds)

        //assert
        assertEquals(true, observer.completed)
        assertEquals(true, observer.subScribed)
        assertEquals(20, observer.resultList.size)
    }

    @Test
    fun testGetMovieWithHttpError() {
        System.out.println("Test Handle API invalid response")
        val observer = run(MovieResponseMock.API_ERROR_Response)

        //assert
        assertEquals(false, observer.completed)
        assertEquals(true, observer.subScribed)
        assertEquals(0, observer.resultList.size)
        assertEquals("The mapper function returned a null value.", observer.errorMessage)
    }

    private fun run(responseString:String):ObserverObjectMock<MovieInfo> {
        val movieApiService = RetrofitMock(responseString).provideMovieApiService()
        val observable = TMDbObservableBuilder(movieApiService).getMoviesObservable()
        val observer: ObserverObjectMock<MovieInfo> = ViewModuleMock().provideMovieObserver()
        //run
        FragmentAction(observable, observer).refreshData()
        return observer
    }
}