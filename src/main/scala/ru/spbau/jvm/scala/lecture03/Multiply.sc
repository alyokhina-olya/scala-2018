val multiply: PartialFunction[(Int, Int), Int] = (_: (Int, Int)) match {
  case (0, _) |
       (_, 0) => 0
  case (left, right) => right * left
}

multiply(0, 1) // autotupling
multiply((0, 1): (Int, Int)) // multiply.apply((0, 1))