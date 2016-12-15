package gov.hmrc.cart

import gov.hmrc.UnitSpec
import gov.hmrc.fruits.{Apple, Orange}

/**
  * Created by E797240 on 15/12/2016.
  */
class ShoppingCartTest extends UnitSpec {
  "MyShoppingCart" should "add apples and oranges" in {
    val myCart = new ShoppingCart()
    myCart += Apple
    myCart += Apple
    myCart += Orange
    myCart += Apple
  }

  "MyShoppingCart" should "record the number of apples as two" in {
    val myCart = new ShoppingCart()
    myCart += Apple
    myCart += Apple
    myCart.itemCount should be(2)
  }

  "MyShoppingCart" should "record the number of apples and oranges as a sum total of 3" in {
    val myCart = new ShoppingCart()
    myCart += Apple
    myCart += Apple
    myCart += Orange
    myCart.itemCount should be(3)
  }
}