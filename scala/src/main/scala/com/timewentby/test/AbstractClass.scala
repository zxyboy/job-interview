package com.timewentby.test

object AbstractClass {

  def main(args: Array[String]): Unit = {
    val a = new A with B {
      override def hello(s: String): String = {
        s
      }
      override def hi: Unit = {
        println("hi")
      }
    }
    a.hi
    a.hello("hello")
  }

  abstract class A {
    def hello(s: String): String
  }

  trait B {
    def hi
  }

}
