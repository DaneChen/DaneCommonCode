package com.dane.commonsample.UI

import android.util.Log
import com.dane.commonsample.test.Colors
import com.dane.commonsample.test.Person
import com.dane.commonsample.test.kotlinFunc
import java.io.BufferedReader

/**
 * @author chengr
 * description:
 * create on 2021/3/10
 */
class TestKotlin {
    companion object{

        private const val TAG = "TestKotlin";

        public fun testBaseDataType(){
            testVal()
            testObject()
            testColor()
            testCircle(2, 10)
            testMap()
            testArrayList()
            testStringExtFunc()
            testPartialFunction()
        }

        private fun max(a:Int, b:Int):Int{
            return if( a> b) a else b
        }

        private fun max2(a:Int, b:Int):Int = if( a> b) a else b

        private fun max3(a:Int, b:Int)= if( a> b) a else b

        private fun testVal(){
            val result:String
            result = if(isSuccess()) "true" else "false"
            Log.d(TAG, "testVal".plus(result))
            Log.d(TAG, "testVal $result")
        }

        private fun isSuccess() = true

        private fun testObject(){
            var person = Person("name", false)
            Log.d(TAG, "testObject ${person.isGraduate}")
        }

        private fun testColor(){
            Log.d(TAG, "testColor ${Colors.Green.rgb()}")
            Log.d(TAG, "testColor:getstring= ${getColorString(Colors.Yellow)}")
        }

        private fun getColorString(colors: Colors) =
                when (colors) {
                    Colors.Green, Colors.Org -> "1111"
                    Colors.RED, Colors.Yellow -> "22222"
                }

        private fun testCircle(startValue:Int, endValue:Int){

            for( i in startValue..endValue step 2) {
                Log.d(TAG, "testCircle=${i}")
            }

            for( i in endValue downTo startValue step 1) {
                Log.d(TAG, "testCircle=${i}")
            }

            for( i in (startValue until endValue).reversed() step 1) {
                Log.d(TAG, "testCircle=${i}")
            }

            var testI = 7
            if( testI in 6 until 7){
                Log.d(TAG, "testCircle=${testI} in (6..7)")
            }

        }

        private fun testMap(){
            var binaryMap = HashMap<Char, String>()

            for( c in 'A'..'F'){
                var binary = Integer.toBinaryString(c.toInt())
                binaryMap[c] = binary
            }

            for( (char1, str1) in binaryMap){
                Log.d(TAG, "testMap=${char1}=${str1}")
            }

            for( char1 in binaryMap.keys){
                Log.d(TAG, "testMap,key=${char1}")
            }

            var iterator = binaryMap.iterator()
            while (iterator.hasNext()){
                iterator.next()
                iterator.remove()
            }
            for( char1 in binaryMap.keys){
                Log.d(TAG, "testMap1,key=${char1}")
            }
        }


        private fun testException(reader:BufferedReader){
            val  line = reader.readLine()
            reader.close()

            var testStr = try {
                "abc"
            }catch (e:Exception){
                ""
            }
        }

        private fun testArrayList(){
            var dataList = ArrayList<String>()

            var tempList = listOf("1", "2", "3")
            dataList.addAll(tempList)
            Log.d(TAG, "testArrayList,tempList=${tempList.get(1)}")
            Log.d(TAG, "testArrayList,tempList=${tempList.last()}")
            Log.d(TAG, "testArrayList,tempList=${tempList.max()}")

            var result = testJoinToString(tempList, postFix = "}", sep = "%")
            Log.d(TAG, "testArrayList,result=${result}")
        }

        private fun <T> testJoinToString(collection:Collection<T>, sep:String=",", prefix:String="(", postFix:String=")"):String{
            var result : StringBuilder = StringBuilder(prefix)
            for( (a, b) in collection.withIndex()){
                if( a > 0){
                    result.append(sep)
                }
                result.append(b)
            }
            result.append(postFix)
            return result.toString()
        }

        private fun testTopKotlin(){
            kotlinFunc()
        }

        fun String.lastChat():Char{
           return this.get(this.length -1)
        }

        private fun testStringExtFunc(){
            var testStr = "123456"
            Log.d(TAG, "testStringExtFunc,result=${testStr.lastChat()}")
        }

        private fun testPartialFunction(){

            fun plus(a:Int, b:Int):Int{
                return a+b
            }

            Log.d(TAG, "testPartialFunction,result=${plus(1, 2)}")
            Log.d(TAG, "testPartialFunction,result=${plus(3, 4)}")
        }
    }

}