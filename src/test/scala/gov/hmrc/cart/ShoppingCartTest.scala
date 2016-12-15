package gov.hmrc.cart

import gov.hmrc.UnitSpec
import gov.hmrc.fruits.{Apple, Orange}
import gov.hmrc.offer.EnableOffer
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
    myCart.fruitCount should be(2)
  }

  "MyShoppingCart" should "record the number of apples and oranges as a sum total of 3" in {
    val myCart = new ShoppingCart()
    myCart += Apple
    myCart += Apple
    myCart += Orange
    myCart.fruitCount should be(3)
  }

  "MyShoppingCart" should "add an apple and tell the price as 0.6 when there is no offer" in {
    val myCart = new ShoppingCart()
    myCart += Apple
    myCart.cartItemsTotalPrice should be(0.6)
  }

  "MyShoppingCart" should "add an apple and an orange and tell the price as 0.6 when there is no offer" in {
    val myCart = new ShoppingCart()
    myCart += Apple
    myCart += Orange
    myCart.cartItemsTotalPrice should be(0.85)
  }

  "MyShoppingCart" should "add two apples and an orange and tell the price as 1.45 and the total items should be 3 when there is no offer" in {
    val myCart = new ShoppingCart()
    myCart += Apple
    myCart += Orange
    myCart += Apple
    myCart.cartItemsTotalPrice should be(1.45)
    myCart.fruitCount should be(3)
  }

  "MyShoppingCart" should "accept two apples but should price for only one" in {
    val cart = new ShoppingCart(EnableOffer)
    cart += Apple
    cart.cartItemsTotalPrice should be(0.6)
    cart += Apple
    cart.cartItemsTotalPrice should be(0.6)
  }

  "MyShoppingCart" should "accept three apples but should price for only two" in {
    val cart = new ShoppingCart(EnableOffer)
    cart += Apple
    cart.cartItemsTotalPrice should be(0.6)
    cart += Apple
    cart.cartItemsTotalPrice should be(0.6)
    cart += Apple
    cart.cartItemsTotalPrice should be(1.2)
  }
  "MyShoppingCart" should "accept four apples but should price for only two" in {
    val cart = new ShoppingCart(EnableOffer)
    cart += Apple
    cart.cartItemsTotalPrice should be(0.6)
    cart += Apple
    cart.cartItemsTotalPrice should be(0.6)
    cart += Apple
    cart.cartItemsTotalPrice should be(1.2)
    cart += Apple
    cart.cartItemsTotalPrice should be(1.2)
  }
}