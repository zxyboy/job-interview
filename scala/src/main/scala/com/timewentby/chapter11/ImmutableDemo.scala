package com.timewentby.chapter11

object ImmutableDemo {
  def main(args: Array[String]): Unit = {

    val vector = Vector(2, 1, 4, 5, 6)
    val list = List(1, 2, 4, 5)

    val map = Map("b" -> 1, "a" -> 2)

    val tuples = Vector(2, 1, 4, 5, 6).zipWithIndex.unzip
    println(tuples)


    val xs = Seq(
      (1, "one", '1'),
      (2, "two", '2'),
      (3, "three", '3')).unzip3

    println(xs)

    // xs == ($Coll(1, 2, 3),
    //        $Coll(one, two, three),
    //        $Coll(1, 2, 3))

    //  (((0-1)-2)-3)-4)-5=-15
    //    val i = Vector(1, 2, 3, 4, 5).aggregate(0)(_ - _, _ + _)
    //    println(i)
    //
    //    val string = List(1, 2, 3, 4).aggregate(new java.lang.StringBuffer)(_ append _, _ append _).toString
    //    println(string)
    //    val iterator = Vector(2, 1, 4, 5,6).sliding(2,2)
    //    println(iterator.mkString)


    //    val ints = list.drop(2)
    //    println(ints)
    //    val ints1 = list.dropRight(2)
    //    println(ints1)
    //
    //    val ints2 = list.dropWhile(_ < 4)
    //    println(ints2)

    //    val ints = Vector(2, 1, 4, 5).updated(2, 22)
    //    println(ints)
    //    val ints1 = list.updated(2, 22)
    //    println(ints1)

    //    val vector1 = Vector(2, 1, 4, 5) ++ (List(1, 2, 4, 5))
    //    println(vector1)
    //    println(vector)

    //    val str =  List(1, 2, 4, 5) + ("hello")
    //    println(str)


    //    val ints = vector.+:(6)
    //    val ints2 = 6 +: vector
    //    ints.foreach(println(_))
    //    println("--------")
    //    ints2.foreach(println(_))
    //    val list1 = list :+ 6
    //    val ints1 = 7 +: list
    //    println("--------")
    //    list1.foreach(println(_))


    //    Vector("b" -> 1,"a" -> 2).sortBy(x => x._1).foreach(println(_))
    //    Vector(2, 1,4, 5).sorted.foreach(println(_))
    //    List("Steve", "Tom", "John", "Bob").sortWith(_.compareTo(_) < 0)
    // List("Bob", "John", "Steve", "Tom")
  }
}
