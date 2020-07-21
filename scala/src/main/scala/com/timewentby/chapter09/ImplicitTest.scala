package com.timewentby.chapter09

object ImplicitTest {


  def main(args: Array[String]): Unit = {
    implicit val name = "xiaoming"
    implicit val a = "xiaoming"

    def hello(implicit name: String = "worka") = {
      println(s"hello $name")
    }
//    hello
  }


}

