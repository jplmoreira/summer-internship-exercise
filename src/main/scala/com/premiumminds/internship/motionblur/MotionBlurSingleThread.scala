package com.premiumminds.internship.motionblur

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
  def run(data: Seq[Seq[Int]], numberOfWorkers: Int) = ???
}
