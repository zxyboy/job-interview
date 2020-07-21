package com.timewentby.chapter11

import scala.collection.mutable

object MutableDemo {
  def main(args: Array[String]): Unit = {
    val arrayBuffer = mutable.ArrayBuffer[Int]()
    val arrayBuffer1 = new mutable.ArrayBuffer[Int]()


    val listBuffer = mutable.ListBuffer[Int](3, 4)

    val stack =  mutable.Stack[Int]()
    stack.push(1)
    stack.push(2,3)

    println(stack.top)
    println(stack)

    Array.ofDim[Int](2,3)


//    val queue = mutable.Queue[Int]()
//
//    queue.enqueue(1)



    //    listBuffer.update(1,99)

    //    listBuffer.remove(0,1)
    //    listBuffer.remove(1,1)
    //    listBuffer -= 1
    //    val buffer = listBuffer.updated(0, 66)
    //    println(listBuffer)
    //    println(buffer)


    //    arrayBuffer.append(1,2)
    //    arrayBuffer.appendAll(listBuffer)
    //    arrayBuffer ++= listBuffer
    ////    println(arrayBuffer)
    //
    //    val value = arrayBuffer.++(listBuffer)
    //
    //    val ints = mutable.ArrayBuffer[Int](1,2).++:(mutable.ListBuffer[Int](3,4))
    //
    //    println(arrayBuffer)
    //    println(ints)
    //    println(listBuffer)
    //    listBuffer.append()
    //    arrayBuffer1.append()

  }
}
