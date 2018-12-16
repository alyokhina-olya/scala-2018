package ru.spbau.jvm.scala.lecture05;

import static ru.spbau.jvm.scala.lecture05.ComplexNumber$.MODULE$;

public class JavaMain {

    public static void main(String[] args) {
        ComplexNumber number = MODULE$.apply(
                MODULE$.apply$default$1(),
                MODULE$.apply$default$2()
        );

        System.out.println(number);
        System.out.println("ComplexNumber(" + number.x() + " " + number.y() + ")");

        number.x_$eq(1);
        number.y_$eq(1);
        System.out.println(number);

        MODULE$.Zero().$plus$eq(number);
        System.out.println(MODULE$.Zero());

        System.out.println(MODULE$.One().apply(true));
        MODULE$.One().update(true, 1);
        System.out.println(MODULE$.One().apply(true));

        System.out.println(MODULE$.I().apply(false));
        MODULE$.I().update(false, MODULE$.I().apply(false) + 1);
        System.out.println(MODULE$.I().apply(false));
    }
}
