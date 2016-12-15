package gov.hmrc.cart

import gov.hmrc.fruits.Fruit

/**
  * Created by E797240 on 15/12/2016.
  */
class ShoppingCart() {

  private var items = List.empty[Fruit]

  def +=(item: Fruit) = items = items :+ item
}
