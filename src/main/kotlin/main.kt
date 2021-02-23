import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

fun main() {

    println(format("mario", "example.com"))     //Calls a function with argument values.
    println(format("domain.com", "username"))   //Calls a function with switched arguments. No syntax errors, but the result is incorrect.
    println(format(userName = "foo", domain = "bar.com"))       //Calls a function with named arguments.
    println(format(domain = "frog.com", userName = "pepe"))     //When invoking a function with named arguments they can by in any order.

    val greeting = "Kotliner"

    println("Hello $greeting")                  //Prints a string with a variable reference. References in strings start with $.
    println("Hello ${greeting.toUpperCase()}")  //Prints a string with an expression. Expressions start with $ and are enclosed in curly braces.

    val (x, y, z) = arrayOf(5, 10, 15)          //Destructures an Array. The number of variables on the left side matches the
                                                // number of arguments on the right side.
    println("x: $x, y: $y, z: $z")

    val map = mapOf("Alice" to 21, "Bob" to 25)
    for ((name, age) in map) {                  //Maps can be destructured as well. name and age variables are mapped to the map key and value.
        println("$name is $age years old")
    }

    val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))    //Built-in Pair and Triple types support destructuring too, even as return values from functions.
    println("min: $min, max: $max")

    val user = getUser()
    val (username, email) = user             //Destructures an instance. Declared values are mapped to the instance fields.
    println(username == user.component1())   //Data class automatically defines the component1() and component2() methods that will be called during destructuring.
    println(email == user.component2())

    val (_, emailAddress) = getUser()        //Use underscore if you don't need one of the values, avoiding the compiler hint indicating an unused variable.
    println(emailAddress)

    val (num, name) = Pair(1, "one")             //Destructures an instance of this class the same way as for built-in Pair.

    println("num = $num, name = $name")

    println("Smart Casts")

    val date: ChronoLocalDate? = LocalDate.now()    //Declares a nullable variable.

    if (date != null) {
        println(date.isLeapYear)                    //Smart-cast to non-nullable (thus allowing direct access to isLeapYear).
    }

    if (date != null && date.isLeapYear) {   //Smart-cast inside a condition (this is possible because, like Java, Kotlin uses short-circuiting).
        println("It's a leap year!")
    }

    if (date == null || !date.isLeapYear) {         //Smart-cast inside a condition (also enabled by short-circuiting).
        println("There's no Feb 29 this year...")
    }

    if (date is LocalDate) {
        val month = date.monthValue                 //Smart-cast to the subtype LocalDate.
        println(month)
    }

}

fun format(userName: String, domain: String) = "$userName@$domain"

fun findMinMax(list: List<Int>): Pair<Int?, Int?> {
    val min = list.minOrNull()
    val max = list.maxOrNull()
    return Pair(min, max)
}

fun getUser() = User("Mary", "mary@somewhere.com")