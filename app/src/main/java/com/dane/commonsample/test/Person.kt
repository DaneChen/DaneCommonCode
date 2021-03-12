package com.dane.commonsample.test

/**
 * @author chengr
 * description:
 * create on 2021/3/10
 */
class Person (var name:String, var isMarried:Boolean){


    var isGraduate:Boolean?
    get()=true

    init {
        isGraduate = false
    }

    fun personFunc(){

    }
}