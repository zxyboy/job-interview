package com.timewentby.chapter17.simplefactory.pizzastore.order

import com.timewentby.chapter17.simplefactory.pizzastore.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks._
class OrderPizza {

  var orderType: String = _
  var pizza: Pizza = _
  breakable {
    do {
      println("请输入pizza的类型 使用简单工厂模式~~")
      orderType = StdIn.readLine()
      pizza = SimpleFactory.createPizza(orderType)
      if (pizza == null) {
        break()
      }
      this.pizza.prepare()
      this.pizza.bake()
      this.pizza.cut()
      this.pizza.box()
    } while (true)
  }
}
