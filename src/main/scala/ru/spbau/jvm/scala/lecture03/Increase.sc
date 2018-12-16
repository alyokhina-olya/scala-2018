def increase(int: Int): Int = int + 1
increase(42)

val increase1: Int => Int = int => int + 1
increase1(42) // increase1.apply(42)

val increase2: Int => Int = _ + 1
increase2(42) // increase2.apply(42)

val increase3: Int => Int = (_: Int) + 1 // val increase3: Function1[Int, Int] = (_: Int) + 1
increase3(42) // increase3.apply(42)