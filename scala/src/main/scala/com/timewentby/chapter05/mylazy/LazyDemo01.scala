package com.timewentby.chapter05.mylazy

object LazyDemo01 {


  def main(args: Array[String]): Unit = {
    lazy val res = sum(10, 20)
    println("-----------------")
    println("res=" + res) //在要使用res 前，才执行

    var a3 = 10
  }

  //sum函数，返回和
  def sum(n1: Int, n2: Int) = {
    println("sum() 执行了..") //输出一句话
    n1 + n2
  }

}
