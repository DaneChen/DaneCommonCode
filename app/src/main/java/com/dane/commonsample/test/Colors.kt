package com.dane.commonsample.test

/**
 * @author chengr
 * description:
 * create on 2021/3/10
 */
enum class Colors(val r:Int, val g:Int, val b:Int) {

    RED(255, 0, 0), Org(255, 165, 0), Yellow(255, 255, 0), Green(0, 255, 0);

    fun rgb()= (r*256 + g)*256 + b

}