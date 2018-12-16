val append: String => String = (string: String) => string + "suffix"
append("")

val append1: String => CharSequence = append
append1("")

val append2: Nothing => Any = append
// append2("") // compilation error