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
}