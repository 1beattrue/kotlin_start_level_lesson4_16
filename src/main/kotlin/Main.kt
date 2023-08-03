fun main() {
    // Generic functions

    // напишем метод наподобие listOf
    val list = MyArrayList.myListOf(1, "b", "c")

    for (i in 0..<list.size()) println(list.get(i))


    // lateinit var
    val dog = Dog()
    dog.printName()
}