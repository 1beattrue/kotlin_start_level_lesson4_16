interface MyList<T> { // стоит заметить, что можно вставлять несколько букв через ",": <T, R, ...> (например, если бы мы реализовывали Map)
    fun get(index: Int): T
    fun add(element: T)
    fun remove(element: T)
    fun removeAt(index: Int)
    fun size(): Int
}