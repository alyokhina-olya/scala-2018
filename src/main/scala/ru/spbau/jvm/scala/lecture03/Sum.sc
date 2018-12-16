def sum(left: Int)(right: Int): Int = left + right
sum(42)(42)

val sum1: Function2[Int, Int, Int] = _ + _
sum1(42, 42) // sum1.apply(42, 42)

val sum2: (Int, Int) => Int = {
  case (left, right) => right + left // named syntax
}
sum2(42, 42) // sum2.apply(42, 42)

val sum3: Function1[Tuple2[Int, Int], Int] = tuple => tuple._1 + tuple._2 // to be avoided: tuple properties usage
sum3(42, 42) // sum3.apply((42, 42))

val sum4 = (tuple: (Int, Int)) => {
  val (left, right) = tuple
  left + right
}
sum4(42, 42) // sum4.apply((42, 42))

// "currying"
val oneBind = sum(42) _
oneBind(42) // oneBind.apply(42)

val bothBind = sum(_: Int)(_: Int)
bothBind(42, 42) // bothBind.apply(42, 42)