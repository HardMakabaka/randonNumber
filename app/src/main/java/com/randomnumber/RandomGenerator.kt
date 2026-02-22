package com.randomnumber

import kotlin.random.Random

object RandomGenerator {

    fun generate(min: Long, max: Long): Long {
        require(min <= max) { "最小值不能大于最大值" }
        return Random.nextLong(min, max + 1)
    }
}
