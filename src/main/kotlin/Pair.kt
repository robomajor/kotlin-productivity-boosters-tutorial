class Pair<K, V>(val first: K, val second: V) {  //Defines a custom Pair class with component1() and component2() methods.
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}