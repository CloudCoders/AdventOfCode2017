package day9

import scalaz._
import Scalaz._

object ApplicativeParser {

  type Parser[A] = String => List[(A, String)]

  def letter(c: => Char): Parser[Char] = { input: String =>
    input.toList match {
      case x :: xs if x == c => List((x, xs.mkString))
      case _ => Nil
    }
  }

  def success[A](x: => A): Parser[A] = { input: String => List((x, input)) }
  def opt[A](p1: Parser[A], p2: Parser[A]): Parser[A] = { input: String => p1(input) ::: p2(input) }

  implicit def functorForParser: Functor[Parser] = new Functor[Parser] {
    override def map[A, B](fa: Parser[A])(f: A => B): Parser[B] = { input: String =>
      for ((x, cs) <- fa.apply(input)) yield (f(x), cs)
    }
  }

  def applicativeForParser: Applicative[Parser] = new Applicative[Parser] {
    override def point[A](a: => A): Parser[A] = success(a)

    override def ap[A, B](fa: => Parser[A])(f: => Parser[A => B]): Parser[B] = { input: String =>
      for ((x, cs1) <- fa.apply(input);
           (y, cs2) <- f.apply(cs1)) yield (y(x), cs2)
    }
  }

  def testing(implicit G: Applicative[Parser]): Parser[Int] =
    (letter('{') |@| testing |@| letter('}') |@| opt(testing, success(0)))
      { (_, a, _, b) => math.max(a+1, b) }

}
