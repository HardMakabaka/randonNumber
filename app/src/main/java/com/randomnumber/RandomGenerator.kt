package com.randomnumber

import kotlin.random.Random

object RandomGenerator {

    fun generate(min: Long, max: Long): Long {
        require(min <= max) { "最小值不能大于最大值" }
        return Random.nextLong(min, max + 1)
    }

    fun generateMultiple(min: Long, max: Long, count: Int): List<Long> {
        require(min <= max) { "最小值不能大于最大值" }
        require(count > 0) { "生成数量必须大于0" }
        return List(count) { Random.nextLong(min, max + 1) }
    }
}
