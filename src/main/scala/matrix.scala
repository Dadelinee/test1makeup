trait Matrix[A] {
  def apply(row: Int, col: Int): A         // item access
  def map[B](f: A => B): Matrix[B]         // same structure, transformed items
  def foldLeft[B](z: B)(f: (B, A) => B): B // process items left-to-right, top-to-bottom

}