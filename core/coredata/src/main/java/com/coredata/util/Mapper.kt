package com.coredata.util

interface Mapper<in I, out O> {
    fun map(input: I): O
}
