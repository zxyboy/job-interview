package com.timewentby.chapter17.simplefactory.pizzastore.pizza

class CheesePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "奶酪pizza"
    println(this.name + " preparing")
  }
}
