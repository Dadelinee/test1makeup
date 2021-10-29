import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.{double, doubleEmpty, doubleMultColRow, doubleOneCol, empty, multipleSeq, multipleSeqDiff, multipleSeqSame, nonEmpty, oneCol}
class TestMatrix extends AnyFunSuite {

  test("foldLeft on empty matrix returns z") {
    assert(TestFixtures.empty.foldLeft(7)(_ + _) == 7)
  }

  test("foldLeft on nonEmpty matrix returns correct value") {
    assert(TestFixtures.nonEmpty.foldLeft(0)(_ + _) == 6)
  }

  test("ensure seq rows are the same length") {
    try {
      multipleSeqSame
      succeed
    }
  }

    test("ensure seq rows are not same length") {
    try {
      multipleSeqDiff//runs the def
      fail()//fail if they are not the same length
    } catch {
      case ex =>//if they are the same length then do nothing
    }
  }

  test("map on nonEmpty matrix returns correct value") {
    assert(TestFixtures.nonEmpty.map(_ + 1) == MatrixImpl[Int](Seq(2, 3, 4)))
  }

  test("map on empty matrix returns empty matrix") {
    assert(TestFixtures.empty.map(_ + 1) == TestFixtures.empty)
  }

  test("apply on empty matrix returns exception") {
    assertThrows[IndexOutOfBoundsException] {
      TestFixtures.empty.apply(0, 1)
    }
  }

  test("apply on matrix returns correct value") {
    assert(TestFixtures.multipleSeq.apply(1, 3) == 8) //0 based counting
  }

  test("sum on one row matrix returns correct value") {
    assert(nonEmpty.sum(nonEmpty) == (6))
  }

  test("sum on empty matrix returns z") {
    assert(empty.sum(empty) == (0))
  }

  test("sum on one column matrix returns correct value") {
    assert(oneCol.sum(oneCol) == (3))
  }

  test("sum on multiple rows and cols matrix returns correct value") {
    assert(multipleSeq.sum(multipleSeq) == (36))
  }

  test("scale on empty matrix returns empty matrix") {
    assert(doubleEmpty.scale(2.0)(doubleEmpty) == (doubleEmpty))
  }

  test("scale on nonEmpty matrix returns correct values") {
    assert(double.scale(2.0)(double) == (MatrixImpl[Double](Seq(2.0, 4.0, 6.0))))
  }

  test("scale on one col matrix returns correct values") {
    assert(doubleOneCol.scale(2.0)(doubleOneCol) == (MatrixImpl[Double](Seq(2.0), Seq(4.0))))
  }

  test("scale on multiple rows and col matrix returns correct values") {
    assert(doubleMultColRow.scale(2.0)(doubleMultColRow) == (MatrixImpl[Double](Seq(2.0, 4.0, 6.0), Seq(8.0, 10.0, 12.0))))
  }

}
