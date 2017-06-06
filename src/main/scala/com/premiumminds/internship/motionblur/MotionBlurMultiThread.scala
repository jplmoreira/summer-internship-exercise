package com.premiumminds.internship.motionblur

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
  override def run(data: Seq[Seq[Int]], numberOfWorkers: Int) = ???
}
