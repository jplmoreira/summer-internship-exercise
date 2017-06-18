package com.premiumminds.internship.motionblur

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by acamilo on 18-04-2016.
  */
object MotionBlurMultiThread extends MotionBlurFactory {
  /**
    * Method to start processing the data, this one should work in parallel
    * @param data matrix of integers
    * @param numberOfWorkers number of threads that should work in parallel
    * @return matrix of integers
    */
  override def run(data: Seq[Seq[Int]], numberOfWorkers: Int) = {
    implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(numberOfWorkers))
    Future {
      data.zipWithIndex.map {
        case (line, x) => line.zipWithIndex.map {
          case (_, y) => calculateMotionBlur(data, x, y)
        }
      }
    }
  }
}
