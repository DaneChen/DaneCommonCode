package com.dane.toollib.util

/**
 * @author chengr
 * description:
 * create on 2020/12/11
 */
class TestData {

    var innerClass:InnerClass = InnerClass()
    var outName:String = "122"

     fun test1(){
        var namedata = Name(0, 1, 22)
         innerClass.innerClassName
    }

    data class Name(var name1:Int, var name2:Int, var name3:Int)

    open inner class InnerClass{
        var innerClassName:String ?= null
        open fun innerTest(){

        }
    }

    inner class InnerClass2 : InnerClass(){
        fun innerTest2(){
            test1()
        }

        override fun innerTest(){

        }

    }

}