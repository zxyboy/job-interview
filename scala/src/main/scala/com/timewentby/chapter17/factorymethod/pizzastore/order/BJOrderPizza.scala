package com.timewentby.chapter17.factorymethod.pizzastore.order

import com.timewentby.chapter17.factorymethod.pizzastore.pizza.{BJCheesePizza, BJPepperPizza, Pizza}

class BJOrderPizza extends OrderPizza {

  override def createPizza(t: String): Pizza = {

    var pizza: Pizza = null
    if (t.equals("cheese")) {
      pizza = new BJCheesePizza
    } else if (t.equals("pepper")) {
      pizza = new BJPepperPizza
    }
    pizza
  }

}
