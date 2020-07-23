package com.mason.leetcode.struct

import java.util.*

/**
 * Created by mwu on 2020/6/10
 */
@Suppress("UNCHECKED_CAST")
class Heap<T : Comparable<T>>
@JvmOverloads constructor(
    // 数组总容量
    private var capacity: Int = 10,
    isBig: Boolean = false,
    array: Array<Any> = emptyArray()
) {
    // 数组中元素的个数
    private var size = 0

    // 数组
    private var objs: Array<Any?> = arrayOf()

    // 修改计数器
    @Transient
    private var modCount: Int = 0 // non-private to simplify nested class access

    // 比较器
    private var comparator: Comparator<T>? = null

    // 最大容量
    private val MAX_ARRAY_SIZE: Int = Int.MAX_VALUE - 8

    init {
        this.objs = arrayOfNulls(this.capacity)
        if (array.isNotEmpty()) {
            if (array.size >= capacity) {
                grow(capacity + 1)
            }
            System.arraycopy(array, 0, this.objs, 0, array.size)
            heapify()
        }
        if (isBig) this.comparator = Collections.reverseOrder()
    }

    fun heapify() {
        for (i in (size ushr 1) - 1 downTo 0) siftDown(i, objs[i])
    }

    private fun siftDown(index: Int, value: Any?) {
        if (comparator != null) siftDownUsingComparator(index, value) else siftDownComparable(index, value)
    }

    private fun siftDownUsingComparator(index: Int, value: Any?) {
        val localComparator = this.comparator ?: throw RuntimeException("comparator is null")
        val key: Comparable<T?> = value as Comparable<T?>
        val half = size ushr 1
        var tempIndex = index
        while (tempIndex < half) {
            var child: Int = (tempIndex shl 1) + 1
            var c: Any = objs[child] as T
            val right = child + 1
            if (right < size &&
                localComparator.compare(c as T, objs[right] as T) > 0
            ) c = objs[right.also { child = it }] as T
            if (localComparator.compare(key as T, c as T) <= 0) break
            objs[tempIndex] = c
            tempIndex = child
        }
        objs[tempIndex] = key
    }

    private fun siftDownComparable(index: Int, value: Any?) {
        val key: Comparable<T?> = value as Comparable<T?>
        var tempIndex = index
        val half = size ushr 1 // loop while a non-leaf
        while (tempIndex < half) {
            var child = (tempIndex shl 1) + 1 // assume left child is least
            var c = objs[child] as T
            val right = child + 1
            if (right < size && c > objs[right] as T) c = objs[right.also { child = it }] as T
            if (key <= c) break
            objs[tempIndex] = c
            tempIndex = child
        }
        objs[tempIndex] = key
    }

    private fun siftUp(index: Int, value: T) {
        if (comparator != null) siftUpUsingComparator(index, value) else siftUpComparable(index, value)
    }

    private fun siftUpUsingComparator(index: Int, value: T) {
        val localComparator = this.comparator ?: throw RuntimeException("comparator is null")
        val key: Comparable<T?> = value as Comparable<T?>
        var tempIndex = index
        while (tempIndex > 0) {
            val parent: Int = tempIndex - 1 ushr 1
            val e: Any = objs[parent] as T
            if (localComparator.compare(key as T, e as T) >= 0) break
            objs[tempIndex] = e
            tempIndex = parent
        }
        objs[tempIndex] = key
    }

    private fun siftUpComparable(index: Int, value: T) {
        val key: Comparable<T?> = value as Comparable<T?>
        var tempIndex = index
        while (tempIndex > 0) {
            val parent = (tempIndex - 1) ushr 1
            val e: T = objs[parent] as T
            if (key >= e) break
            objs[tempIndex] = e
            tempIndex = parent
        }
        objs[tempIndex] = key
    }

    fun offer(e: T): Boolean {
        modCount++
        val i = size
        if (i >= capacity) grow(i + 1)
        size = i + 1
        if (i == 0) objs[0] = e else siftUp(i, e)
        return true
    }

    fun peek(): T? {
        return if (size == 0) null else objs[0] as T
    }

    fun poll(): T? {
        if (size == 0) return null
        val s = --size
        modCount++
        val result: T = objs[0] as T
        val x: T = objs[s] as T
        if (s != 0) siftDown(0, x)
        return result
    }

    private fun grow(minCapacity: Int) {
        val oldCapacity: Int = capacity
        // Double size if small; else grow by 50%
        capacity = oldCapacity + if (oldCapacity < 64) oldCapacity + 2 else oldCapacity shr 1
        // overflow-conscious code
        if (capacity - MAX_ARRAY_SIZE > 0)
            capacity = hugeCapacity(minCapacity)
        objs = Arrays.copyOf<Any>(objs, capacity)
    }

    private fun hugeCapacity(minCapacity: Int): Int {
        if (minCapacity < 0) throw OutOfMemoryError()
        return if (minCapacity > MAX_ARRAY_SIZE) Int.MAX_VALUE else MAX_ARRAY_SIZE
    }

    fun capacity(): Int {
        return capacity
    }

    fun size(): Int {
        return size
    }

    override fun toString(): String {
        return objs.contentToString()
    }
}

fun main() {
    val heap = Heap<Int>(isBig = true)
    val random = Random()
    repeat(1000) {
        heap.offer(random.nextInt(100) + 1)
    }
    println(heap.capacity())
    println(heap.size())
}