package com.timewentby.chapter08.homework

object Exercise04 {
  def main(args: Array[String]): Unit = {
    //type 可以用于给类型取别名
    // 给Int 取了别名
    type MyInt = Int
    val num1: MyInt = 888
    println("num1=" + num1)

    println(Suits)
    //测试
//    println(Suits.isRed(Suits.Heart)) // true
//    println(Suits.isRed(Suits.Spade)) // false
  }
}

object Suits extends Enumeration {
  // 给Value 类型取别名
  type Suits = Value
  //创建了一个Value 对象
  val Spade = Value("♠")
  val Club = Value("♣")
  val Heart = Value("♥")
  val Diamond = Value("♦")

  //..
//  override def toString(): String = { //重写toString方法
//    Suits.values.mkString(",") // ♣,♦,♥,♠
//  }
//
//  def isRed(card: Suits) = {
//    if (suit == Heart || suit == Diamond) {
//      true
//    } else {
//      false
//    }
//    card == Heart || card == Diamond
//  }
}
