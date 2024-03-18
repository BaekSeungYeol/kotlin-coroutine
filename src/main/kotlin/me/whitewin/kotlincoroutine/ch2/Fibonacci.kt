package me.whitewin.kotlincoroutine.ch2

import java.math.BigInteger

fun main() {

    val fibonacci = sequence<BigInteger> {
        var first = 0.toBigInteger()
        var second = 1.toBigInteger()
        while(true) {
            yield(first)
            val temp = first
            first += second
            second = temp
        }
    }

    print(fibonacci.take(10).toList())
}
