package com.timewentby.chapter07.myextends

object ScalaFieldOverrideDetail03 {
  def main(args: Array[String]): Unit = {
    println("hello~")
  }
}

//在A03中，有一个抽象的字段(属性)
//1. 抽象的字段(属性):就是没有初始化的字段(属性)
//2. 当一个类含有抽象属性时，则该类需要标记为abstract
//3. 对于抽象的属性，在底层不会生成对应的属性声明，而是生成两个对应的抽象方法(name name_$eq)
abstract class A03 {
  var name : String  //抽象
  // 抽象方法
  def method(a:String):String
}

class Sub_A03 extends A03 {
  override var name : String = ""

  override def method(a: String): String = ???
}