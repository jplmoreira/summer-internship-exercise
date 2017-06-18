package com.premiumminds.internship.motionblur

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by acamilo on 18-04-2016.
  */
object MotionBlurSingleThread extends MotionBlurFactory {
  /**
    * Method to start processing the data, this one uses only the current thread
    * @param data matrix of integers
    * @param numberOfWorkers this parameter should be ignored
    * @return matrix of integers
    */
  def run(data: Seq[Seq[Int]], numberOfWorkers: Int) = {
    implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(1))
    Future {
      data.zipWithIndex.map {
        case (line, x) => line.zipWithIndex.map {
          case (_, y) => calculateMotionBlur(data, x, y)
        }
      }
    }
  }
}
