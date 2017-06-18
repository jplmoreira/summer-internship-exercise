package com.premiumminds.internship.motionblur

import scala.concurrent.Future
import scala.math.round

/**
  * Created by acamilo on 18-04-2016.
  */
trait MotionBlurFactory {
  /**
    * Method to start processing the data
    * @param data matrix of integers
    * @param numberOfWorkers number of threads that should work in parallel
    * @return matrix of integers
    */
  def run(data: Seq[Seq[Int]], numberOfWorkers: Int): Future[Seq[Seq[Int]]]

  /**
    * Method to calculate motionblur on a given coordinate of a matrix
    * @param data matrix of integers
    * @param x line index of matrix
    * @param y column index of matrix
    * @return integer resulting of motionblur calculation
    */
  def calculateMotionBlur(data: Seq[Seq[Int]], x: Int, y: Int): Int = {
    var total: Float = 0
    var avg: Int = 1
    if (x > 0) {
      total += data(x-1)(y)
      avg += 1
    }
    if (x < data.length - 1) {
      total += data(x+1)(y)
      avg += 1
    }
    if (y > 0) {
      total += data(x)(y-1)
      avg += 1
    }
    total += data(x)(y)
    return round(total/avg)
  }
}
