
case class MatrixImpl[A](rows: Seq[A]*) extends Matrix[A] {
  require{  /* DONE ensure all rows have the same length */
    rows.forall(x => x.length == rows.head.length)
    }
  def sum(m: MatrixImpl[Int]): Int = {m.foldLeft(0)(_+_)}
  def scale(s: Double)(m: Matrix[Double]): Matrix[Double] = {m.map(s*_)}
  override def apply(row: Int, col: Int): A = rows(row)(col)
  override def map[B](f: A => B): Matrix[B] = MatrixImpl(rows.map(_.map(f)):_*)//use MatrixImpl to preserve matrix structure. _* allows more than arg
  override def foldLeft[B](z: B)(f: (B, A) => B): B = rows.foldLeft(z)((r, i) => i.foldLeft(r)(f))//don't use MatrixImpl here bc we produce arbitrary result
  //i=current row. r=incoming value
  //For each element j in row i, start with r and successively apply f to r and j to get the new r.
  //z is an arbitrary starting value. r starts as z then moves to inside of the row
}