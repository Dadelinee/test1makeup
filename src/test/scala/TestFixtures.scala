object TestFixtures {

    val empty = MatrixImpl[Int]()
    val nonEmpty = MatrixImpl[Int](Seq(1,2,3))
    val oneCol = MatrixImpl[Int](Seq(1),Seq(2))
    val multipleSeq = MatrixImpl[Int](Seq(1,2,3,4),Seq(5,6,7,8))
    def multipleSeqDiff = MatrixImpl[Int](Seq(1,2,3,4),Seq(5,6,7,8))
    def multipleSeqSame = MatrixImpl[Int](Seq(1,2,3), Seq(4,5,6))
    val double = MatrixImpl[Double](Seq(1.0,2.0,3.0))
    val doubleOneCol = MatrixImpl[Double](Seq(1.0), Seq(2.0))
    val doubleMultColRow = MatrixImpl[Double](Seq(1.0,2.0,3.0), Seq(4.0, 5.0, 6.0))
    val doubleEmpty = MatrixImpl[Double]()
    //won't immediately run the require method like val would.
    //def makes it so it's not invoked until you use it (like in the test)

}
