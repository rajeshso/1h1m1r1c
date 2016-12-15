package gov.hmrc.cart

import gov.hmrc.fruits.{Apple, Fruit, Orange}

/**
  * Created by E797240 on 15/12/2016.
  */
class ShoppingCart() {

  val prices: Map[Fruit, Double] = Map(Apple -> 0.6, Orange -> 0.25)

  private var fruits = List.empty[Fruit]

  def +=(fruit: Fruit) = fruits = fruits :+ fruit

  def fruitCount = fruits.size

  def cartItemsTotalPrice: Double = {
    fruits.foldLeft(0.0) { (total, item) =>
      total + prices(item)
    }
  }
}
