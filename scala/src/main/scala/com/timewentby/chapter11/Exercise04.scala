package com.timewentby.chapter11

import scala.math.Ordering


object Exercise04 {

  implicit  val sorted: Ordering[Int] = (x: Int, y: Int) => Integer.compare(y, x)

  def main(args: Array[String]): Unit = {
    val lines = List("hello world", "hello world", "1 2 3", "what is your name ?")

    val map = lines.flatMap(_.split(" "))
      .map((_, 1))
      .groupBy(_._1)
      .map(item => (item._1, item._2.size))
      .toList
      .sortBy[Int](_._2)


    println(map)
  }
}
