package com.timewentby.chapter17.abstractfactory.pizzastore.pizza

class BJCheesePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "北京奶酪Pizza"
    println(this.name + " preparing..")
  }
}
