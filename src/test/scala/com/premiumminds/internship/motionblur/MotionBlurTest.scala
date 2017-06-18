package com.premiumminds.internship.motionblur

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by acamilo on 18-04-2016.
  */
@RunWith(classOf[JUnitRunner])
class MotionBlurTest extends FunSuite {
  /**
    * The corresponding implementations to test.
    *
    * If you want, you can make others :)
    *
    */
  val implementations: Map[String, MotionBlurFactory] =
    Map("single thread" -> MotionBlurSingleThread,
        "multi thread" -> MotionBlurMultiThread)

  implementations.foreach { case (name, implementation) =>

    test(s"[$name] Motion blur with M1=\n${prettyPrint(MatrixData.M1)}\n") {
      val step1 = implementation.run(MatrixData.M1, 5)
      val result1 = Await.result(step1, 10.seconds)

      assert(result1 === List(
        List(3, 3, 4),
        List(4, 5, 6),
        List(6, 7, 8)
      ))
    }

    test(s"[$name] Motion blur with M2=\n${prettyPrint(MatrixData.M2)}\n") {
      val step2 = implementation.run(MatrixData.M2, 5)
      val result2 = Await.result(step2, 10.seconds)
      
      assert(result2 === List(
        List(11, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 12, 13, 13, 13),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(7, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11),
        List(14, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
        List(11, 14, 13, 13, 13, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 8, 8, 8)
      ))
    }

    test(s"[$name] Motion blur with M3=\n${prettyPrint(MatrixData.M3)}\n") {
      val step3 = implementation.run(MatrixData.M3, 5)
      val result3 = Await.result(step3, 10.seconds)

      assert(result3 === List(
        List(2, 2, 3, 4, 5),
        List(2, 3, 4, 5, 6),
        List(3, 4, 5, 6, 7),
        List(4, 4, 5, 6, 7)
      ))
    }
  }

  def prettyPrint(data: Seq[Seq[Int]]) = data.map(_.mkString(" ")).mkString("\n")
}
