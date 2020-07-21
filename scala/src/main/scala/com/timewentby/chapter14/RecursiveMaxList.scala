package com.timewentby.chapter14

object RecursiveMaxList {

  def main(args: Array[String]): Unit = {
    val list = List(1, 3, 4, 5)
    val max = maxList(list)
    println(max)

    val a  = 5

    val b:Int = a + 5

    val str = "abcd"
    val str1 = strReverse(str)
    println(str1)

    val i = factorial(5)
    println(i)

    val i1 = fibonacci(5)
    println(i1)
  }


  def fibonacci(n: Int): Int = {
    if (n == 1 || n == 2) {
      1
    } else {
      fibonacci(n - 1) + fibonacci(n - 2)
    }
  }


  /**
   * 阶乘
   *
   * @param n
   * @return
   */
  def factorial(n: Int): Int = {
    if (n == 1) {
      1
    } else {
      n * factorial(n - 1)
    }
  }

  /**
   * 字符串翻转
   *
   * @param str
   * @return
   */
  def strReverse(str: String): String = {
    if (str.length == 1) {
      str
    } else {
      // 从后往前
      //      str.last .toString + strReverse(str.dropRight(1))
      strReverse(str.tail) + str.head
    }
  }

  /**
   * 集合最大值
   *
   * @param list
   * @return
   */
  def maxList(list: List[Int]): Int = {
    if (list.isEmpty) {
      throw new java.util.NoSuchElementException
    } else if (list.size == 1) {
      list.head
    } else {
      if (list.head > maxList(list.tail)) {
        list.head
      } else {
        maxList(list.tail)
      }
    }
  }
}
