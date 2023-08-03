class MyArrayList<T> : MyList<T> {
    private var array = arrayOfNulls<Any>(10) // здесь не можем использовать <T>, ибо нужно знать сколько выделять памяти (нужно указать именно класс)
    private var size = 0

    companion object {
        fun <R> myListOf(vararg elements: R): MyArrayList<R> {
            val list = MyArrayList<R>()
            for (element in elements) list.add(element)
            return list
        }
    }

    override fun get(index: Int): T {
        if (index in 0..<size) array[index]?.let { return it as T }
        throw IndexOutOfBoundsException()
    }

    override fun add(element: T) {
        if (size >= array.size) array = array.copyOf(array.size + 10)
        array[size++] = element
    }

    override fun remove(element: T) {
        if (element !in array) return
        val index = array.indexOf(element)
        removeAt(index)
    }

    override fun removeAt(index: Int) {
        if (index in 0..<size) {
            for (i in index..<size - 1) array[i] = array[i + 1]
            array[size-- - 1] = null
            if (size <= array.size - 10) array = array.copyOf(array.size - 10)
            return
        }
        throw IndexOutOfBoundsException()
    }

    override fun size(): Int {
        return size
    }
}