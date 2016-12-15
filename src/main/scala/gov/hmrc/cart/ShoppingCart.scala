package gov.hmrc.cart

import gov.hmrc.fruits.{Apple, Fruit, Orange}
import gov.hmrc.offer.{DisableOffer, EnableOffer, Offer}

import scala.math.BigDecimal.RoundingMode

/**
  * Created by E797240 on 15/12/2016.
  */
class ShoppingCart(offers: Offer = DisableOffer) {


  val prices: Map[Fruit, Double] = Map(Apple -> 0.6, Orange -> 0.25)

  private var fruits = List.empty[Fruit]

  def +=(fruit: Fruit) = fruits = fruits :+ fruit

  def fruitCount = fruits.size

  def cartItemsTotalPrice: Double = {
    def totalForApples = {
      fruits.filter(fruit => fruit == Apple)
        .zipWithIndex
        .filter(elem => elem._2 % 2 == 0)
        .map(elem => elem._2)
        .foldLeft(0D)((t, i) => t + prices(Apple))
    }
    def totalForOranges = {
      fruits.filter(fruit => fruit == Orange)
        .zipWithIndex
        .foldLeft(0D) {
          (total, tuple) =>
            if (Iterator(0, 1).contains(tuple._2 % 3))
              total + prices(Orange)
            else
              total
        }
    }

    offers match {
      case EnableOffer =>
        BigDecimal(totalForApples + totalForOranges).setScale(2, RoundingMode.HALF_UP).toDouble
      case DisableOffer => fruits.foldLeft(0D) { (total, item) =>
        total + prices(item)
      }
    }
  }
}
