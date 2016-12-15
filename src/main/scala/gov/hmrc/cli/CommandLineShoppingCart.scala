package gov.hmrc.cli

import gov.hmrc.cart.ShoppingCart
import gov.hmrc.fruits.{Apple, Orange}

/**
  * Created by E797240 on 15/12/2016.
  */
object CommandLineShoppingCart {
  //The input can be Apple,Apple or Apple,Orange or Apple,Apple,Orange
  def main(inp: Array[String]) = {
    println(s"Items for the cart are ${inp(0)}")
    val items: Array[String] = inp(0).split(",")
    println(s"Number of Items in the cart is ${items.length}")
    val cart = new ShoppingCart
    items foreach (item => {
      var fruit = Vector(Apple, Orange).find(_.toString == item)
      if (fruit.nonEmpty) cart += fruit.get
    })
    println(s"Price of Items in the cart is ${cart.cartItemsTotalPrice}")
  }
}
